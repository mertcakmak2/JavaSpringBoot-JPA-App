package com.javaDemo.springBootOneToMany.DataAccess.Auth;

import com.javaDemo.springBootOneToMany.Dto.AuthRequest;

public interface IAuthDal {
	String login(AuthRequest authRequest);
}
