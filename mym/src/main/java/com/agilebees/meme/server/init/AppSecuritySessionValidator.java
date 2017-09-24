package com.agilebees.meme.server.init;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import net.customware.gwt.dispatch.server.secure.SecureSessionValidator;

@Component
public class AppSecuritySessionValidator implements SecureSessionValidator{

	@Override
	public boolean isValid(String sessionId, HttpServletRequest req) {
		// TODO Auto-generated method stub
		return true;
	}

}
