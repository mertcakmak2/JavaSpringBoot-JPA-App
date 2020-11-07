package com.javaDemo.springBootOneToMany.DataAccess.Auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaDemo.springBootOneToMany.Entities.AuthRequest;
import com.javaDemo.springBootOneToMany.Util.JwtUtil;

@Repository
public class AuthDal implements IAuthDal{

	@Autowired
	private JwtUtil jwtUtil;
	
	@Override
	public String login(AuthRequest authRequest) {
		return jwtUtil.generateToken(authRequest.getEmail());
	}

}
