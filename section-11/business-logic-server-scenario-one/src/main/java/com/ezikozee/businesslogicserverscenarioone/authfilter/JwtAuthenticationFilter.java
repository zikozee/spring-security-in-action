package com.ezikozee.businesslogicserverscenarioone.authfilter;

import com.ezikozee.businesslogicserverscenarioone.authprovider.authobject.UsernamePasswordAuthentication;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author : Ezekiel Eromosei
 * @created : 29 Jan, 2022
 */

////@Component
//public class JwtAuthenticationFilter extends OncePerRequestFilter {
//
//    @Value("${jwt.base.signing.key}")
//    public String baseSigningKey;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//
//        String jwt = request.getHeader(HttpHeaders.AUTHORIZATION);
//
//        SecretKey key = Keys.hmacShaKeyFor((baseSigningKey).getBytes(StandardCharsets.UTF_8));
//
//        Claims claims = Jwts.parserBuilder()
//                .setSigningKey(key).build()
//                .parseClaimsJws(jwt)
//                .getBody();
//
//        String username = String.valueOf(claims.get("username"));
//
//        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("user");
//        var auth = new UsernamePasswordAuthentication(username, null, List.of(grantedAuthority));
//
//        SecurityContextHolder.getContext().setAuthentication(auth);
//
//        filterChain.doFilter(request, response);
//    }
//
//    @Override
//    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
//        return request.getServletPath()
//                .equals("/login"); // based on this, this filter will not be triggered for "/login"
//    }
//}
