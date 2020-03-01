package com.changgou.goods.utils;

import entity.Result;
import entity.StatusCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: zhanghongjie
 * @description: 捕捉全局异常
 * @date: 2020/3/1 15:32
 * @version: 1.0
 */
@ControllerAdvice // 可以切到所有requestMapping请求
public class BaseExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(BaseExceptionHandler.class);

    @ExceptionHandler
    @ResponseBody
    public Result error(Exception e) {
        e.printStackTrace();
        logger.error("捕捉到全局异常", e);
        return new Result(false, StatusCode.ERROR, e.getMessage());
    }
}


