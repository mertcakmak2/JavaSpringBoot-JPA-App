package com.javaDemo.springBootOneToMany.DataAccess.Auth;

import com.javaDemo.springBootOneToMany.Entities.AuthRequest;

public interface IAuthDal {
	String login(AuthRequest authRequest);
}
