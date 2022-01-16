package com.zikozee.corscsrfprotection.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.web.csrf.CsrfToken;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author : Ezekiel Eromosei
 * @created : 16 Jan, 2022
 */


@Slf4j
public class CsrfTokenLogger implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Object o  = servletRequest.getAttribute("_csrf");

        CsrfToken csrfToken = (CsrfToken) o;

        log.info("CSRF Token " + csrfToken.getToken());

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
