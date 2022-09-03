package com.lawenforcement.legalcommute.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/modal")
public class ModalController {

    @GetMapping("/saved_successful")
    public String modal1() {
        return "/modal_popup/saved_successful";
    }

    @GetMapping("/duplicate_data")
    public String modal2(Model model) {
//        model.addAttribute();
        return "/modal_popup/duplicate_data";
    }
}
