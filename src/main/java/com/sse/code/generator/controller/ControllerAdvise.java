//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.sse.code.generator.controller;

import com.sse.code.connector.ConnectorException;
import com.sse.code.generator.model.Result;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerAdvise {
    public ControllerAdvise() {
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    Result handleException(Exception e) {
        e.printStackTrace();
        return Result.error("系统错误");
    }

    @ExceptionHandler({IllegalArgumentException.class, AssertionError.class, ConnectorException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    Result handleException(Throwable error) {
        error.printStackTrace();
        return Result.error(error.getMessage());
    }
}
