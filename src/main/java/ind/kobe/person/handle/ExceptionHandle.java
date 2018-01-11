package ind.kobe.person.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import ind.kobe.person.bean.Result;
import ind.kobe.person.exception.PersonException;
import ind.kobe.person.utils.ResultUtil;

/**
 * 注解@ControllerAdvice 使一个Contoller成为全局的异常处理类，类中用@ExceptionHandler方法注解的方法可以处理所有Controller发生的异常。
 * @Author: Bielu
 * @Date: Created on 0:07 2018/1/7
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result<?> handle(Exception e) {
    	if(e instanceof PersonException) {
            PersonException personException = (PersonException) e;
            return ResultUtil.error(personException.getCode(), personException.getMessage());
        }else {
            logger.error("【系统异常】{}", e);
            return ResultUtil.error(-1, "未知错误");
        }
    }
}
