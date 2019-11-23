package com.leyou.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.FORM_BODY_WRAPPER_FILTER_ORDER;
@Component
public class MyFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants. PRE_TYPE;//表示一个前置的过滤器(进入到微服务之前起作用)
    }

    @Override
    public int filterOrder() {
        return FORM_BODY_WRAPPER_FILTER_ORDER-5;  //过滤器的执行顺序  规则：值越小越先执行
    }

    @Override
    public boolean shouldFilter() {
        return true;//   true表示过滤 false表示不过滤
    }

    @Override
    public Object run() throws ZuulException {
        //判断请求中是否带有参数token
        //为了获取request
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        //获取参数token的域
        String token = request.getParameter("token");
        if (StringUtils.isEmpty(token)) {
            //如果为空,不让进到微服务
            ctx.setSendZuulResponse(false);//false表示不让进到微服务
            ctx.setResponseStatusCode(HttpStatus.SC_FORBIDDEN);//l返回一个状态码
        }
        return null;//表示正常进入到微服务了
    }
}
