package com.auth.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.auth.jwt.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	JwtUtil jwtUtil;
	
	public ResponseEntity<Map<String, String>> getToken(@RequestParam String username){
		String token = jwtUtil.generateToken(username);
        return ResponseEntity.ok(Map.of("token", token));
	}
}
