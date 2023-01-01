package org.gen.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
//import org.springframework.boot.SpringBootConfiguration;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
// @SpringBootConfiguration就是一个@Configuration，它的功能就是表面这是一个配置类，开发者可以在这个类中配置Bean。从这个角度来讲，这个类所扮演的角色有点类似于Spring中applicationContext.xml文件的角色
// 也可以创建一个新的类专门用来配置Bean，这样便于配置管理。这个类只需要叫上@Configuration注解即可。
// @EnableAutoConfiguration注解表示开启自动化配置，SpringBoot中提供了大量的自动化配置类，例如：ErrorMvcAutoConfiguration、ThymeleafAutoConfiguration、MultipartAutoConfiguration等，
// 这些自动化配置都可以减少相应操作的配置，达到开箱即用的效果，如果不想使用自动化配置，则可以通过@EnableAutoConfiguration(exclude={ErrorMvcAutoConfiguration.class})的方法除去相关配置
// 如果在@EnableAutoConfiguration注解中使用exclude属性除去Error的自动化配置类，这时如果在resources/static/error目录下创建4xx.html、5xx.html，访问出错时就不会自动跳转了
// 在Java项目的main方法中，通过SpringApplication中的run方法启动项目。第一个参数传入App.class告诉Spring哪个是主要组件。第二个参数是运行时输入的其他参数。
// 在控制器中提供了一个"/hello"接口，此时需要配置包扫描才能将HelloController注册到SpringMVC容器中，因此在App类上面再添加一个注解@ComponentScan进行包扫描
// @ComponentScan注解，除了扫描@Service、@Repository、@Component、@Controller和@RestController等之外，也会扫描@Configuration注解的类
// 由于@ComponentScan注解默认扫描的类都位于当前类所在包下面，因此建议在实际项目开发中把项目启动类放在根包中
// 扫描单个包：@ComponentScan("com.pccc")，扫描多个包：@ComponentScan({"com.pccc","com.test"})
// 也可以直接使用组合注解@SpringBootApplication来代替@SpringBootConfiguration、@EnableAutoConfiguration和@ComponentScan
// @SpringBootConfiguration
// @EnableAutoConfiguration
// @ComponentScan

@MapperScan("org.gen.springboot.mapper") //扫描的mapper
@SpringBootApplication
//@EnableAutoConfiguration(exclude = { ErrorMvcAutoConfiguration.class, DataSourceAutoConfiguration.class })
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}

//// 通过外部服务器运行war包时候需要修改启动类，继承SpringBootServletInitializer
// @SpringBootApplication
// @EnableAutoConfiguration
// public class App extends SpringBootServletInitializer {
//
// @Override
// protected SpringApplicationBuilder configure(SpringApplicationBuilder
//// application) {
// return application.sources(App.class);
// }
// public static void main(String[] args) {
// SpringApplication.run(App.class, args);
// }
// }
