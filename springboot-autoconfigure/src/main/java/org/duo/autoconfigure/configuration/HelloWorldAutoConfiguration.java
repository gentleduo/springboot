package org.duo.autoconfigure.configuration;


import org.duo.autoconfigure.annotation.EnableHelloWorld;
import org.duo.autoconfigure.condition.ConditionalOnSystemProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * HelloWorld 自动装配
 *
 * @author duo
 * @since 2023/1/1
 */
@Configuration // Spring 模式注解装配
@EnableHelloWorld // Spring @Enable 模块装配
@ConditionalOnSystemProperty(name = "user.name", value = "gentl") // 条件装配
public class HelloWorldAutoConfiguration {

//    @Bean
//    public String sayHi() { // 在@Bean注解上不加名称的话，那么方法名即bean的名称
//        return "hi !!!";
//    }
}
