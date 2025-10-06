package com.example.cg_auth.service.impl;

import com.example.cg_auth.dto.AuthUserDTO;
import com.example.cg_auth.dto.TokenDTO;
import com.example.cg_auth.entity.AuthUser;
import com.example.cg_auth.repository.AuthUserRepository;
import com.example.cg_auth.security.JwtProvider;
import com.example.cg_auth.service.AuthUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;




import java.util.Optional;


@Service
public class AuthUserServiceImpl implements AuthUserService {
    @Autowired
    AuthUserRepository authUserRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    JwtProvider jwtProvider;


    @Override
    public AuthUser save(AuthUserDTO authUserDTO) {
        Optional<AuthUser> user = authUserRepository.findByUsername(authUserDTO.getUserName());
        if (user.isPresent())
            return null;
        String password = passwordEncoder.encode(authUserDTO.getPassword());
        AuthUser authUser = AuthUser.builder()
                .userName(authUserDTO.getUserName())
                .password(password)
                .build();




        return authUserRepository.save(authUser);
    }




    @Override
    public TokenDTO login(AuthUserDTO authUserDTO) {
        Optional<AuthUser> user = authUserRepository.findByUsername(authUserDTO.getUserName());
        if (!user.isPresent())
            return null;
        if (passwordEncoder.matches(authUserDTO.getPassword(), user.get().getPassword()))
            return new TokenDTO(jwtProvider.createToken(user.get()));
        return null;
    }




    @Override
    public TokenDTO validate(String token) {
        if (!jwtProvider.validate(token))
            return null;
        String username = jwtProvider.getUserNameFromToken(token);
        if (!authUserRepository.findByUsername(username).isPresent())
            return null;
        return new TokenDTO(token);
    }
}
