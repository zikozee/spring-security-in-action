package com.zikozee.authorizationserve.enhancer;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.time.ZoneId;
import java.util.Map;

/**
 * @author : Ezekiel Eromosei
 * @created : 20 Feb, 2022
 */

public class CustomTokenEnhancer implements TokenEnhancer {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        DefaultOAuth2AccessToken defaultOAuth2AccessToken = new DefaultOAuth2AccessToken(oAuth2AccessToken);

        Map<String, Object> info =
                Map.of("generatedInZone", ZoneId.systemDefault().toString(), "userReviewwFromDB", 15);

        defaultOAuth2AccessToken.setAdditionalInformation(info);

        return defaultOAuth2AccessToken;
    }
}
