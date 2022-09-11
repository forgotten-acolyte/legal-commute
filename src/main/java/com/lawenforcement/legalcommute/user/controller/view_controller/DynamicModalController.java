package com.lawenforcement.legalcommute.user.controller.view_controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/create-case")
public class DynamicModalController {

    private static String BASE_MODAL_DIR = "/modal_popup/create_case/";

    @GetMapping(value = "/dynamic-modal")
    public String dynamicModal(HttpSession httpSession, Model model, @RequestParam(value = "htmlName") String htmlName){
        String resultantHtmlContent = BASE_MODAL_DIR + htmlName;
        return resultantHtmlContent;
    }

}
