package com.learnspring.client;

import com.example.bean.Student;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName:ComponentScan
 * Package:com.learnspring.client
 * Description:已知包名com.example.bean,扫描com.example.bean下面所有的类，如果带了自定义注解，则给他创造对象
 */
public class ComponentScan {
    public static Map<String, Object> map = new HashMap<>();

    static {
        String name = "com.example.bean";
        //将包名转为路径名
        String pathName = name.replaceAll("\\.", "/");
        //定位资源
        URL url = ClassLoader.getSystemClassLoader().getResource(pathName);
        //获取路径
        String path = url.getPath();
        File file = new File(path);
        File[] files = file.listFiles();
        for (File file1 : files) {
            String className = file1.getName().split("\\.")[0];
            //获取类的全路径名
            String classFullName = name + "." + className;
            try {
                Class<?> aClass = Class.forName(classFullName);
                //判断类是否有MyComponent注解
                if (aClass.isAnnotationPresent(MyComponent.class)) {
                    MyComponent classDeclaredAnnotation = aClass.getDeclaredAnnotation(MyComponent.class);
                    String keyValue = classDeclaredAnnotation.value();
                    Object obj = aClass.getDeclaredConstructor().newInstance();
                    map.put(keyValue, obj);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

}
