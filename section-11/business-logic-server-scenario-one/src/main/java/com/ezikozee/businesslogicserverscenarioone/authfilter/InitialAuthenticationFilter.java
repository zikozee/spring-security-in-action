package com.ezikozee.businesslogicserverscenarioone.authfilter;


import com.ezikozee.businesslogicserverscenarioone.authprovider.authobject.JwtAuthentication;
import com.ezikozee.businesslogicserverscenarioone.authprovider.authobject.OtpAuthentication;
import com.ezikozee.businesslogicserverscenarioone.authprovider.authobject.UsernamePasswordAuthentication;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpHeaders;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

/**
 * @author : Ezekiel Eromosei
 * @created : 29 Jan, 2022
 */


public class InitialAuthenticationFilter extends OncePerRequestFilter {


    private final AuthenticationManager manager;
    private final String baseSigningKey;

    public InitialAuthenticationFilter(AuthenticationManager manager, String baseSigningKey) {
        this.manager = manager;
        this.baseSigningKey = baseSigningKey;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) {

        String username = request.getHeader("username");
        String password = request.getHeader("password");
        String code = request.getHeader("code");
        String token = request.getHeader(AUTHORIZATION);

        if(password != null && code == null && token == null){
            Authentication auth = new UsernamePasswordAuthentication(username, password);
            manager.authenticate(auth);
        }else if(password ==null && code !=null && token == null){
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
        }else{

            SecretKey key = Keys.hmacShaKeyFor((baseSigningKey).getBytes(StandardCharsets.UTF_8));

            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(key).build()
                    .parseClaimsJws(token)
                    .getBody();

            String authName = String.valueOf(claims.get("username"));

            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("user");
            Authentication auth = new JwtAuthentication(authName, null, List.of(grantedAuthority));

            SecurityContextHolder.getContext().setAuthentication(auth);

//            Authentication newAuth = new JwtAuthentication(authName, token, List.of(grantedAuthority));

            manager.authenticate(auth);
        }

    }

//    @Override
//    protected boolean shouldNotFilter(HttpServletRequest request) {
//        return !request.getServletPath().equals("/login")
//                || !request.getServletPath().equals("/test"); // Applies this filter only to the /login  and /test path
//    }
}
