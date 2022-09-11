package com.lawenforcement.legalcommute.user.controller;

import com.lawenforcement.legalcommute.composite_vehicle_offence.offence.model.request.CreateOffenceCaseRequestModel;
import com.lawenforcement.legalcommute.composite_vehicle_offence.offence.model.response.ResultantHtmlContent;
import com.lawenforcement.legalcommute.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

@Controller
//@SessionScope //perhaps to separate request and session scope.
//@RequestMapping( name = "/api")
public class UserController {

    @Autowired
    private UserService userService;

    //this
//    @PostMapping(value="/login")
//    public ResponseEntity<UserLoginResponseModel> login() {
//
//        UserLoginResponseModel userLoginResponseModel = new UserLoginResponseModel();
//        //call localhost:4000/login to get the token
//        return  new ResponseEntity<UserLoginResponseModel>(userLoginResponseModel, HttpStatus.OK);
//    }

//    @PostMapping(value = "/create-case/validate-field/")
//    @ResponseBody
//    public ModelAndView validateField(HttpSession httpSession, Model model, @RequestParam(value = "idCardNumber") String idCard, @RequestParam(value = "licensePlateNumber") String licensePlateNumber){
//        ModelAndView modelAndView =  new ModelAndView("redirect:/create-case");
//        modelAndView.addObject("result", "DUPLICATE");
//        return  modelAndView;
//    }

    private void constructModelAndViewAttributes(HttpSession httpSession, ModelAndView modelAndView){
        if (httpSession.getAttribute("result") != null){
            modelAndView.addObject("result", httpSession.getAttribute("result"));
            httpSession.removeAttribute("result");
        }
    }

    @GetMapping(value="/create-case")
    @ModelAttribute("result")
    public ModelAndView createANewCase(HttpSession httpSession, @ModelAttribute CreateOffenceCaseRequestModel createOffenceCaseRequestModel, @ModelAttribute ResultantHtmlContent resultantHtmlContent){
        ModelAndView modelAndView =  new ModelAndView("/pages/create_case");
        constructModelAndViewAttributes(httpSession, modelAndView);
        return modelAndView;
    }

    @PostMapping(value = "/submit-offence-case")
    public String submitOffenceCase(HttpSession httpSession, @ModelAttribute CreateOffenceCaseRequestModel createOffenceCaseRequestModel, Model model){
        //validate token
        //validate data
        //persist into db
        httpSession.setAttribute("result","saved");
        return "redirect:/create-case";
    }

    @GetMapping(value="/fetch-execute")
    public ModelAndView fetchAndExecute(){
        ModelAndView modelAndView = new ModelAndView("/pages/fetch_execute");
        return modelAndView;
    }

    @GetMapping(value="/update-status")
    public ModelAndView updateStatus(){
        ModelAndView modelAndView = new ModelAndView("/pages/update_status");
        return modelAndView;
    }

    @GetMapping(value="/login")
    public ModelAndView ModelAndView(){
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }
    @GetMapping(value = "/homepage")
    public ModelAndView ModelAndView(@RequestParam(name="name", required=false, defaultValue="World") String name) {
        ModelAndView modelAndView = new ModelAndView("homepage");
//        modelAndView.addObject("name", "alibaba");
        return modelAndView;
    }

//    @Resource
//    private WebClient webClient;
//
//    @Bean
//    public WebClient getWebClient(WebClient.Builder webClientBuilder) {
//        return webClientBuilder
//                .baseUrl("https://reqres.in/api")
//                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                .build();
//    }m
    @GetMapping(value = "/list")
    public ResponseEntity userDetails() {

        List userDetails = userService.getUserDetails();
        return new ResponseEntity(userDetails, HttpStatus.OK);
    }
}
