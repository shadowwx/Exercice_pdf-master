package org.epsi.security;

import org.epsi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

//Amélioration Programme 2.0 ajout d'identifiant
//Permet d'attribuer des accées aux utilisateur authentifier

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	UserService userService;
	
//	public CustomAuthenticationProvider()
//	{
//		super();
//		this.userService = new UserService();
//	}
	
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		if(authentication.getName() != null && authentication.getCredentials() != null)
		{	
//			String name = authentication.getName();
//	        String password = authentication.getCredentials().toString();
//	        
//	        
//	        Optional<User> userOpt = userService.findUserByUserName(name);
//	        if ((userOpt.isPresent()) && userOpt.get().getPassword().equals(password)) 
//	        {
//	            return new UsernamePasswordAuthenticationToken(name, password);
//	        }
        }
		if(SecurityContextHolder.getContext().getAuthentication() != null && SecurityContextHolder.getContext().getAuthentication().getPrincipal() != null)
		{
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			return new UsernamePasswordAuthenticationToken(auth.getName(), null);
		}
       return null;
	}

	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}