package com.zikozee.authenticationserver.controller;

import com.zikozee.authenticationserver.domain.otp.Otp;
import com.zikozee.authenticationserver.domain.user.User;
import com.zikozee.authenticationserver.domain.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author : Ezekiel Eromosei
 * @created : 27 Nov, 2021
 */

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping(path = "user/add")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @PostMapping(path = "user/auth")
    public void auth(@RequestBody User user){
        userService.auth(user);
    }

    @PostMapping(path = "otp/check")
    public void check(@RequestBody Otp otp, HttpServletResponse response){
        if(userService.check(otp))
            response.setStatus(HttpServletResponse.SC_OK);
        else
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
    }
}
