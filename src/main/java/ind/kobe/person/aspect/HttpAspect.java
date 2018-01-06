package ind.kobe.person.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Bielu
 * @Date: Created on 21:57 2018/1/6
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    // 指定方法执行前
    @Before("execution(public * ind.kobe.person.controller.PersonController.personList(..))")
    public void personListBefore() {
        logger.info("personList before");
    }

    // 所有方法执行前
    @Before("execution(public * ind.kobe.person.controller.PersonController.*(..))")
    public void doBefore(JoinPoint joinPoint) {
        logger.info("all before");
    }

    // 所有方法执行后
    @After("execution(public * ind.kobe.person.controller.PersonController.*(..))")
    public void doAfter() {
        logger.info("all after");
    }

    // 切点，避免很多重复的excution
    @Pointcut("execution(public * ind.kobe.person.controller.PersonController.personAdd(..))")
    public void log() {
        logger.info("log something");
    }

    // 可以直接调切点方法
    @Before("log()")
    public void personAddBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        logger.info("url={}", request.getRequestURL());
        //method
        logger.info("method={}", request.getMethod());
        //ip
        logger.info("ip={}", request.getRemoteAddr());
        //类方法
        logger.info("class_method={}.{}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName());
        //参数
        logger.info("args={}", joinPoint.getArgs());
    }

    @After("log()")
    public void personAddAfter() {
        logger.info("after personAdd");
    }

    // 获取返回结果
    @AfterReturning(returning = "obj", pointcut = "log()")
    public void doAfterReturning(Object obj) {
        logger.info("response={}", obj);
    }
}
