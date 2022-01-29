package com.zikozee.businesslogic.authfilter;

import com.zikozee.businesslogic.authprovider.authobject.OtpAuthentication;
import com.zikozee.businesslogic.authprovider.authobject.UsernamePasswordAuthentication;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * @author : Ezekiel Eromosei
 * @created : 29 Jan, 2022
 */


public class InitialAuthenticationFilter extends OncePerRequestFilter {


    private final AuthenticationManager manager;
    private final String baseSigningKey;

//    private final AuthenticationServerProxy proxy;

    public InitialAuthenticationFilter(AuthenticationManager manager, String baseSigningKey) {
        this.manager = manager;
        this.baseSigningKey = baseSigningKey;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) {

        String username = request.getHeader("username");
        String password = request.getHeader("password");
        String code = request.getHeader("code");

        if(code == null){
            Authentication auth = new UsernamePasswordAuthentication(username, password);
            manager.authenticate(auth);
        }else{
            Authentication auth = new OtpAuthentication(username, code);

            manager.authenticate(auth);

            //unique user key
//            String userKey = proxy.getUserKey(username);
//            SecretKey key = Keys.hmacShaKeyFor((baseSigningKey + userKey).getBytes(StandardCharsets.UTF_8));
            SecretKey key = Keys.hmacShaKeyFor((baseSigningKey).getBytes(StandardCharsets.UTF_8));

            String jwt = Jwts.builder()
                    .setClaims(Map.of("username", username))
                    .signWith(key)
                    .compact();

            response.setHeader("Authorization", jwt);
        }

    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        return !request.getServletPath().equals("/login"); // Applies this filter only to the /login path
    }
}
