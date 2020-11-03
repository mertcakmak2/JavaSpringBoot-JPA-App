package com.javaDemo.springBootOneToMany.RestAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaDemo.springBootOneToMany.Entities.AuthRequest;
import com.javaDemo.springBootOneToMany.Util.JwtUtil;

@RestController
public class WelcomeController {
	
	@Autowired
	private JwtUtil jwtUtil;
	
	private AuthenticationManager authenticationManager;

	@Autowired
	public WelcomeController(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@GetMapping("/")
	public String welcome() {
		return "welcome to java";
	}
	
	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
		} catch(Exception e) {
			throw new Exception("invalid username/password");
		}
		return jwtUtil.generateToken(authRequest.getEmail());
	}
}
