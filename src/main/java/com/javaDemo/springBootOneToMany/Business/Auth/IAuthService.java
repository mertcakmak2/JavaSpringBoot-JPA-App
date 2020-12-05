package com.javaDemo.springBootOneToMany.Business.Auth;

import com.javaDemo.springBootOneToMany.Dto.AuthRequest;

public interface IAuthService {
	String login(AuthRequest authRequest)throws Exception;
}
