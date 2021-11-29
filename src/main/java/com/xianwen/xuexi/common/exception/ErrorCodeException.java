package com.xianwen.xuexi.common.exception;

import com.xianwen.xuexi.common.response.ErrorCode;

import java.util.Map;

/**
 * 异常信息公共类
 */
public class ErrorCodeException extends RuntimeException {

    //错误码
    private long code;
    //错误消息
    private String message;

    private Map<String, Object> map;

    private static final long serialVersionUID = 1L;

    public ErrorCodeException(long code, String message) {
        this.code = code;
        this.message = message;
    }

    public ErrorCodeException(long code, String message, Map<String, Object> map) {
        this.code = code;
        this.message = message;
        this.map = map;
    }

    public ErrorCodeException(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getDefaultMessage();
    }

    public ErrorCodeException(ErrorCode errorCode, Map<String, Object> map) {
        this.code = errorCode.getCode();
        this.message = errorCode.getDefaultMessage();
        this.map = map;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
}
