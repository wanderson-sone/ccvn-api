package br.com.ccvn.api.security;

import br.com.ccvn.api.models.User;
import br.com.ccvn.api.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class AddinformationToken implements TokenEnhancer {

    @Autowired
    private IUsuarioService service;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {

        User user = service.findByEmail(authentication.getName());


        Map<String, Object> infor = new HashMap<>();
        infor.put("username", "Email: ".concat(authentication.getName()));
        infor.put("email", user.getEmail());
        infor.put("name", user.getName());
        infor.put("status", user.getStatus());
        infor.put("createdAt", user.getCreatedAt().toString());
        infor.put("updatedAt", user.getUpdatedAt().toString());

        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(infor);

        return accessToken;
    }
}
