package com.example.cg_auth.controller;

import com.example.cg_auth.dto.AuthUserDTO;
import com.example.cg_auth.dto.TokenDTO;
import com.example.cg_auth.entity.AuthUser;
import com.example.cg_auth.service.AuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthUserController {
    @Autowired
    AuthUserService authUserService;

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login(@RequestBody AuthUserDTO authUserDTO) {
        TokenDTO tokenDTO = authUserService.login(authUserDTO);
        if (tokenDTO == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(tokenDTO);
    }

    @PostMapping("/validate")
    public ResponseEntity<TokenDTO> validate(@RequestParam String token) {
        TokenDTO tokenDTO = authUserService.validate(token);
        if (tokenDTO == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(tokenDTO);
    }

    @PostMapping("/create")
    public ResponseEntity<AuthUser> create(@RequestBody AuthUserDTO authUserDTO) {
        AuthUser authUser = authUserService.save(authUserDTO);
        if (authUser == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(authUser);
    }
}
