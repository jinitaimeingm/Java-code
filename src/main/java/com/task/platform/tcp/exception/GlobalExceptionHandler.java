package com.task.platform.tcp.exception;

import com.task.platform.tcp.common.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice //  专门用来“拦截 Controller 抛出的异常”
public class GlobalExceptionHandler {

    /**
     * 处理所有 RuntimeException
     * （现在先简单点，后面会细分）
     */
    @ExceptionHandler(RuntimeException.class)
    public Result<?> handleRuntimeException(RuntimeException e) {

        // e.getMessage() 就是你在 Service 里 throw 的信息
        return Result.fail(e.getMessage());
    }
}
