package com.zikozee.filters.filter;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author : Ezekiel Eromosei
 * @created : 27 Nov, 2021
 */

public class RequestValidationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        var httpRequest = (HttpServletRequest) request;
        var httpResponse = (HttpServletResponse) response;

        //Todo a filter that checks if header contains request-id or is blank
        String requestId = httpRequest.getHeader("Request-Id"); // we can use anything or maybe even Authorization

        if(requestId == null || requestId.isBlank()){
            httpResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        filterChain.doFilter(request, response);
    }
}
