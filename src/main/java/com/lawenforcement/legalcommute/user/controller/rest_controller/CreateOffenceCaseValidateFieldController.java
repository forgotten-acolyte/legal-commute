package com.lawenforcement.legalcommute.user.controller.rest_controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

//@Controller
@RestController
@RequestMapping(value = "/create-case")
public class CreateOffenceCaseValidateFieldController {

    private static String OK = "saved_successful";
    private static String INCORRECT = "incorrect";
    private static String DUPLICATE = "duplicate_data";

    @GetMapping(value = "/validate-field")
    public String validateField(HttpSession httpSession, Model model, @RequestParam(value = "idCardNumber") String idCard, @RequestParam(value = "licensePlateNumber") String licensePlateNumber){

        return  DUPLICATE;
    }
}
