package org.duo.webmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

import java.io.File;

/**
 * Spring Boot Web MVC 引导类
 *
 * @author duo
 * @since 2023/1/3
 */
@SpringBootApplication(scanBasePackages = "org.duo.webmvc")
public class SpringBootWebMvcBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebMvcBootstrap.class, args);
    }

}
