package com.zikozee.authorizationserver.ProjectConfig;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.security.oauth2.provider.client.InMemoryClientDetailsService;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author : Ezekiel Eromosei
 * @created : 13 Feb, 2022
 */

@Configuration
@EnableAuthorizationServer
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {
    public static final String AUTHORIZATION_CODE_GRANT = "authorization_code";
    public static final String PASSWORD_GRANT = "password";
    public static final String CLIENT_CREDENTIALS = "client_credentials";
    public static final String REFRESH_TOKEN = "refresh_token";

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager);
    }


    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        var service = new InMemoryClientDetailsService();  //create CustomClientDetailsService implement ClientDetailsService to load client details and inject in line 47

        var cd = new BaseClientDetails();
        cd.setClientId("client1");
        cd.setClientSecret("secret1");
        cd.setScope(List.of("read"));
        cd.setAuthorizedGrantTypes(List.of(PASSWORD_GRANT, REFRESH_TOKEN));


        var cd2 = new BaseClientDetails();
        cd2.setClientId("client2");
        cd2.setClientSecret("secret2");
        cd2.setScope(List.of("read"));
        cd2.setAuthorizedGrantTypes(List.of(AUTHORIZATION_CODE_GRANT, REFRESH_TOKEN));
        cd2.setRegisteredRedirectUri(Set.of("http://localhost:9090/home"));

        // todo info: BAD PRACTICE BELOW --> ONE CLIENT -> ONE GRANT: else client details might be lost   EXCEPT REFRESH TOKEN
//        cd2.setAuthorizedGrantTypes(List.of(AUTHORIZATION_CODE_GRANT, PASSWORD_GRANT, REFRESH_TOKEN));

        var cd3= new BaseClientDetails();
        cd3.setClientId("client3");
        cd3.setClientSecret("secret3");
        cd3.setScope(List.of("info"));
        cd3.setAuthorizedGrantTypes(List.of(CLIENT_CREDENTIALS));


        service.setClientDetailsStore(Map.of("client1", cd,"client2", cd2, "client3", cd3));
        clients.withClientDetails(service);

        //todo info: shorter implementation use above for DATABASE connection
//        clients.inMemory()
//                .withClient("client1")
//                .secret("secret2")
//                .authorizedGrantTypes(AUTHORIZATION_CODE_GRANT)
//                .scopes("read")
//                .redirectUris("http://localhost:9090/home")
//
//                .and()
//
//                .withClient("client2")
//                .secret("secret2")
//                .authorizedGrantTypes(AUTHORIZATION_CODE_GRANT, PASSWORD_GRANT, REFRESH_TOKEN)
//                .scopes("read")
//                .redirectUris("http://localhost:9090/home")
//
//                .and()
//
//                .withClient("client3")
//                .secret("secret3")
//                .authorizedGrantTypes(AUTHORIZATION_CODE_GRANT, PASSWORD_GRANT, REFRESH_TOKEN)
//                .scopes("info");
    }
}
