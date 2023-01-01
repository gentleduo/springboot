package org.gen.springboot.custom;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

/*
 * @ControllerAdvice主要用来处理全局数据，一般搭配@ExceptionHandler,@ModelAttribute以及@InitBinder使用。
 * @ControllerAdvice最常见的使用场景就是全局异常处理，例如可以通过@ControllerAdvice结合@ExceptionHandler捕获上传的文件超过了限制大小而抛出的异常。
 * 首先定义CustomExceptionHandler，添加@ControllerAdvice注解，然后定义uploadException方法，在该方法上添加@ExceptionHandler注解
 * 其中定义的MaxUploadSizeExceededException.class表面该方法用来处理MaxUploadSizeExceededException类型的异常。
 * 如果想要该方法处理所有类型的异常，只需要将MaxUploadSizeExceededException改为Exception即可，
 * 方法的参数可以有异常实例、HttpServletResponse以及HttpServletRequest、Model等，
 * 返回值可以是一段JSON、一个ModelAndView、一个逻辑视图名等。
 * 
 * 自定义错误页
 * @ControllerAdvice一般用来处理应用级别的的异常，有一些容器级别的错误就处理不了了，例如Filter中抛出异常，使用@ControllerAdvice定义的全局异常处理机制就无法处理。
 * SpringBoot中，默认情况下，如果用户在发起请求时发生了404、500等错误，SpringBoot会有一个默认的页面展示给用户，
 * 事实上，SpringBoot在返回错误信息时不一定返回HTML页面，而是根据实际情况返回HTML页面或者一段JSON(如果是Ajax请求，则错误信息是一段JSON)。而且这一段HTML或者是JSON都能够自由定制
 * SpringBoot中的错误默认是BasicErrorController类来处理的，该类中的核心方法主要有两个：errorHtml和error。
 * 其中errorHtml方法用来返回错误HTML页面，error用来返回错误JSON，具体返回的是HTML还是JSON，则要看请求头的Accept参数(浏览器请求头：Accept: text/html；非浏览器请求头：＊/＊)
 * 返回JSON的逻辑比较简单，不必过多介绍，返回HTML的逻辑稍微有些复杂，在errorHtml方法中，通过调用resolveErrorView方法来获得一个错误视图的ModelAndView。
 * 而resolveErrorView方法最终会来到DefaultErrorViewResolver类中。DefaultErrorViewResolver类是SpringBoot中默认的错误信息视图解析器。
 * 从BasicErrorController和DefaultErrorViewResolver的源码可知，SpringBoot默认是在error目录下查找4xx、5xx的文件作为错误视图，当找不到时会回到errorHtml方法中，
 * 然后使用error作为默认的错误页面视图名，如果名为error的视图也找不到，SpringBoot就是展示默认的错误提示页面（Whitelable Error Page）
 * 
 * Accept代表发送端（客户端）希望接受的数据类型。比如：Accept：text/xml（application/json）;代表客户端希望接受的数据类型是xml（json）类型
 * Content-Type代表发送端（客户端|服务器）发送的实体数据的数据类型。比如：Content-Type：text/html（application/json）;代表发送端发送的数据格式是html（json）。
 * 
 * 简单配置
 * 通过上面的介绍可知，要自定义错误页面其实很简单，提供4xx和5xx页面即可。如果不需要向用户提示详细的错误信息，那么可以把错误信息定义成静态页面，直接在resources/static目录下创建error目录。
 * 然后在error目录中创建错误展示页面，错误展示页面的命名规则有两种：一种是4xx.html、5xx.html；另外一种是直接使用响应码命名文件，例如404.html、405.html、500.html。
 * 第二种命名方式划分更细，当出错时，不同的错误会展示不同的错误页面。但是这种定义都是静态HTML页面，无法向用户展示完整的错误信息，若采用视图模板技术，则可以向用户展示更多的错误信息。
 * 以Thymeleaf为例，Thymeleaf页面模板默认处于classpath:/templates/目录下，因此在改目录下先创建error目录，再创建错误展示页面，
 * SpringBoot一共返回了5条错误相关的信息，分别是timestamp、status、error、message以及path。
 * 注意：
 * 若定义了多个错误页面，则响应码.html页面优先级高于4xx.html、5xx.html页面的优先级，即若当前一个404错误，则优先展示404.html而不是4xx.html；
 * 动态页面的优先级高于静态页面，即若resources/templates和resources/static下同时定义了4xx.html，则优先展示resources/templates下面的
 * 注意若resources/static下存在500.html，而resources/templates存在5xx.html则还是有限展示resources/static下面的（即：响应码.html页面优先级最高）
 * 
 * 复杂配置
 * 上面的定制还是不够灵活，只能定义HTML页面，无法处理JSON的定制。SpringBoot支持对Error信息的深度定制，接下来将从三个方面介绍深度定制：自定义Error数据，自定义Error视图以及完全自定义
 * 自定义Error数据：
 * 自定义Error数据就是对返回的数据进行自定义。SpringBoot返回的Error信息默认一共有5条，分别是timestamp、status、error、message以及path。
 * 在BasicErrorController的errorHtml方法和error方法中，都是通过getErrorAttributes方法获取Error信息的。该方法最终会调用到DefaultErrorAttributes类中的getErrorAttributes方法，
 * 而DefaultErrorAttributes类是在ErrorMvcAutoConfiguration中默认提供的。从ErrorMvcAutoConfiguration的源码可知当系统没有提供ErrorAttributes时才会采用DefaultErrorAttributes。
 * 因此自定义错误提示时，只需要自己提供一个ErrorAttributes即可，而DefaultErrorAttributes是ErrorAttributes的子类，因此只需要继承DefaultErrorAttributes即可。
 * 自定义Error视图：
 * Error视图是展示给用户的页面，在BasicErrorController的errorHtml方法中调用resolveErrorView方法获取一个ModelAndView实例。resolveErrorView方法是由ErrorViewResolver提供的，
 * 通过ErrorMvcAutoConfiguration类的源码可以看到如果用户没有定义ErrorViewResolver那么SpringBoot默认采用的ErrorViewResolver是DefaultErrorViewResolver。
 * 因此想要自定义Error视图，只需要提供自己的ErrorViewResolver即可。
 * 完全自定义
 * 自定义Error数据和自定义Error视图都是对BasicErrorController类中的某个环节进行修补。查看Error自动化配置类ErrorMvcAutoConfiguration，可以发现BasicErrorController本身只是一个默认的配置
 * 若没有提供自己的ErrorController，则SpringBoot提供BasicErrorController作为默认的ErrorController。因此如果需要更加灵活地对Error视图和数据进行处理，只需要提供自己的ErrorController即可。
 * 提供自己的ErrorController有两种方式：一种是实现ErrorController接口，另一种是直接继承BasicErrorController。由于ErrorController接口只提供一个待实现的方法，
 * 而BasicErrorController已经实现了很多功能，因此选择第二种方式，即通过继承BasicErrorController来实现自己的ErrorController
 */
//@ControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public void uploadException(MaxUploadSizeExceededException e, HttpServletResponse resp) throws IOException {

		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.write("上传文件超出限制！");
		out.flush();
		out.close();
	}
}
