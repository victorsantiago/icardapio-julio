package br.com.icardapio.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class FailureHandlerVh implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException ae) throws IOException, ServletException {
		// TODO Auto-generated method stub
		//UsernamePasswordAuthenticationToken user = (UsernamePasswordAuthenticationToken) ae.getAuthentication();

       // user contains required data
		
		
      response.sendRedirect(TargetURL.getDefaultUrl()+"/loginError");
		
	}
}