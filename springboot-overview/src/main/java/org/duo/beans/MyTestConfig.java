package org.duo.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


/**
 * @Auther:duo
 * @Date: 2023-01-09 - 01 - 09 - 14:26
 * @Description: org.duo.beans
 * @Version: 1.0
 */

@Configuration
//@Component
public class MyTestConfig {

    @Bean
    public Driver driver(){
        Driver driver = new Driver();
        driver.setId(1);
        driver.setName("driver");
        driver.setCar(car());
        return driver;
    }

    @Bean
    public Car car(){
        Car car = new Car();
        car.setId(1);
        car.setName("car");
        return car;
    }
}
