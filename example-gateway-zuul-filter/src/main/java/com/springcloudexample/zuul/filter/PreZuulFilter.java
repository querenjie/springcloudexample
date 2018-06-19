package com.springcloudexample.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;


public class PreZuulFilter extends ZuulFilter {
    private final Logger LOGGER = LoggerFactory.getLogger(PreZuulFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 返回的数值越小表示优先级越高
     * @return
     */
    @Override
    public int filterOrder() {
        return 1;
    }

    /**
     * 只有返回为true的时候才会执行到这个filter
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        String host = request.getRemoteHost();
        this.LOGGER.info("请求的host=" + host);
        return null;
    }
}
