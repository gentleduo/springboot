package org.duo.autoconfigure.bootstrap;

import org.duo.autoconfigure.repository.MyFirstLevelRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "org.duo.autoconfigure.repository")
public class RepositoryBootstrap {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = new SpringApplicationBuilder(RepositoryBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        // myFirstLevelRepository Bean 是否存在
        MyFirstLevelRepository myFirstLevelRepository =
                context.getBean("myFirstLevelRepository", MyFirstLevelRepository.class);

        System.out.println("myFirstLevelRepository Bean : " + myFirstLevelRepository);

        // 关闭上下文
        context.close();
    }
}
