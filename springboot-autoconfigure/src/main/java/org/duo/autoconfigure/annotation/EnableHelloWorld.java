package org.duo.autoconfigure.annotation;

import org.duo.autoconfigure.configuration.HelloWorldConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 *
 * 激活HelloWorld模块
 *
 * @Auther:duo
 * @Date: 2023-01-01 - 01 - 01 - 20:35
 * @Description: org.duo.autoconfigure.annotation
 * @Version: 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(HelloWorldConfiguration.class)
//@Import(HelloWorldImportSelector.class)
public @interface EnableHelloWorld {
}
