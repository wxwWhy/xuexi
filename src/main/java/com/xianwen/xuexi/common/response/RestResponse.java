package com.xianwen.xuexi.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.xianwen.xuexi.common.constant.Constant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.MDC;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * @author xiangruo
 * @Date 14:16 2020/9/3
 */
@Data
/**禁止使用构造函数创建 RestResponse, 只能是 success 或者 exception*/
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@JsonInclude(Include.NON_NULL)
@ApiModel
public class RestResponse<T> implements Serializable {

    private static final long serialVersionUID = 6985936542956574679L;

    @ApiModelProperty(value = "执行状态码, 执行成功返回 0, 其他的都是 EXCEPTION")
    private long code;

    @ApiModelProperty(value = "消息, OK 的时候, message 一般不填")
    private String message = null;

    @ApiModelProperty(value = "具体的数据, EXCEPTION 的时候, data 一般 不填")
    private T data = null;

    @ApiModelProperty(value = "时间戳, 只在 exception 时有用")
    private Date timestamp = null;

    @ApiModelProperty(value = "放一些辅助信息 key->value, 一般用来进一步描述异常信息, OK 时暂未用到")
    private Map<String, Object> extraInfo = null;

    @ApiModelProperty(value = "reqeustId")
    private String requestId = null;

    /**
     * 表示调用成功
     */
    public static <T> RestResponse ok(T data) {
        RestResponse<T> restResponse = new RestResponse<>();
        restResponse.code = ErrorCode.OK.getCode();
        restResponse.data = data;
        restResponse.requestId = MDC.get(Constant.REQUEST_ID);
        return restResponse;
    }

    public static <T> RestResponse ok() {
        RestResponse<T> restResponse = new RestResponse<>();
        restResponse.code = ErrorCode.OK.getCode();
        restResponse.requestId = MDC.get(Constant.REQUEST_ID);
        return restResponse;
    }

    public static <T> RestResponse other(T data, ErrorCode errorCode) {
        RestResponse<T> restResponse = new RestResponse<>();
        restResponse.code = errorCode.getCode();
        restResponse.message = errorCode.getDefaultMessage();
        restResponse.data = data;
        restResponse.requestId = MDC.get(Constant.REQUEST_ID);
        return restResponse;
    }

    public static <T> RestResponse other(T data, ErrorCode errorCode, String message) {
        RestResponse<T> restResponse = new RestResponse<>();
        restResponse.code = errorCode.getCode();
        restResponse.message = message;
        restResponse.data = data;
        restResponse.requestId = MDC.get(Constant.REQUEST_ID);
        return restResponse;
    }

    /**
     * 调用发生 异常
     */
    public static RestResponse exception(ErrorCode code) {
        RestResponse restResponse = new RestResponse();
        restResponse.code = code.getCode();
        restResponse.message = code.getDefaultMessage();
        restResponse.requestId = MDC.get(Constant.REQUEST_ID);
        return restResponse;
    }

    /**
     * 调用发生 异常
     */
    public static RestResponse exception(long code, String message, Map<String, Object> exceptionInfo) {
        RestResponse restResponse = new RestResponse();
        restResponse.code = code;
        restResponse.message = message;
        restResponse.timestamp = new Date();
        restResponse.data = exceptionInfo;
        restResponse.requestId = MDC.get(Constant.REQUEST_ID);
        return restResponse;
    }

    public static boolean isSuccess(RestResponse res) {
        return res != null && res.getCode() == ErrorCode.OK.getCode();
    }

    public static boolean isFail(RestResponse res) {
        return !isSuccess(res);
    }

    @Override
    public String toString() {
        return "{\"RestResponse\":{"
                + "\"code\":"
                + code
                + ",\"message\":\""
                + message + '\"'
                + ",\"data\":"
                + data
                + ",\"timestamp\":\""
                + timestamp + '\"'
                + ",\"extraInfo\":"
                + extraInfo
                + ",\"requestId\":\""
                + requestId + '\"'
                + "}}";

    }
}
