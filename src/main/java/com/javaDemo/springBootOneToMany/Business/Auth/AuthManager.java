package com.javaDemo.springBootOneToMany.Business.Auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.javaDemo.springBootOneToMany.DataAccess.Auth.IAuthDal;
import com.javaDemo.springBootOneToMany.DataAccess.Customer.CustomerRepository;
import com.javaDemo.springBootOneToMany.Dto.AuthRequest;
import com.javaDemo.springBootOneToMany.Entities.Customer;

@Service
public class AuthManager implements IAuthService{
	
	@Autowired
	private IAuthDal authDal;
	@Autowired
	private CustomerRepository repository;
	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public String login(AuthRequest authRequest) throws Exception {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		Customer customer = repository.findByEmail(authRequest.getEmail());
		if(customer == null )  
			throw new Exception("Kullanıcı adı ve şifrenizi kontrol ediniz.");
		boolean isPasswordMatch = passwordEncoder.matches(authRequest.getPassword(), customer.getPassword());
		if(!isPasswordMatch) throw new Exception("invalid username/password");
		
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getEmail(), customer.getPassword()));
		} catch(Exception e) {
			throw new Exception("invalid username/password");
		}
		
		String result = authDal.login(authRequest) == null ? "kullanıcı yada şifre yanlış" : authDal.login(authRequest);
		return result;
	}

}
