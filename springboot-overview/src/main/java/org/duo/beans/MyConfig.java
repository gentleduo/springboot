package org.duo.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther:duo
 * @Date: 2023-01-09 - 01 - 09 - 18:35
 * @Description: org.duo.beans
 * @Version: 1.0
 */
@Configuration
public class MyConfig {

    @Bean
    public Hello hello(){
        return new Hello();
    }
}
