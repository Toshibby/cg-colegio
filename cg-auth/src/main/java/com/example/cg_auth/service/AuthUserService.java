package com.example.cg_auth.service;

import com.example.cg_auth.dto.AuthUserDTO;
import com.example.cg_auth.dto.TokenDTO;
import com.example.cg_auth.entity.AuthUser;


public interface AuthUserService {
    public AuthUser save(AuthUserDTO authUserDto);


    public TokenDTO login(AuthUserDTO authUserDto);


    public TokenDTO validate(String token);
}
