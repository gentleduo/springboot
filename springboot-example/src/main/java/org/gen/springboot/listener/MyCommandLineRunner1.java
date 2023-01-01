package org.gen.springboot.listener;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 有一些特殊的任务需要在系统启动时执行，例如配置文件加载，数据库初始化等操作。
 * 如果没有SpringBoot，这些问题可以在Listener中解决。
 * SpringBoot对此提供了两种解决方案：CommandLineRunner和ApplicationRunner。
 * 
 * @Order(1)注解用来描述CommandLineRunner的执行顺序，数字越小越先执行。
 * run方法中是调用的核心逻辑，参数是系统启动时传入的参数，即入口类中main方法的参数（在调用SpringApplication.run方法时被传入SpringBoot项目中）
 * 
 * 在Eclipse中配置启动参数时，先选中启动类并右击，选择Run As,再选择Run Configurations，在新打开的页面中选择Arguments选项卡，填入相关参数（多个参数之间用空格隔开）
 */
//@Component
//@Order(1)
public class MyCommandLineRunner1 implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Runner1>>>"+Arrays.toString(args));
    }
}
