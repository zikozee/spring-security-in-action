package com.ezikozee.businesslogicserverscenarioone.authserverproxy;


import com.ezikozee.businesslogicserverscenarioone.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author : Ezekiel Eromosei
 * @created : 29 Jan, 2022
 */

@Component
@RequiredArgsConstructor
public class AuthenticationServerProxy {

    private final RestTemplate restTemplate;

    @Value("${auth.server.base.url}")
    private String baseUrl;


    public void sendAuth(String username, String password){

        String url = baseUrl + "/user/auth";

        var body = User.builder()
                .username(username)
                .password(password)
                .build();

        var request = new HttpEntity<>(body);

        restTemplate.postForEntity(url, request, Void.class);

    }

    public boolean sendOtp(String username, String code){

        String url = baseUrl + "/otp/check";

        var body = User.builder()
                .username(username)
                .code(code)
                .build();

        var request = new HttpEntity<>(body);

        var response = restTemplate.postForEntity(url, request, Void.class);

        return response
                .getStatusCode()
                .equals(HttpStatus.OK);

    }

    public String getUserKey(String username){

        String url = baseUrl + "/user/key";

        UserKeyDto userKeyDto = UserKeyDto.builder().username(username).build();

        var request = new HttpEntity<>(userKeyDto);

        var response = restTemplate.postForEntity(url, request, String.class);

        return response.getBody();

    }

}
