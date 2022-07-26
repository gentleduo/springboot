package org.gen.springboot.custom;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CustomWebMvcConfigurer implements WebMvcConfigurer {

	/*
	 * CORS全局配置
	 * 
	 * 实现WebMvcConfigurer接口，然后实现接口中的addCorsMappings方法。
	 * 在addCorsMappings方法中，addMapping表示对哪些格式的请求路径进行跨域处理；
	 * allowedHeaders表示允许的请求头，*表示所有的请求头都被允许，默认允许所有的请求头信息；
	 * allowedMethods表示允许的请求方法，默认是GET、POST和HEAD；*表示支持所有的请求方法；
	 * maxAge表示探测请求的有效期；对于DELETE、PUT或者自定义头信息的请求，在执行过程中会先发送探测请求，探测请求不用每次都发送，可以配置一个有效期
	 * ，有效期过了之后才会重新发送探测请求。 这个属性默认是1800秒，即30分钟。 allowedOrigins表示支持的域。("*"表示支持所有域)
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {

		registry.addMapping("/books").allowedHeaders("*").allowedMethods("*").maxAge(1800)
				.allowedOrigins("http://localhost:8080");
		// registry.addMapping("/**").allowedHeaders("*").allowedMethods("*").maxAge(1800).allowedOrigins("*");
	}

	// /*
	// * 配置拦截器。
	// *
	// * 自定义类实现WebMvcConfigurer接口，实现接口中的addInterceptors方法，
	// * addPathPatterns表示拦截路径，excludePathPatterns表示排除的路径。
	// */
	// @Override
	// public void addInterceptors(InterceptorRegistry registry) {
	//
	// registry.addInterceptor(new
	// CustomInterceptor()).addPathPatterns("/**").excludePathPatterns("/hello",
	// "/getUserById", "/deleteUserById");
	// // registry.addInterceptor(new
	// //
	// CustomInterceptor()).addPathPatterns("/**").excludePathPatterns("/deleteUserById");
	// }

	/*
	 * 使用页面模板后，需要通过控制器才能访问页面。（即在Controller使用ModelAndView加载数据，然后渲染，才能显示出来）。
	 * 但是有一些页面在控制器中不需要加载数据，只是完成简单的挑战，对于这种页面，可以直接配置路径映射，提高访问速度。
	 * 例如有两个Thymeleaf做模板的页面login.html和index.html，
	 * 直接在MVC配置中重写addViewControllers方法配置映射关系即可；
	 * 配置完成后，就可以直接访问http://server01:8081/login等地址了。
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/index").setViewName("index");
	}
}
