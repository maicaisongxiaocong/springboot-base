package com.hebut.base.common.exception;

import com.hebut.base.common.ResultResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: base
 * @description: 全局异常处理
 * @author: cxc
 * @create: 2023-04-08 10:10
 **/

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

   

    /**
     * 处理自定义的业务异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = CustomeException.class)
    @ResponseBody
    public ResultResponse CustomeExceptionHandler(HttpServletRequest req, CustomeException e){
        log.error("发生业务异常！原因是：{}",e.getErrorMsg());
        return ResultResponse.error(e.getErrorCode(),e.getErrorMsg());
    }

    /**
     * 处理空指针的异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value =NullPointerException.class)
    @ResponseBody
    public ResultResponse exceptionHandler(HttpServletRequest req, NullPointerException e){
        log.error("发生空指针异常！原因是:",e);
        return ResultResponse.error(ExceptionEnum.BODY_NOT_MATCH);
    }

    /**
     * 处理其他异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value =Exception.class)
    @ResponseBody
    public ResultResponse exceptionHandler(HttpServletRequest req, Exception e){
        log.error("未知异常！原因是:",e);
        return ResultResponse.error(ExceptionEnum.INTERNAL_SERVER_ERROR);
    }
}
