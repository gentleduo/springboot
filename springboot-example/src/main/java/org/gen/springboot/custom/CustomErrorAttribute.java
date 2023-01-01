package org.gen.springboot.custom;

import java.util.Map;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

/**
 * 自定义Error数据：
 * 自定义Error数据就是对返回的数据进行自定义。SpringBoot返回的Error信息默认一共有5条，分别是timestamp、status、error、message以及path。
 * 在BasicErrorController的errorHtml方法和error方法中，都是通过getErrorAttributes方法获取Error信息的。该方法最终会调用到DefaultErrorAttributes类中的getErrorAttributes方法，
 * 而DefaultErrorAttributes类是在ErrorMvcAutoConfiguration中默认提供的。从ErrorMvcAutoConfiguration的源码可知当系统没有提供ErrorAttributes时才会采用DefaultErrorAttributes。
 * 因此自定义错误提示时，只需要自己提供一个ErrorAttributes即可，而DefaultErrorAttributes是ErrorAttributes的子类，因此只需要继承DefaultErrorAttributes即可。
 * 
 * 自定义CustomErrorAttribute继承DefaultErrorAttributes，重写DefaultErrorAttributes中的getErrorAttributes，
 * CustomErrorAttribute类中添加@Component注解，该类将被注册到Spring容器中。
 * 通过super.getErrorAttributes获取SpringBoot默认提供的错误信息，然后在此基础上添加Error信息或者移除Error信息。
 * 
 */
//@Component
public class CustomErrorAttribute extends DefaultErrorAttributes{
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, includeStackTrace);
        errorAttributes.put("custommsg", "出错啦！");
        errorAttributes.remove("error");
        return errorAttributes;
    }
}
