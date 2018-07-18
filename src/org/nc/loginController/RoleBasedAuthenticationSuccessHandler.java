package org.nc.loginController;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class RoleBasedAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	
	private Map<String, String> roleUrlMap;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication) throws IOException,
			ServletException {
		// TODO Auto-generated method stub
		
		if (authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            userDetails.getUsername();
            String role = userDetails.getAuthorities().isEmpty() ? null : userDetails.getAuthorities().toArray()[0]
                    .toString();
            request.getSession().setAttribute("user", userDetails.getUsername().toString());
            request.getSession().setAttribute("role", role);
// Tushar Commented   System.out.println("Password=="+userDetails.getPassword().toString());
// Tushar Commented   request.getSession().setAttribute("password", userDetails.getPassword().toString());
            response.sendRedirect(request.getContextPath() + roleUrlMap.get(role));
        }
		
	}
	
	public void setRoleUrlMap(Map<String, String> roleUrlMap) {
        this.roleUrlMap = roleUrlMap;
    }

}
