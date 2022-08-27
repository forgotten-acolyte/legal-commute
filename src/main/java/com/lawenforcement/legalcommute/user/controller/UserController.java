package com.lawenforcement.legalcommute.user.controller;

import com.lawenforcement.legalcommute.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping( name = "/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/list")
    public ResponseEntity userDetails() {

        List userDetails = userService.getUserDetails();
        return new ResponseEntity(userDetails, HttpStatus.OK);
    }
}
