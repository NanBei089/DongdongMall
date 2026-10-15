package com.nanbei.aop;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class AopLog {
    /**
     * 切点
     */
    @Pointcut("execution(public * com.nanbei.service.ipml.*.*(..)) " +
            "|| @annotation(com.nanbei.aop.AnnoLog)")
    public void pointcut() {}

    /**
     * 前置通知
     */
/*    @Before(value = "pointcut()")
    public void before(JoinPoint jp) {
        // 获取方法签名
        String methodName = jp.getSignature().getName();
        // 获取方法参数
        Object[] args = jp.getArgs();

        log.info("方法名：{}，参数：{}", methodName, args);
    }*/

    /**
     * 后置通知
     */
    /*@AfterReturning(value = "pointcut()" , returning = "result")
    public void after(Object result) {
        // 获取方法返回值
        String resultString = JSONObject.toJSONString(result);
        log.info("方法返回值：{}", resultString);
    }*/

    /**
     * 环绕通知
     */
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint jp) throws Throwable {
        String methodName = jp.getSignature().getName();

        // 业务方法执行前
        log.info("方法名：{}，参数：{}",
                methodName, JSONObject.toJSONString(jp.getArgs()));

        // 执行业务方法，获取返回值
        Object result = jp.proceed();

        // 业务方法正常返回后
        log.info("方法返回值：{}", JSONObject.toJSONString(result));

        // 将业务方法的返回值交给调用方
        return result;
    }
}
