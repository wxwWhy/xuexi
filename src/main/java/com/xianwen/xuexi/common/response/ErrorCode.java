/*
 * Copyright (C) 2016 eKing Technology, Inc. All Rights Reserved.
 */
package com.xianwen.xuexi.common.response;

/**
 * 返回的错误代码, 返回前端用 int, 后端用枚举, 可以减少数据传输
 * 可以基于 code 的 name 进行国际化
 * 这里只列出系统默认的 code, 其他的 code, 应该按 CodePerson 这样进行区分
 * 建议划分方法, 使用 9 位数字 (一个 int 可以表示完全), 第一位固定是 1, 接下来 4 位划分模块, 最后四位划分具体的 errorCode;
 * 如: 100010001, 表示系统错误
 * <p/>
 */
public enum ErrorCode {
    /**
     * 业务码
     */
    OK(0, "成功"),
    PISP_TOKEN_REQUEST_ERROR(700, "PISP系统配置异常"),
    WECHAT_MP_TOKEN_REQUEST_ERROR(701, "PISP系统配置异常"),
    UPGRADE_SWITCH(10000, "接口升级中"),
    RESUBMIT_ERROR(10001, "请稍后再试，请勿重复提交"),
    PHONE_CODE_REGISTER(20001, "手机验证码注册"),
    OAUTH_3RD_REGISTER(20002, "注册"),
    OAUTH_3RD_REGISTER_SUCCESS(20003, "注册成功"),
    SAFETY_PROCESS(20004, "安全流程"),
    BIND_SUCCESS(20006, "绑定成功"),
    AUTH_PROCESS(20005, "实名认证流程"),
    FFP_BIND_PHONE(20006, "金鹏绑定手机号流程"),
    RETRIEVE_ACCOUN(20007, "找回账号流程"),
    ACCOUNT_LIGHT_USER(20008, "轻用户/老用户,建议旅客加入金鹏俱乐部"),
    ACCOUNT_BIND_FFP(20009, "金鹏会员"),
    MEMBER_ACCOUNT(20010, "金鹏会员"),

    FFP_USER_NOT_MOBILE(20011, "金鹏会员没有手机号"),
    PHONE_EXIST(20012, "手机号在本地存在"),
    RETRIEVE_ACCOUNT_BY_3RD(20013, "通过第三方账户找回"),
    LOGIN_RISK_LIMIT(20014, "登录风控命中"),
    MEMBER_LOGIN_RISK_LIMIT(20025, "登录风控命中"),
    FFP_FIRST_LOGIN_RISK_LIMIT(20015, "常旅客用户第一次登录"),
    OLD_USER_PERFECT_MEMBER_INFO(20016, "提示旅客，需要注册/匹配/绑定金鹏卡后才能登录"),
    THREEE_ACCOUNT_BIND_B2C(20017, "三方账户绑定B2C"),

    THREEE_ACCOUNT_PHONE_CODE_REGISTER(20018, "三方账户绑定注册"),
    USER_BIND_FFP_PROCESS(20019, "绑定金鹏卡流程"),
    MEMBER_REGISTER_B2C(20020, "金鹏会员注册B2C"),
    USER_BIND_PHONE_PROCESS(20021, "绑定手机号流程"),
    B2C_MEMBER_MOBILE_NOT_VS(20022, "本地B2C绑定金鹏会员，手机处于未验证或者易主"),

    PHONE_REMOTE_AUTH_FFP_USER(20023, "手机号在远程是一个认证的金鹏会员"),
    LIGHT_USER_PERFECT_MEMBER_INFO(20024, "需要先绑定金鹏卡后才能修改手机号/邮箱"),
    MEMBER_CID_MERGE(20026, "卡号合并"),
    MEMBER_CID_MERGE_CHANGE_B2C(20027, "卡号被合并，但是新卡被不绑定到其他的卡号上，原来的账户恢复成B2C"),
    USER_BIND_OTHER_OPENID(20028, "openid不一致（此账户绑定了openid）"),
    USER_BIND_OTHER_OPENID_UPDATE(20029, "openid不一致（此账户绑定了openid）"),

