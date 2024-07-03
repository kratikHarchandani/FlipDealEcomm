package com.flipdeal_ecommerce.flipdeal_ecomm.services;

import com.flipdeal_ecommerce.flipdeal_ecomm.entities.User;
import com.flipdeal_ecommerce.flipdeal_ecomm.repositories.UserDetailsRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserDetailsRepository userDetailsRepository;
    private PasswordEncoder passwordEncoder;

    public CustomUserDetailsService(UserDetailsRepository userDetailsRepository
                                    ,PasswordEncoder passwordEncoder){
        this.userDetailsRepository=userDetailsRepository;
        this.passwordEncoder=passwordEncoder;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional=userDetailsRepository.findByEmail(username);
        if(userOptional.isEmpty()){
            throw new RuntimeException("Invalid username");
        }
        return userOptional.get();
    }

    public String signup(String name,String email,String password,String about){
        UserDetails userDetails= org.springframework.security.core.userdetails.User.builder().
                username(name)
                .password(passwordEncoder.encode(password)).roles("ADMIN").
                build();
         new InMemoryUserDetailsManager(userDetails);
         return "Signup completed";

    }
}
