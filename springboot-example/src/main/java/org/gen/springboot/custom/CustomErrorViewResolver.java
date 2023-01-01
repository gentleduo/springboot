package org.gen.springboot.custom;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 自定义Error视图：
 * Error视图是展示给用户的页面，在BasicErrorController的errorHtml方法中调用resolveErrorView方法获取一个ModelAndView实例。resolveErrorView方法是由ErrorViewResolver提供的，
 * 通过ErrorMvcAutoConfiguration类的源码可以看到如果用户没有定义ErrorViewResolver那么SpringBoot默认采用的ErrorViewResolver是DefaultErrorViewResolver。
 * 因此想要自定义Error视图，只需要提供自己的ErrorViewResolver即可。
 * 
 * 自定义CustomErrorViewResolver实现ErrorViewResolver接口并实现接口中的resolveErrorView方法，使用@Component注解将该类注册到Spring容器中。
 * 在resolveErrorView方法中，最后一个Map参数就是SpringBoot提供的默认的5条Error信息(也可以按照自定义Error数据的步骤对这5条消息进行修改)。
 * 在resolveErrorView方法中，返回一个ModelAndView，在ModelAndView中设置Error视图和Error数据。
 * 
 */
//@Component
public class CustomErrorViewResolver implements ErrorViewResolver {
    @Override
    public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> model) {
        ModelAndView mv = new ModelAndView("errorPage");
        mv.addObject("custommsg", "出错啦！！");
        mv.addAllObjects(model);
        return mv;
    }
}