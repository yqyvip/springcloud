package com.yqy.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.netty.http.server.HttpServerRequest;

/**
 * @author yqy
 * @date 2022-08-06-11:43
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public String defaultErrorHandler(HttpServerRequest request, Exception exception) {
        return exception.getMessage();
    }
}
