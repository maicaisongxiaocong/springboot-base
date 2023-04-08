package com.hebut.base.config.log;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @program: base
 * @description: 扫描controller目录下所有函数，日志中打印所有正在执行函数的名称、入参、出参和执行时间
 * @author: cxc
 * @create: 2023-04-03 11:20
 **/
@Aspect
@Component
@Slf4j
public class LoggingAspect {

    /*execution(* com.example.demo.service.*.*(..))是一个切入点表达式，它指定了切入点的位置。
    这个表达式的意思是：拦截com.example.demo.service包下的所有类的所有方法。
    第一个星号表示任意返回类型，第二个星号表示任意类名，两个点表示任意方法名，括号里面的两个点表示任意参数类型和数量*/

    @Around("execution(* com.hebut.base.controller.*.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("====================== log start ======================");

        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        log.info(joinPoint.getSignature() + " executed in " + executionTime + "ms");
        log.info("Method arguments are : " + Arrays.toString(joinPoint.getArgs()));
        log.info("Method returned value is : " + proceed);

        log.info("======================= log end =======================");
        return proceed;
    }
}
