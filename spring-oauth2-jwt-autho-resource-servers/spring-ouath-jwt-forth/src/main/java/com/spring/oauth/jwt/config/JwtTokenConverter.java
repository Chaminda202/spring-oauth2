package com.spring.oauth.jwt.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.boot.autoconfigure.security.oauth2.resource.JwtAccessTokenConverterConfigurer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.stereotype.Component;

import com.spring.oauth.jwt.model.AccessTokenMapper;

//@Component
public class JwtTokenConverter extends DefaultAccessTokenConverter implements JwtAccessTokenConverterConfigurer {

	@Override
	public void configure(JwtAccessTokenConverter converter) {
		converter.setAccessTokenConverter(this);
	}

	@Override
	public OAuth2Authentication extractAuthentication(Map<String, ?> map) {
		OAuth2Authentication oAuth2Authentication = super.extractAuthentication(map);
		AccessTokenMapper accessTokenMapper = new AccessTokenMapper();
		if(map.get("email") != null){
			accessTokenMapper.setEmail((String) map.get("email"));
		}
		if(map.get("user_type") != null){
			accessTokenMapper.setUserType((String) map.get("user_type"));
		}
		List<String> authorities = new ArrayList<>();
		oAuth2Authentication.getAuthorities().forEach(auth -> {
			authorities.add(auth.getAuthority());
		});
		accessTokenMapper.setAuthorities(authorities);
		oAuth2Authentication.setDetails(accessTokenMapper);
		return super.extractAuthentication(map);
	}
}