    B2C_MEMBER_MOBILE_VS(20029, "本地B2C绑定金鹏会员，手机处于已验证"),
    MEMBER_BIND_OTHER_OPENID(20030, "openid不一致（此账户绑定了openid）"),
    OPENID_BIND_OTHER_USER(20031, "openid不一致（OPENID 绑定了其他的账户"),
    FFP_MEMBER_BIND_OTHER_OPENID(20050, "openid不一致（此账户绑定了openid）"),
    // 服务器端错误, 以 100010001 开头
    INTERNAL_SERVER_ERROR(100010002, "未处理异常"),
    ILLEGAL_ARGUMENT(100010003, "客户端输入参数错误"),
    AES_ENCODE_FAIL(100010006, "加密失败"),
    AES_DECODE_FAIL(100010007, "解密失败"),
    EXCEPTION(100010008, "其它异常"),
    FFP_EXCEPTION(300050000, "其它异常"),
    REFUND_SEARCH_ERROR(100010018, "查询失败"),
    PARSE_ENUM_ERROR(100010022, "解析枚举值有误"),
    NO_SUPPORT_PLATFORM(100010023, "未支持的支付平台"),
    MISPAY_AH_ERROR(100010026, "权限不足"),
    NO_SUPPORT_TERMINAL(100010064, "未支持的终端类型"),
    INFO_IS_REGISTER(100010065, "信息已经被注册"),
    OAUTH_LOGIN_ERROR(100010066, "登录失败"),
    REGISTER_IS_ERROR(100010067, "注册失败"),
    GUESTURE_DEVICE_ERROR(100010068, "手势密码对应的设备信息不正确"),
    UPDATE_ERROR(100010069, "更新失败"),
    INVALID_SMS_SEND_STATUS(100010070, "发送状态非法"),
    CERT_TYPE_ERROR(100010071, "证件类型不存在"),
    ACCOUNT_ERROR(100010072, "账号异常"),
    lOCAL_REGISTER_ERROR(100010073, "本地注册失败"),
    PHONE_HAS_MANY_ACCOUNT(100010074, "手机号对应多个用户信息"),
    LOGIN_PHONE_CODE_TIME_OUT(100010075, "最后一次使用短信验证码时间过久"),
    USER_FFP_MOBILE_DIFF(100010076, "本地用户与金鹏会员手机号不同"),
    /**
     * 手机验证码登录发现本地无账户，但是远程的金鹏会员绑定了一个本地的账号。
     */
    PHONE_CODE_NOT_REGISTER_AND_USE_FFP_LOGIN(100010077, "该手机号已经是金鹏会员"),
    PHONE_CODE_VERIFY_ERROR(100010078, "验证码验证失败"),
    PHONE_BIND_MANY_USER(100010079, "有多个用户绑定该手机"),
    FFP_BIND_MANY_USER(100010080, "金鹏卡号绑定了多个本地账号"),
    LOCAL_USER_BIND_OTHER_FFP_USER(100010081, "此官网账号绑定了其他金鹏卡"),
    FFP_BIND_ERROR(100010082, "绑定失败"),
    ID_BIND_MANY_FFP_USER(100010083, "证件信息绑定了多个常客用户"),
    FFP_PWD_VERIFY_ERROR(100010084, "金鹏密码验证失败"),
    PHONE_CODE_OFTEN_ERROR(100010085, "验证码发送频繁"),
    PHONE_CODE_MIN_ERROR(100010086, "短信分钟发送已经达到限制"),
    PHONE_CODE_HOURS_ERROR(100010087, "小时发动限制"),
    PHONE_CODE_MAX_ERROR(100010088, "当天发送达到上限"),
    RETRIEVE_ACCOUNT_BY_3RD_ERROR(100010089, "通过第三方账户找回失败"),
    FFP_BIND_LOCAL_USER_ERROR(100010090, "金鹏卡已绑定其他B2C账户"),
    SAFETY_PROCESS_ERROR(100010091, "安全流程校验不通过"),
    RETRIEVE_MOBILE_CHANGE_MASTER_NON_ERROR(100010092, "易主账户不存在，请使用手机＋动态验证码登录"),
    RETRIEVE_ACCOUNT_NOT_BIND_3RD_ERROR(100010093, "未绑定三方账户"),
    LOGIN_NAME_BIND_MANY_USER(100010094, "用户有多个用户名"),
    LOCAL_LOGIN_PASSWORD_ERROR(100010095, "本地密码错误"),
    HU_APP_USER_NOT_MEMBER(100010096, "手机号非金鹏会员"),
    SMS_TEMPLATE_ERROR(100010097, "短信模板没有找到"),
    ACCOUNT_FREEZE(100010098, "账号锁定"),
    FFP_FREEZE(100010099, "常客账号冻结"),
    INSERT_ERROR(100010100, "新增失败"),
    ILLEGAL_PHONE(100010101, "手机不合法"),
    ILLEGAL_EMAIL(100010102, "邮箱不合法"),
    PHONE_UNVERIFIED(100010103, "金鹏手机未验证,请更换验证方式"),
    EMAIL_UNVERIFIED(100010104, "金鹏邮箱未验证,请更换验证方式"),
    PHONE_BLACKLIST(100010105, "手机号黑名单"),
    MEMBER_AUTH_NAME_DIFF_ERROR(100010106, "会员姓名与实名认证姓名不一致"),
    MEMBER_PASSWORD_CHANGE(100010107, "密码发生变动"),
    VERIFY_PASSWORD_ERROR(100010108, "密码连续错误{0}次，还有{1}次尝试机会"),
    VERIFY_IDCARD_ERROR(100010109, "证件信息连续错误{0}次，还有{1}次尝试机会"),
    MEMBER_NEW_CID_LOGIN_ERROR(100010110, "请用新的卡号登录"),
    //状态描述
    MEMBER_STATUS_LOCK_ERROR(100010111, "由于操作异常，您的会员账号被暂时锁定无法登录，次日自动解锁，如需帮助，请联系95339。"),
    MEMBER_STATUS_FREEZE_ERROR(100010112, "由于您的会员账号状态异常，暂时无法登录，如需帮助，请联系95339。"),
    USER_MEMBER_STATUS_LOCK_ERROR(100010113, "由于操作异常，您的会员账号被暂时锁定无法登录，次日自动解锁，如需帮助，请联系95339。"),
    USER_MEMBER_STATUS_FREEZE_LOCK_ERROR(100010114, "由于您的会员账号状态异常，暂时无法登录，如需帮助，请联系95339。"),

