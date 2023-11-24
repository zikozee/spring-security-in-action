package com.zikozee.authorizationserver.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import java.util.concurrent.TimeUnit;

/**
 * @author : Ezekiel Eromosei
 * @created : 20 Feb, 2022
 */

@Configuration
@EnableAuthorizationServer
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {

    @Value("${password}")
    private String password;

    @Value("${privateKey}")
    private String privateKey;

    @Value("${alias}")
    private String alias;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //todo not recommended for loading db clients
//        clients.inMemory()
//                .withClient("client1")
//                .secret("secret1")
//                .authorizedGrantTypes("password", "refresh_token")
//                .scopes("read")
//                .accessTokenValiditySeconds((int) TimeUnit.MINUTES.toSeconds(30))
//                .refreshTokenValiditySeconds((int)TimeUnit.HOURS.toSeconds(2));
        clients.inMemory()
        .withClient("dev-channel")
                .secret("pI*#Vj&4Whnb902B6cepMP5*4588RDt%!VI4ecZdMY%h5mjQn9")
                .authorizedGrantTypes("client_credentials", "refresh_token")
                .scopes("create", "read", "update").autoApprove(true)
                .authorities("READ_LOAN_LIMIT","CREATE_LOAN","READ_LOAN_STATUS","REPAY_LOAN","READ_LOAN_INTEREST_FEE", "READ_LOAN_BALANCE", "READ_LOAN_CUSTOMER_INFO", "CREATE_ECOSYSTEM_LOAN","READ_ECOSYSTEM_LOAN_BALANCE","READ_ECOSYSTEM_LOAN_CUSTOMER_INFO","READ_ECOSYSTEM_LOAN_INTEREST_FEE", "READ_ECOSYSTEM_LOAN_INTEREST_FEE","READ_ECOSYSTEM_LOAN_LIMIT", "REPAY_ECOSYSTEM_LOAN")
                .accessTokenValiditySeconds((int) TimeUnit.HOURS.toSeconds(1))
                .refreshTokenValiditySeconds((int) TimeUnit.HOURS.toSeconds(2));
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager)
                .tokenStore(this.tokenStore())
                .accessTokenConverter(this.jwtAccessTokenConverter());
    }

    @Bean
    public TokenStore tokenStore(){
        return new JwtTokenStore(this.jwtAccessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();

        KeyStoreKeyFactory keyStoreKeyFactory =
                new KeyStoreKeyFactory(new ClassPathResource(privateKey), password.toCharArray());

        converter.setKeyPair(keyStoreKeyFactory.getKeyPair(alias));
        return converter;
    }
}
