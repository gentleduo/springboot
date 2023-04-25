package org.duo.beans.test;

import org.duo.beans.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther:duo
 * @Date: 2023-01-09 - 01 - 09 - 14:53
 * @Description: org.duo.beans.test
 * @Version: 1.0
 */
@SpringBootTest(classes = {Car.class, Driver.class, MyConfig.class, MyComponent.class})
@RunWith(SpringRunner.class)
public class TestApplicationTests {

    @Autowired
    private Car car;

    @Autowired
    private Driver driver;

    @Autowired
    MyConfig config;

    @Autowired
    MyComponent component;

    @Test
    public void contextLoads() {
        boolean result = driver.getCar() == car;
        System.out.println(result ? "同一个car" : "不同的car");


        Hello configHello1 = config.hello();
        Hello configHello2 = config.hello();

        boolean configBool = configHello1 == configHello2;
        System.out.println(configBool ? "同一个Hello" : "不同的Hello");


        Hello componentHello1 = component.hello();
        Hello componentHello2 = component.hello();

        boolean componentBool = componentHello1 == componentHello2;
        System.out.println(componentBool ? "同一个Hello" : "不同的Hello");

    }
}
