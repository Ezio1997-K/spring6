import com.learnspring.bank.service.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * ClassName:AppTest
 * Package:PACKAGE_NAME
 * Description:
 *
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:spring.xml")
public class AppTest {
    @Autowired
    private AccountService service;
    @Test
    public void testTrans(){
        System.out.println(service.getAll());
    }
}
