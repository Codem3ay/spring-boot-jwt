package com.codem3ay.springbootjwt.apis.authentication;

import com.codem3ay.springbootjwt.entities.User;
import com.codem3ay.springbootjwt.pojos.UserDTO;
import com.codem3ay.springbootjwt.services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by HABCHI Hamza on 11/07/2017 - 19:17.
 */
@RestController
@RequestMapping("/authentication")
public class AuthenticationController {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/login")
    public String login(@RequestBody UserDTO userDTO, Device device){
        final Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(userDTO.getUsername(), userDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        final UserDetails userDetails = userDetailsService.loadUserByUsername(userDTO.getUsername());
        final String token = jwtService.generateToken(userDetails, device);
        return token;
    }

    @PostMapping("/register")
    public String register(){

        return null;
    }

    @GetMapping("/refresh")
    public String refresh(HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader(tokenHeader);
        String username = jwtService.getUsernameFromToken(token);
        User user = (User) userDetailsService.loadUserByUsername(username);

        String refreshedToken = jwtService.refreshToken(token);
        return refreshedToken;


    }
}
