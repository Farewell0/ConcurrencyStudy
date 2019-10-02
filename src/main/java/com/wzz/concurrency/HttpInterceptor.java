package com.wzz.concurrency;

import com.wzz.concurrency.example.threadlocal.RequestHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * HttpInterceptor
 *
 * @author wzzfarewell
 * @date 2019/10/1
 **/
public class HttpInterceptor extends HandlerInterceptorAdapter {
    private static Logger logger = LoggerFactory.getLogger(HandlerInterceptorAdapter.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("preHandler");
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        RequestHolder.remove();
        logger.info("afterCompletion");
        return;
    }
}
