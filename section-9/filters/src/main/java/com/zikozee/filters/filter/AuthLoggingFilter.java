package com.zikozee.filters.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : Ezekiel Eromosei
 * @created : 27 Nov, 2021
 */

@Slf4j
public class AuthLoggingFilter extends OncePerRequestFilter {


//    @Override
//    public void doFilterInternal(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//      var httpRequest = (HttpServletRequest) servletRequest;
//
//      var requestId =
//              httpRequest.getHeader("Request-Id");
//
//      log.info("=======>>>>>>>>>>>Successfully authenticated request with id: {} <<<<<<<<<<=============", requestId);
//
//      filterChain.doFilter(servletRequest, servletResponse);
//    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        var requestId =
                request.getHeader("Request-Id"); // we can use anything or maybe even Authorization

        log.info("=======>>>>>>>>>>>Successfully authenticated request with id: {} <<<<<<<<<<=============", requestId);

        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return super.shouldNotFilter(request);
    }

    @Override
    protected boolean shouldNotFilterAsyncDispatch() {
        return false;
    }

    @Override
    protected boolean shouldNotFilterErrorDispatch() {
        return false;
    }
}
