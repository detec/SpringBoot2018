package sample.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Andrii Duplyk
 *
 */
@Configuration
@EnableTransactionManagement
@PropertySource(value = { "classpath:application.properties" })
public class ApplicationConfig {

}
