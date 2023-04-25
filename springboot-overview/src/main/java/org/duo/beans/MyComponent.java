package org.duo.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Auther:duo
 * @Date: 2023-01-09 - 01 - 09 - 18:35
 * @Description: org.duo.beans
 * @Version: 1.0
 */
@Component
public class MyComponent {

    @Bean
    public Hello hello(){
        return new Hello();
    }
}