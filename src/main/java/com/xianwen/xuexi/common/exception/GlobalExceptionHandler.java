/*
 * Copyright (C) 2016 eKing Technology, Inc. All Rights Reserved.
 */
package com.xianwen.xuexi.common.exception;

import com.xianwen.xuexi.common.response.ErrorCode;
import com.xianwen.xuexi.common.response.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理
 *
 * @author xw.weng
 */
@RestControllerAdvice
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 系统自定义全局异常
     *
     * @param req
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = ErrorCodeException.class)
    @ResponseBody
    public RestResponse exception(HttpServletRequest req, ErrorCodeException e) throws Exception {
        RestResponse exception = RestResponse.exception(e.getCode(), e.getMessage(), e.getMap());
        log.info("error\tUCinfo\tGlobalExceptionHandler\texception\tappid:{}\tip:{}\tchannel:{}\treq:{}\thttpHeaderDto:{}\tdata:{}", null, null, null, null, null, exception);
        log.error("GlobalException: {}", exception, e);
        return exception;
    }

//    @ExceptionHandler(value = CannotGetJdbcConnectionException.class)
//    @ResponseBody
//    public RestResponse cannotGetJdbcConnectionException(HttpServletRequest req, ErrorCodeException e)
//            throws Exception {
//        log.info("error\tUCinfo\tGlobalExceptionHandler\tcannotGetJdbcConnectionException\tappid:{}\tip:{}\tchannel:{}\treq:{}\thttpHeaderDto:{}\tdata:{}", null, null, null, null, null, new JSONObject() {{
//            put("code", ErrorCode.DB_CONN_EXCEPTION.getCode());
//            put("message", ErrorCode.DB_CONN_EXCEPTION.getDefaultMessage());
//        }});
//        RestResponse exception = RestResponse.exception(ErrorCode.DB_CONN_EXCEPTION);
//        return exception;
//    }

    /**
     * controller 参数转化时, 主要从这里捕获错误信息
     */
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    @ResponseBody
    public RestResponse exception(HttpServletRequest req, HttpMessageNotReadableException e) throws Exception {
        RestResponse exception = RestResponse.exception(ErrorCode.ILLEGAL_ARGUMENT);
        log.info("error\tUCinfo\tGlobalExceptionHandler\tHttpMessageNotReadableException\tappid:{}\tip:{}\tchannel:{}\treq:{}\thttpHeaderDto:{}\tdata:{}", null, null, null, null, null, new JSONObject() {{
            put("code", exception.getCode());
            put("message", exception.getMessage());
        }});
        log.error("HttpMessageNotReadableException: {}", exception, e);
        return exception;
    }

    /**
     * 这个兜底
     *
     * @param req
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = RuntimeException.class)
    @ResponseBody
    public RestResponse exception(HttpServletRequest req, RuntimeException e) throws Exception {
        String msg = e.getMessage();
        RestResponse exception;
        log.info("GlobalExceptionHandler getMessage e:{},msg:{}", e.getCause(), e.getMessage());
        if (StringUtils.isNotEmpty(msg) && msg.indexOf("over limit") != -1) {
            exception = RestResponse.exception(ErrorCode.MEMBER_OVER_LIMIT);
        } else if (StringUtils.isNotEmpty(msg) && msg.indexOf("触发限流规则") != -1) {
            exception = RestResponse.exception(ErrorCode.MEMBER_OVER_LIMIT);
        } else {
            exception = RestResponse.exception(ErrorCode.EXCEPTION);
        }
        log.info("error\tUCinfo\tGlobalExceptionHandler\tRuntimeException\tappid:{}\tip:{}\tchannel:{}\treq:{}\thttpHeaderDto:{}\tdata:{}", null, null, null, null, null, new JSONObject() {{
            put("code", ErrorCode.EXCEPTION.getCode());
            put("message", ErrorCode.EXCEPTION.getDefaultMessage());
        }});
        log.error("RuntimeException: {}", exception, e);
        return exception;
    }

//    /**
//     * 常客的限流以及其他判断
//     *
//     * @param req
//     * @param e
//     * @return
//     * @throws Exception
//     */
//    @ExceptionHandler(value = RpcException.class)
//    @ResponseBody
//    public RestResponse exception(HttpServletRequest req, RpcException e) throws Exception {
//        String msg = e.getMessage();
//        RestResponse exception;
//        log.info("GlobalExceptionHandler getMessage e:{},msg:{}", e.getCause(), e.getMessage());
//        if (StringUtils.isNotEmpty(msg) && msg.indexOf("over limit") != -1) {
//            exception = RestResponse.exception(ErrorCode.MEMBER_OVER_LIMIT);
//        } else if (StringUtils.isNotEmpty(msg) && msg.indexOf("触发限流规则") != -1) {
//            exception = RestResponse.exception(ErrorCode.MEMBER_OVER_LIMIT);
//        } else {
//            exception = RestResponse.exception(ErrorCode.MEMBER_SYSTEM_ERROR);
//        }
//        log.info("error\tUCinfo\tGlobalExceptionHandler\tRpcException\tappid:{}\tip:{}\tchannel:{}\treq:{}\thttpHeaderDto:{}\tdata:{}", null, null, null, null, null, new JSONObject() {{
//            put("code", e.getCode());
//            put("message", e.getMessage());
//        }});
//        log.error("RpcException: {}", exception, e);
//        return exception;
//    }
}
