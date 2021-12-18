package com.xianwen.xuexi.common.utils;

import com.xianwen.xuexi.common.constant.Constant;
import com.xianwen.xuexi.common.exception.ErrorCodeException;
import com.xianwen.xuexi.common.response.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * @author ：hbo.huang
 * @date ：Created in 2020/11/20 13:14
 * @description：
 * @modified By：
 * @version: $
 */
@Component
@Slf4j
public class IpUtils {

    private String ip;
    private String shortip;
    private Integer intIp;

    public IpUtils() {
        ip = init();
        String[] ss = ip.split("\\.");
        shortip = ss[ss.length - Constant.ONE];
        try {
            intIp = new BigDecimal(shortip).intValue();
            log.info("IpUtils ip:{}", intIp);
        } catch (Exception e) {
            intIp = (int) (1 + Math.random() * 10);
            log.info("IpUtils ip:{}", intIp);
        }
    }

    private String init() {
        try {
            String ip = null;
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements(); ) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress() && !inetAddress.isLinkLocalAddress() && inetAddress.isSiteLocalAddress()) {
                        /** 选择本地网段192 */
                        if (inetAddress.getHostAddress().contains("10.")) {
                            ip = inetAddress.getHostAddress();
                        } else if (inetAddress.getHostAddress().contains("192.")) {
                            ip = inetAddress.getHostAddress();
                        }
                        break;
                    }
                }
            }
            return ip;
        } catch (Exception e) {
            log.error("", e);
            throw new ErrorCodeException(ErrorCode.EXCEPTION.getCode(), "获取本机ip地址异常");
        }
    }

    public String getIp() {
        return ip;
    }

    public String getShortip() {
        return shortip;
    }

    public Integer getIntIp() {
        return intIp;
    }
}
