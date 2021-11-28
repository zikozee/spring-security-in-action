package com.zikozee.authenticationserver.domain.user;

import com.zikozee.authenticationserver.domain.otp.Otp;
import com.zikozee.authenticationserver.domain.otp.OtpRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.zikozee.authenticationserver.util.GenerateCodeUtil.generateCode;

/**
 * @author : Ezekiel Eromosei
 * @created : 27 Nov, 2021
 */

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final OtpRepository otpRepository;

    public void addUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public void auth(User user){
        Optional<User> optionalUser =
                userRepository.getUserByUsername(user.getUsername());

        if(optionalUser.isPresent()){
            User presentUser = optionalUser.get();
            if(passwordEncoder.matches(user.getPassword(), presentUser.getPassword())){
                renewOtp(presentUser);
            }else throw new BadCredentialsException("Bad Credentials.");
        }else throw new BadCredentialsException("Bad Credentials");
    }

    private void renewOtp(User presentUser) {

        String code = generateCode();

        Optional<Otp> userOtp = otpRepository.getOtpByUsername(presentUser.getUsername());

        Otp otp;
        if(userOtp.isPresent()){
            otp = userOtp.get();
        }else{
            otp = new Otp();
            otp.setUsername(presentUser.getUsername());
        }
        otp.setCode(code);
        otpRepository.save(otp);
    }

    public boolean check(Otp otpToValidate){
        Optional<Otp> userOtp = otpRepository
                .getOtpByUsername(otpToValidate.getUsername());

        if(userOtp.isPresent()){
            Otp otp = userOtp.get();
            return otpToValidate.getCode().equals(otp.getCode());
        }

        return false;
    }

}
