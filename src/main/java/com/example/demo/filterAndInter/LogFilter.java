package com.example.demo.filterAndInter;

import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 功能描述：
 *
 * @Author: hanlq
 * @Date: 2020/12/22 上午11:12
 */
@WebFilter(urlPatterns = "/*",filterName = "logfilter")
public class LogFilter implements Filter {
    @Autowired
    private TestService testService;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("dofilter before ");
        System.out.println(testService.getname());
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("dofilter after ");
    }

    @Override
    public void destroy() {

    }
}
