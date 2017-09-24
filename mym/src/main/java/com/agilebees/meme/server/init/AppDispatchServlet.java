package com.agilebees.meme.server.init;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import net.customware.gwt.dispatch.server.spring.SpringSecureDispatchServlet;

public class AppDispatchServlet extends SpringSecureDispatchServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3478824227276236436L;
	
	@Override
	public void service(ServletRequest request,ServletResponse response) throws ServletException, IOException{
		
		super.service(request, response);
		
	}
	

}
