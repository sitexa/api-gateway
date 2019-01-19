package com.weibo.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: xnpeng (xpneng@hotmail.com)
 * @date: 2019/1/19
 * @doc description
 **/
@Slf4j
public class AccessFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        Object accessToken = request.getParameter("accessToken");

        log.info("Send {} request to {}",request.getMethod(),request.getRequestURL().toString());

        if(accessToken==null){
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(HttpServletResponse.SC_UNAUTHORIZED);
        }

        return null;
    }
}
