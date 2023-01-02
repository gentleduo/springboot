package org.duo.autoconfigure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * HelloWorld 配置
 *
 * @Auther:duo
 * @Date: 2023-01-01 - 01 - 01 - 20:38
 * @Description: org.duo.autoconfigure.configuration
 * @Version: 1.0
 */
@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String helloWorld() { // 在@Bean注解上不加名称的话，那么方法名即bean的名称
        return "Hello World!!!";
    }
}
