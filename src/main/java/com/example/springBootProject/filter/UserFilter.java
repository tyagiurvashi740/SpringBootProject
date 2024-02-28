package com.example.springBootProject.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(1)
public class UserFilter  implements Filter{
        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                             FilterChain filterChain) throws IOException, ServletException {
            Logger LOG = LoggerFactory.getLogger (com.example.springBootProject.filter.MyFilter.class);
            HttpServletRequest req = (HttpServletRequest)servletRequest;
            System.out.println(req.getRequestURI());
            System.out.println(req.getMethod());
            LOG.info(
                    "Starting a transaction for req in UserFilter : {}",
                    req.getRequestURI());

            filterChain.doFilter(servletRequest, servletResponse);
            LOG.info(
                    "Committing a transaction for req in UserFilter : {}",
                    req.getRequestURI());
        }



    }

