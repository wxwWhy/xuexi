package com.xianwen.xuexi.filter;

import com.xianwen.xuexi.common.utils.IpUtils;
import com.xianwen.xuexi.common.utils.UuidUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.xianwen.xuexi.common.constant.Constant.REQUEST_ID;
import static com.xianwen.xuexi.common.constant.Constant.SHORTIP;

/**
 * @author xw.weng
 * @description logbackMDC
 * @date
 */
@Slf4j
@Component
public class LogInterceptor implements HandlerInterceptor {

    @Autowired
    IpUtils ipUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String requestId = new StringBuilder(UuidUtils.getUUID()).append(ipUtils.getShortip()).toString();
        MDC.put(REQUEST_ID, requestId);
        MDC.put(SHORTIP, ipUtils.getShortip());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        MDC.remove(REQUEST_ID);
    }

}
