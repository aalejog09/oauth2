package com.api.resources.config.oauth.security;


import com.api.resources.config.oauth.properties.CorsProperties;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
@Configuration
public class CustomCorsFilter implements Filter {


    @Autowired
    CorsProperties corsProperties;

    public CustomCorsFilter(){}


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest) req;
        response.setHeader("Access-Control-Allow-Origin",corsProperties.getAllowedOrigin());
        response.setHeader("Access-Control-Allow-Methods",corsProperties.getAllowedMethod());
        response.setHeader("Access-Control-Max-Age",corsProperties.getMaxAge());
        response.setHeader("Access-Control-Allow-Headers",corsProperties.getAllowedHeader());

        if("OPTIONS".equalsIgnoreCase(request.getMethod())){
            response.setStatus(HttpServletResponse.SC_OK);
        }else{
            chain.doFilter(req,res);
        }

    }

}