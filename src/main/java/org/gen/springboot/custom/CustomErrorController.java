package org.gen.springboot.custom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 完全自定义
 * 自定义Error数据和自定义Error视图都是对BasicErrorController类中的某个环节进行修补。查看Error自动化配置类ErrorMvcAutoConfiguration，可以发现BasicErrorController本身只是一个默认的配置
 * 若没有提供自己的ErrorController，则SpringBoot提供BasicErrorController作为默认的ErrorController。因此如果需要更加灵活地对Error视图和数据进行处理，只需要提供自己的ErrorController即可。
 * 提供自己的ErrorController有两种方式：一种是实现ErrorController接口，另一种是直接继承BasicErrorController。由于ErrorController接口只提供一个待实现的方法，
 * 而BasicErrorController已经实现了很多功能，因此选择第二种方式，即通过继承BasicErrorController来实现自己的ErrorController
 * 
 * 自定义CustomErrorController继承自BasicErrorController并添加@Controller注解，将CustomErrorController注册到SpringMVC容器中。
 * 由于BasicErrorController没有无参构造方法，因此在创建BasicErrorController实例时需要传递参数，在CustomErrorController的构造方法上添加@Autowired注解注入所需参数。
 * 重写errorHtml和error方法，对Error视图和数据进行充分的自定义。
 * 最后在resources/templates目录下提供myErrorPage.html页面作为视图页面。
 * 
 */
@Controller
public class CustomErrorController extends BasicErrorController {
	
    @Autowired
    public CustomErrorController(ErrorAttributes errorAttributes,
                             ServerProperties serverProperties,
                             List<ErrorViewResolver> errorViewResolvers) {
        super(errorAttributes, serverProperties.getError(), errorViewResolvers);
    }
    
    @Override
    public ModelAndView errorHtml(HttpServletRequest request,
                                  HttpServletResponse response) {
        HttpStatus status = getStatus(request);
        Map<String, Object> model = getErrorAttributes(
                request, isIncludeStackTrace(request, MediaType.TEXT_HTML));
        model.put("custommsg", "出错啦！");
        ModelAndView modelAndView = new ModelAndView("customErrorPage", model, status);
        return modelAndView;
    }
    
    @Override
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
        Map<String, Object> body = getErrorAttributes(request,
                isIncludeStackTrace(request, MediaType.ALL));
        body.put("custommsg", "出错啦！");
        HttpStatus status = getStatus(request);
        return new ResponseEntity<>(body, status);
    }
}
