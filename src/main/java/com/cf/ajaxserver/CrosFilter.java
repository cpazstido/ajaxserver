package com.cf.ajaxserver;

import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CrosFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse)servletResponse;
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String origin = req.getHeader("Origin");
        if(!StringUtils.isEmpty(origin)){
            res.addHeader("Access-Control-Allow-Origin",origin);
        }

        String headers = req.getHeader("Access-Control-Request-Headers");
        if(!StringUtils.isEmpty(headers)){
            res.addHeader("Access-Control-Allow-Headers",headers);
        }

        res.addHeader("Access-Control-Allow-Methods","*");
        res.addHeader("Access-Control-Max-Age","3600");

        res.addHeader("Access-Control-Allow-Credentials","true");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
