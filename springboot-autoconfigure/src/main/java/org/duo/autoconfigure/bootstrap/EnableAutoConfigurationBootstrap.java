package org.duo.autoconfigure.bootstrap;

import org.duo.autoconfigure.configuration.HelloWorldAutoConfiguration;
import org.duo.autoconfigure.configuration.HelloWorldConfiguration;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * {@link EnableAutoConfiguration} 引导类
 *
 * @author duo
 * @since 2023/1/1
 */
@EnableAutoConfiguration
public class EnableAutoConfigurationBootstrap {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = new SpringApplicationBuilder(EnableAutoConfigurationBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        // helloWorld Bean 是否存在
        String helloWorld =
                context.getBean("helloWorld", String.class);

        System.out.println("helloWorld Bean : " + helloWorld);

//        // helloWorld Bean 是否存在
//        String sayHi =
//                context.getBean("sayHi", String.class);
//
//        System.out.println("sayHi Bean : " + sayHi);
        HelloWorldAutoConfiguration bean = context.getBean(HelloWorldAutoConfiguration.class);
        System.out.println("HelloWorldAutoConfiguration Bean : " + bean);
        // 关闭上下文
        context.close();

    }
}
