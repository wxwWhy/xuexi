package com.xianwen.xuexi.common.constant;

/**
 * @author ：hbo.huang
 * @date ：Created in 2020/3/27 11:22
 * @description：常量
 * @modified By：
 * @version: $
 */
public final class Constant {

    public static final long OK = 0;
    public static final String OK_STR = "0";
    public static final Integer ZERO = 0;
    public static final Integer PHONE_LEN = 11;
    public static final String YES = "Y";
    public static final String NO = "N";
    public static final int MOBILE_MAX_LENTH = 11;
    public static final int MOBILE_MIN_LENTH = 11;
    /**
     * ffp常旅客系统错误码转换
     */
    public static final Long FFP_BENEFICIARY_ERROR_CODE_PREFIX = 20007000L;
    public static final Integer ONE = 1;

    public static final String yyyyMMdd = "yyyyMMdd";
    public static final String yyyyMMddhhmmss = "yyyyMMddhhmmss";
    public static final String FFP_MMDDYYYHHMMSS = "MM/dd/yyyy hh:mm:ss";
    public static final String FFP_MMDDYYY = "MM/dd/yyyy";
    /**
     * 秒
     */
    public static final long TIMEOUT_QR_CODE = 120;
    public static final int NONE = 0;
    public static final int ACTION = 1;
    /**
     * 24小时
     */
    public static final long HOURS_24 = 24;
    public static final String UTF8 = "UTF-8";
    public static final String CONNECT_ = "_";

    public final static String REQUEST_ID = "requestId";
    public final static String SHORTIP = "shortip";
    public final static String IP = "ip";
    public static final int AREA_CODE_86 = 86;
    public static final String AREA_86_CODE = "86";
    public static final String ALL = "ALL";
    public static final int TWO = 2;
    public static final String SEND_SUCCESS = "SEND_SUCCESS";
    public static final String EMAIL_SEND_SUCCESS = "success";
    /**
     * 获取配置的用户安全问题
     */
    public static final Object REQ = "ReQ";
    /**
     * 忽略的前缀
     */
    public static final String IGNORE_URL = "callback";
    public static final int HTTP_CONN_TIMEOUT = 10000;
    public static final String BODY = "body";
    public static final Integer CHECK = 0;
    public static final int LIMIT = 10;

    //规则表属性
    /**
     * 密码校验次数上限
     */
    public static String EMAIL_FORMAT = "^([a-z0-9A-Z]+[-|\\\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\\\.)+[a-zA-Z]{2,}$";

    public static final String EMAIL_CONTENT = "【海南航空】尊敬的用户，您本次操作的邮箱验证码为：{code}，请妥善保管！";

    public static final String CHECK_PROVIDER = "银联";
    public static final String CHECK_PROVIDER_FACE = "百度人脸识别";
    public static final String NULL_FULLNAME = "nullnull";
    public static final String WECHATAPPLET_CHECK_PROVIDER = "微信小程序";

    public static String userId = "userId";
    public static String plate = "plate";
    public static String action = "action";
    public static String cid = "cid";
    public static String status = "status";

    public static final Integer WX_REAL_NAME_CREATE_USER_EVENT = 7;
}
