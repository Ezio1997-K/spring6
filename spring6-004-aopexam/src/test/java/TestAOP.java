import com.aopexam.biz.UserService;
import com.aopexam.service.OrderService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName:TestAOP
 * Package:PACKAGE_NAME
 * Description:
 *
 */
public class TestAOP {
    @Test
    public void test1(){
        ApplicationContext application = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        OrderService orderService = application.getBean("orderService", OrderService.class);
        orderService.generate();
        orderService.cancel();
    }
    @Test
    public void test2(){
        ApplicationContext application = new ClassPathXmlApplicationContext("spring.xml");
        UserService bean = application.getBean(UserService.class);
        bean.deleteUser();
        bean.modifyUser();
        bean.getUser();
        bean.saveUser();
    }
}
