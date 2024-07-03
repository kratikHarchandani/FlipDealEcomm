package com.flipdeal_ecommerce.flipdeal_ecomm.controllers;

import com.flipdeal_ecommerce.flipdeal_ecomm.dto.JwtResponse;
import com.flipdeal_ecommerce.flipdeal_ecomm.dto.LoginRequestDto;
import com.flipdeal_ecommerce.flipdeal_ecomm.dto.SignUpRequestDto;
import com.flipdeal_ecommerce.flipdeal_ecomm.entities.User;
import com.flipdeal_ecommerce.flipdeal_ecomm.security.JwtHelper;

import com.flipdeal_ecommerce.flipdeal_ecomm.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/Api/v1/auth")
public class UserController {
    private CustomUserDetailsService userDetailsService;


    private AuthenticationManager authenticationManager;
    private JwtHelper jwtHelper;

    @Autowired
    UserController(CustomUserDetailsService userService,
                   AuthenticationManager authenticationManager,
                   JwtHelper jwtHelper){
        this.userDetailsService=userService;
        this.authenticationManager=authenticationManager;
        this.jwtHelper=jwtHelper;
    }


    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequestDto loginRequestDto){
        this.doAuthenticate(loginRequestDto.getEmail(), loginRequestDto.getPassword());


        UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequestDto.getEmail());
        String token =jwtHelper.generateToken(userDetails);

        JwtResponse response = JwtResponse.builder()
                .token(token)
                .userName(userDetails.getUsername()).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    private void doAuthenticate(String email, String password) {

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
        try {
            authenticationManager.authenticate(authentication);


        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }

    }
    @PostMapping("/signup")
    public ResponseEntity<String> signupUser(@RequestBody SignUpRequestDto signUpRequestDto){
        String  user= userDetailsService.signup(signUpRequestDto.getName(), signUpRequestDto.getEmail(),
                signUpRequestDto.getPassword(), signUpRequestDto.getAbout());
        return new ResponseEntity<>(user,HttpStatus.OK);

    }

    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "Credentials Invalid !!";
    }
}
