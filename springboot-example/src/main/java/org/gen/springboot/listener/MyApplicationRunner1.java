package org.gen.springboot.listener;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * 有一些特殊的任务需要在系统启动时执行，例如配置文件加载，数据库初始化等操作。
 * 如果没有SpringBoot，这些问题可以在Listener中解决。
 * SpringBoot对此提供了两种解决方案：CommandLineRunner和ApplicationRunner。
 * 
 *  @Order(1)注解用来描述ApplicationRunner的执行顺序，数字越小越先执行。
 *  不同于CommandLineRunner中run方法的String数组参数，这里run方法的参数是一个ApplicationArguments对象，
 *  如果想从ApplicationArguments对象中获取入口类中main方法接收的参数，调用ApplicationArguments中的getNonOptionArgs方法即可。
 *  ApplicationArguments中的getOptionNames方法用来获取项目启动命令行中参数key，
 *  例如将本项目打成jar包，运行java -jar xxx.jar --name=Michael命令启动项目，此时getOptionNames方法获取到的就是name，getOptionValues方法则是获取相应的value。
 *  
 *  运行mvn:package对项目打包后，执行以下命令启动项目：
 *  java -jar springboot.jar --name=Michael --age=99 三国演义 罗贯中
 *  
 *  命令解释：
 *  --name=Michael --age=99都属于getOptionNames/getOptionValues范畴。
 *  后面的"三国演义"  "罗贯中"可以通过getNonOptionArgs方法获取，获取到的是一个数组。
 */
//@Component
//@Order(1)
public class MyApplicationRunner1 implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<String> nonOptionArgs = args.getNonOptionArgs();
        System.out.println("1-nonOptionArgs>>>" + nonOptionArgs);
        Set<String> optionNames = args.getOptionNames();
        for (String optionName : optionNames) {
            System.out.println("1-key:" + optionName + ";value:" +
                    args.getOptionValues(optionName));
        }
    }
}
