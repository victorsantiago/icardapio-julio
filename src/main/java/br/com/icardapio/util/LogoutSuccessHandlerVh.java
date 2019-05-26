package br.com.icardapio.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import br.com.icardapio.util.TargetURL;

public class LogoutSuccessHandlerVh implements LogoutSuccessHandler{
    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                Authentication authentication) throws IOException, ServletException {
        if (authentication != null && authentication.getDetails() != null) {
            try {
                httpServletRequest.getSession().invalidate();
                //System.out.println("User Successfully Logout");
                //you can add more codes here when the user successfully logs out,
                //such as updating the database for last active.
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            /*StringBuffer requestURL = httpServletRequest.getRequestURL();
            String queryString = httpServletRequest.getQueryString();
            String urlfull="";
            if (queryString == null) {
                urlfull= requestURL.toString();
            } else {
            	urlfull = requestURL.append('?').append(queryString).toString();
            }
            System.out.println("--->   "+urlfull);*/
            
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        //redirect to login
        httpServletResponse.sendRedirect(TargetURL.getDefaultUrl());
    }
}
}



