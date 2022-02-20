package com.zikozee.resourceserverr.additionaljwtclaims;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.Map;

/**
 * @author : Ezekiel Eromosei
 * @created : 20 Feb, 2022
 */

public class AdditionalClaimsAccessTokenConverter extends JwtAccessTokenConverter {

    @Override
    public OAuth2Authentication extractAuthentication(Map<String, ?> map) {
        OAuth2Authentication oAuth2Authentication = super.extractAuthentication(map);

        oAuth2Authentication.setDetails(map);

        return oAuth2Authentication;
    }
}
