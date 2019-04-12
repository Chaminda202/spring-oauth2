package com.spring.oauth.jwt.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.stereotype.Component;

//@Component
public class JdbcTokenEnhancer extends JdbcTokenStore {
	private Logger logger = LoggerFactory.getLogger(JdbcTokenEnhancer.class);
	
	public JdbcTokenEnhancer(DataSource dataSource) {
		super(dataSource);
	}

	@Override
	public OAuth2AccessToken readAccessToken(String tokenValue) {
		OAuth2AccessToken accessToken = null;

	    try {
	        accessToken = new DefaultOAuth2AccessToken(tokenValue);
	    }
	    catch (EmptyResultDataAccessException e) {
	        if (logger.isInfoEnabled()) {
	        	logger.info("Failed to find access token for token "+tokenValue);
	        }
	    }
	    catch (IllegalArgumentException e) {
	    	logger.warn("Failed to deserialize access token for " +tokenValue,e);
	        removeAccessToken(tokenValue);
	    }
	    return accessToken;
	}
	
}