    NOT_ALLOW_PHONE_SEND(100010115, "此手机号不允许被用来发送短信"),
    NOT_ALLOW_EMAIL_SEND(100010116, "此邮箱不允许被用来发送邮件"),
    MEMBER_OVER_LIMIT(100010117, "常客限流"),
    MEMBER_SYSTEM_ERROR(100010118, "常客系统异常"),

    VERIFY_ORDER_ERROR(100010119, "订单信息连续错误{0}次，还有{1}次尝试机会"),//Unionpay
    UNIONPAY_AUTH_LIMIT(100010120, "今日银联实名认证次数达到上限"),
    FACE_AUTH_LIMIT(100010121, "今日人脸识别认证次数达到上限"),
    B2C_USER_HAS_MOBILE(100010122, "用户已经拥有已验证手机号"),
    DB_CONN_EXCEPTION(100010123, "数据库连接异常"),
    SIMPLE_PASSWORD_EXCEPTION(100010124, "简单密码"),
    USER_FFP_MOBILE_DIFF_NOT_LOGIN(100010125, "本地用户与金鹏会员手机号不同"),
    NOT_ACCOUNT_WHITELIST(100010126, "用户（账号）不在白名单"),
    USER_FFP_BIND_MOBILE_DIFF_NOT_LOGIN(100010127, "绑定金鹏卡本地用户与金鹏会员手机号不同"),
    REGISTER_CHECK_MOBILE_OUT_TIME_EXPIRE_LIMIT(100010128, "手机号已被轻用户使用且注册日期超过3个月"),
    REGISTER_CHECK_MOBILE_EXPIRE_LIMIT(100010129, "手机号已被轻用户使用且注册日期在3个月内"),
    NOT_FOUND_IDCARD_MEMBER(100010130, "未找到与身份信息相匹配的会员"),

    SYS_EMAIL_EXIST(520010000, "邮箱已被其它用户注册使用"),
    SYS_LOGIN_NAME_HAS_REGISTER(520010001, "用户名已存在"),
    OTHER_FFP_MEMBER_BIND_OPENID(520010002, "会员绑定了此第三方账户"),
    OTHER_USER_BIND_OPENID(520010003, "非金鹏用户绑定了此第三方账户"),
    WX_MEMBER_AUTH_DIFF_ERROR(100010106, "实名信息与会员资料不一致"),

    //走创建轻用户流程（对应type=7：用户表中有一个userId唯一绑定手机号，未通过风控且user为金鹏会员,实名信息不一致）
    WX_MEMBER_AUTH_DIFF_ERROR7(100010107, "实名信息与会员资料不一致"),
    //走创建轻用户流程（对应type=8：用户表中无该手机号存在，但常旅客那边手机号对应存在金鹏会员，该金鹏卡未绑定本地b2c用户,实名信息不一致）
    WX_MEMBER_AUTH_DIFF_ERROR8(100010108, "实名信息与会员资料不一致"),
    //走创建轻用户流程（对应type=9：用户表中无该手机号存在，但常旅客那边手机号对应存在金鹏会员；且该金鹏卡存在本地唯一的b2c用户，未通过风控，实名信息不一致）
    WX_MEMBER_AUTH_DIFF_ERROR9(100010109, "实名信息与会员资料不一致"),
    //登录成功(非金鹏会员登录成功)-命中风控
    WX_USER_LOGIN_SUCCESS_WITH_RISK_LIMIT(20040, "登录成功(非金鹏会员登录成功)-命中风控");

    // 返回客户端的编码
    private final long code;

    // 默认消息
    private final String defaultMessage;

    ErrorCode(long code, String defaultMessage) {
        this.code = code;
        this.defaultMessage = defaultMessage;
    }

    public static ErrorCode get(long code) {
        for (ErrorCode value : ErrorCode.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        return null;
    }

    public long getCode() {
        return code;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }
}