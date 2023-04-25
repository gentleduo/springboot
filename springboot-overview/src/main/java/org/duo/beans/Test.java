package org.duo.beans;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Auther:duo
 * @Date: 2023-01-09 - 01 - 09 - 18:35
 * @Description: org.duo.beans
 * @Version: 1.0
 */
public class Test {

    public static void main(String[] args) {
        // 创建和初始化容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        // ① 我们直接从容器中拿出 hello 对象
        System.out.println(context.getBean("hello", Hello.class));
        MyConfig myConfig = context.getBean("myConfig", MyConfig.class);
        // ② 通过调用 config 对象中的 hello() 获取 hello 对象
        System.out.println(myConfig.hello());

        AnnotationConfigApplicationContext contextCom = new AnnotationConfigApplicationContext(MyComponent.class);
        // ① 我们直接从容器中拿出 hello 对象
        System.out.println(contextCom.getBean("hello", Hello.class));
        MyComponent myComponent = contextCom.getBean("myComponent", MyComponent.class);
        // ② 通过调用 component 对象中的 hello() 获取 hello 对象
        System.out.println(myComponent.hello());
    }
}
