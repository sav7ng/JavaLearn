package com.deepexi.a.extension;

import com.deepexi.util.config.Payload;
import org.springframework.web.bind.annotation.*;

/**
 * Created by donh on 2018/11/6.
 * 全局异常统一处理
 */
@RestControllerAdvice
public class MyControllerAdvice {

    /**
     * 全局异常捕捉处理
     * @param ex
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public Payload errorHandler(Exception ex) {
        return new Payload(null, "500", ex.getMessage());
    }

    /**
     * 拦截捕捉自定义异常 MyException.class
     * @param ex
     * @return
     */
    @ExceptionHandler(value = ApplicationException.class)
    public Payload myErrorHandler(ApplicationException ex) {
        return new Payload(null, ex.getCode(), ex.getMsg());
    }

}