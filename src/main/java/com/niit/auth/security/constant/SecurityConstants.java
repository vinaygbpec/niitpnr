package com.niit.auth.security.constant;

public interface SecurityConstants {
	String SECRET = "HmacSHA256";

	long EXPIRATION_TIME = 864_000_000; // 10 days

	String TOKEN_PREFIX = "Bearer ";

	String HEADER_STRING = "Authorization";

	String SIGN_UP_URL = "/users/sign-up";
}