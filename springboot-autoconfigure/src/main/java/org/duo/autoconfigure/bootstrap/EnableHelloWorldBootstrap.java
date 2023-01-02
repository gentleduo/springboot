package org.duo.autoconfigure.bootstrap;

import org.duo.autoconfigure.annotation.EnableHelloWorld;
import org.duo.autoconfigure.configuration.HelloWorldAutoConfiguration;
import org.duo.autoconfigure.configuration.HelloWorldConfiguration;
import org.duo.autoconfigure.repository.MyFirstLevelRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * {@link org.duo.autoconfigure.annotation.EnableHelloWorld} 引导类
 *
 * @Auther:duo
 * @Date: 2023-01-01 - 01 - 01 - 20:42
 * @Description: org.duo.autoconfigure.bootstrap
 * @Version: 1.0
 */
@EnableHelloWorld
public class EnableHelloWorldBootstrap {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = new SpringApplicationBuilder(EnableHelloWorldBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        // helloWorld Bean 是否存在
        String helloWorld =
                context.getBean("helloWorld", String.class);

        System.out.println("helloWorld Bean : " + helloWorld);

        HelloWorldConfiguration bean = context.getBean(HelloWorldConfiguration.class);
        System.out.println("HelloWorldConfiguration Bean : " + bean);

        // 关闭上下文
        context.close();
    }
}
