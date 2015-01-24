package com.javahelp.tracking.security.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestAuthenticationSuccessHandler extends
		SimpleUrlAuthenticationSuccessHandler {
	
	Logger logger = LoggerFactory.getLogger("c.j.t.c.w.s.AuthenticationSuccessHandler");
	
	private RequestCache requestCache = new HttpSessionRequestCache();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,HttpServletResponse response,
			Authentication authentication){
		final SavedRequest saveRequest = requestCache.getRequest(request, response);
		
		if(saveRequest == null){
			clearAuthenticationAttributes(request);
			return;
		}
		
		final String targetUrlParameter = getTargetUrlParameter();
		if(isAlwaysUseDefaultTargetUrl()
				|| (targetUrlParameter != null && StringUtils.hasText(
						request.getParameter(targetUrlParameter)))){
			requestCache.removeRequest(request, response);
			clearAuthenticationAttributes(request);
			return;
		}
		
		clearAuthenticationAttributes(request);
	}
	
	public void setRequestCache(RequestCache requestCache) {
		this.requestCache = requestCache;
	}
	
}
