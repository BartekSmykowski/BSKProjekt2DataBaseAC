package edu.bsk.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;

public class LoginPasswordRoleAuthenticationToken extends UsernamePasswordAuthenticationToken {

    public LoginPasswordRoleAuthenticationToken(Object principal, Object credentials, String role) {
        super(principal, credentials, Collections.singleton(new SimpleGrantedAuthority("ROLE_" + role)));
    }
}
