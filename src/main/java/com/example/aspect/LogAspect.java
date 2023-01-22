package com.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author jasper
 * @email jaspersteelxx@gmail.com
 * @create 2023-01-21 15:57
 **/

@Component
@Aspect
public class LogAspect {

    /**
     * define point cut.
     */
    @Pointcut("execution(* com.example.*.*(..))")
    private void pointCutMethod() {
    }


    /**
     * 环绕通知.
     *
     * @param pjp pjp
     * @return obj
     * @throws Throwable exception
     */
    @Around("@annotation(com.example.anno.Log)")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕通知: 进入方法");
        System.out.println("method name is " + pjp.getTarget().getClass().getName());
        Object o = pjp.proceed();
        System.out.println("环绕通知: 退出方法");
        return o;
    }

    /**
     * 前置通知.
     */
//    @Before("pointCutMethod()")
//    public void doBefore() {
//        System.out.println("前置通知");
//    }
//
//
//    /**
//     * 后置通知.
//     *
//     * @param result return val
//     */
//    @AfterReturning(pointcut = "pointCutMethod()", returning = "result")
//    public void doAfterReturning(String result) {
//        System.out.println("后置通知, 返回值: " + result);
//    }
//
//    /**
//     * 异常通知.
//     *
//     * @param e exception
//     */
//    @AfterThrowing(pointcut = "pointCutMethod()", throwing = "e")
//    public void doAfterThrowing(Exception e) {
//        System.out.println("异常通知, 异常: " + e.getMessage());
//    }
//
//    /**
//     * 最终通知.
//     */
//    @After("pointCutMethod()")
//    public void doAfter() {
//        System.out.println("最终通知");
//    }

}

