package org.duo.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashSet;
import java.util.Set;

/**
 * {@link SpringApplication} 引导类
 *
 * @author duo
 * @since 2023/1/1
 */
public class SpringApplicationBootstrap {

    public static void main(String[] args) {

//        SpringApplication.run(ApplicationConfiguration.class,args);

        Set<String> sources = new HashSet();
        // 配置Class 名称

        sources.add(ApplicationConfiguration.class.getName());
        SpringApplication springApplication = new SpringApplication();
        springApplication.setWebApplicationType(WebApplicationType.NONE);
        springApplication.setSources(sources);
        springApplication.run(args);

    }

    @SpringBootApplication
    public static class ApplicationConfiguration {

    }

}
