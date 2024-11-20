package com.myspring.core;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * ClassName:ClassPathXmlApplicationContext
 * Package:com.myspring.core
 * Description:
 */
public class ClassPathXmlApplicationContext implements ApplicationContext {
    //用来存放配置文件中的bean，key为beanid,value为实例化对象
    private Map<String, Object> singletonObjects = new HashMap<>();
    private static final Logger LOGGER = LoggerFactory.getLogger(ClassPathXmlApplicationContext.class);

    /**
     * 根据路径解析xml文件，并初始化所有的bean
     *
     * @param xmlLocation xml文件路径，类路径
     */
    public ClassPathXmlApplicationContext(String xmlLocation) {
        var saxReader = new SAXReader();
        var is = ClassLoader.getSystemClassLoader().getResourceAsStream(xmlLocation);
        try (is) {
            Document document = saxReader.read(is);
            Element rootElement = document.getRootElement();
            //System.out.println(rootElement);
            List<Element> elements = rootElement.elements("bean");
            for (Element element : elements) {
                String id = element.attribute("id").getValue();
                String className = element.attribute("class").getValue();
                LOGGER.info("id:{},class:{}", id, className);
                //通过反射创建Class对象
                Class<?> clazz = Class.forName(className);
                //获取bean的构造方法
                Constructor<?> declaredConstructor = clazz.getDeclaredConstructor();
                //创建bean对象
                Object beanObject = declaredConstructor.newInstance();
                //提前曝光bean对象，并放到map集合
                singletonObjects.put(id, beanObject);
                LOGGER.info("缓存:{}", singletonObjects);
            }
            for (Element element : elements) {
                Class<?> clazz = Class.forName(element.attributeValue("class"));
                String id = element.attributeValue("id");
                //获取bean标签下所有property标签
                List<Element> property = element.elements("property");
                for (Element prop : property) {
                    String name = prop.attribute("name").getValue();
                    //获取属性
                    Field field = clazz.getDeclaredField(name);
                    //获取具体的值
                    String value = prop.attributeValue("value");
                    String ref = prop.attributeValue("ref");
                    LOGGER.info("name:{}", name);
                    //拼接set方法名称
                    String setMethodName = "set" + name.toUpperCase().charAt(0) + name.substring(1);
                    LOGGER.info("set方法为:{}", setMethodName);
                    //获取set方法
                    Method method = clazz.getDeclaredMethod(setMethodName, field.getType());
                    //调用set方法
                    if (value != null) {
                        Class<?> type = field.getType();
                        String simpleName = type.getSimpleName();
                        switch (simpleName) {
                            case "int" -> {
                                int i = Integer.parseInt(value);
                                method.invoke(singletonObjects.get(id), i);
                            }
                            case "Integer" -> {
                                Integer integer = Integer.valueOf(value);
                                method.invoke(singletonObjects.get(id), integer);
                            }
                            default -> method.invoke(singletonObjects.get(id), value);
                        }
                    }
                    if (ref != null) {
                        method.invoke(singletonObjects.get(id), singletonObjects.get(ref));
                    }

                }
            }

            //elements.forEach(System.out::println);
            /*List<Node> nodes = document.selectNodes("//bean");
            nodes.forEach(System.out::println);*/
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public Object getBean(String name) {
        return singletonObjects.get(name);
    }
}
