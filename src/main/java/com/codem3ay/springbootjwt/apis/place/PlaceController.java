package com.codem3ay.springbootjwt.apis.place;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by HABCHI Hamza on 11/07/2017 - 19:18.
 */
@RestController
@RequestMapping("place")
public class PlaceController {

    @GetMapping("/public")
    public String getPublicPlace(){
        return "Welcome to the public place";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER')")
    public String getUserPlace(){
        return "Welcome to the user place";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String getAdminPlace(){
        return "Welcome to the admin place";
    }
}
