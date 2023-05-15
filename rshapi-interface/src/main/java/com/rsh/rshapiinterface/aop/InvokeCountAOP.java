package com.rsh.rshapiinterface.aop;

import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author rsh
 * @date 2023/3/11 15:55
 */
@RestControllerAdvice
public class InvokeCountAOP {
    //伪代码
    //定义切面触发时机 controller接口的方法执行成功后，执行下述发放
    //@After
    //public void doInterceptor(ProceedingJoinPoint joinPoint){
        //执行接口方法
        //接口方法次数+1
        // 通过权限校验，放行
        //return joinPoint.proceed();
    //}
}
