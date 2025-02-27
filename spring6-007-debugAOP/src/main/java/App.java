import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.example.DeAOP;
public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        DeAOP deAOP = context.getBean("deAOP", DeAOP.class);
        deAOP.doSomething();
    }
}
