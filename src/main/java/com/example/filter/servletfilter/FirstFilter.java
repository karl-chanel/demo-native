package com.example.filter.servletfilter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @author jasper
 * @email jaspersteelxx@gmail.com
 * @create 2023-02-09 03:19
 **/
@Slf4j
@WebFilter(filterName = "first", urlPatterns = "/user/*")
public class FirstFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("inside first filter");
        chain.doFilter(request, response);
    }
}
