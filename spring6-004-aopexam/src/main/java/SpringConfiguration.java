import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * ClassName:SpringConfiguration
 * Package:PACKAGE_NAME
 * Description:
 *
 */
@Configuration
@ComponentScan({"com.aopexam.service","com.aopexam.aspect"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringConfiguration {
}
