package com.zikozee.authenticationserver.domain.otp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : Ezekiel Eromosei
 * @created : 27 Nov, 2021
 */

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class OtpService {
}
