package org.gen.springboot.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

	// execution(modifiers-pattern? ret-type-pattern declaring-type-pattern?
	// name-pattern(param-pattern)throws-pattern?)
	// ret-type-pattern,name-pattern,param-pattern是必须的
	// ret-type-pattern:可以为*表示任何返回值,全路径的类名等.
	// name-pattern:指定方法名,*代表所以,set*,代表以set开头的所有方法.
	// param-pattern:指定方法参数(声明的类型),(..)代表所有参数,(*)代表一个参数,(*,String)代表第一个参数为任何值,第二个为String类型.
	// 举例说明:
	// 1）execution(* *(..))
	// //表示匹配所有方法
	// 2）execution(public * com.savage.service.UserService.*(..))
	// //表示匹配com.savage.server.UserService中所有的公有方法
	// 3）execution(* com.savage.server..*.*(..))
	// //表示匹配com.savage.server包及其子包下的所有方法
	// 也可以自定义注解的方式实现切面
	// @Pointcut("@annotation(com.wind.pac.common.annotation.CustomControllerLog)")
	@Pointcut("execution(* org.gen.springboot.service.*.*(..))")
	public void aspectjMethod() {
	}

	/*
	 * @Description: 在核心业务执行前执行此Advice
	 */
	@Before(value = "aspectjMethod()")
	public void before(JoinPoint jp) {
		String name = jp.getSignature().getName();
		System.out.println(name + "方法开始执行...");
	}

	/*
	 * @Description: 核心业务逻辑退出后（包括正常执行结束和异常退出），执行此Advice
	 */
	@After(value = "aspectjMethod()")
	public void after(JoinPoint jp) {
		String name = jp.getSignature().getName();
		System.out.println(name + "方法执行结束...");
	}

	/*
	 * @Description: 核心业务逻辑调用正常退出后，不管是否有返回值，正常退出后，均执行此Advice
	 *               声明retVal时指定的类型会限制目标方法必须返回指定类型的值或没有返回值(如目标方法的返回值和指定类型不匹配则不会触发此Advice)
	 *               此处将retVal的类型声明为Object，意味着对目标方法的返回值不加限制
	 */
	@AfterReturning(value = "aspectjMethod()", returning = "retVal")
	public void afterReturning(JoinPoint jp, Object retVal) {
		String name = jp.getSignature().getName();
		System.out.println(name + "方法返回值为：" + retVal);
	}

	/*
	 * @Description: 核心业务逻辑调用异常退出后，执行此Advice，处理错误信息 注意：执行顺序在@After Advice之后
	 * 
	 */
	@AfterThrowing(value = "aspectjMethod()", throwing = "e")
	public void afterThrowing(JoinPoint jp, Exception e) {
		String name = jp.getSignature().getName();
		System.out.println(name + "方法抛异常了，异常是：" + e.getMessage());
	}

	/*
	 * @Description: 手动控制调用核心业务逻辑 
	 * 正常情况：@Around start ==> @Before ==> method invoke(被代理对象的Method) ==> @AfterReturning ==> @After ==> @Around end
	 * 异常情况：@Around start ==> @Before ==> method invoke(被代理对象的Method) ==> @AfterThrowing ==> @After
	 */
	@Around("aspectjMethod()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {

		// @Before Advice之前执行@Around Advise before;
		System.out.println("=================【Around Advice Before】=================");
		// 调用核心逻辑：即被代理对象的Method
		Object retVal = pjp.proceed();
		// @After Advice之前执行(异常的时候则不会执行这部分的代码) @Around Advise after
		System.out.println("=================【Around Advice After】=================");
		return retVal;
	}
}
