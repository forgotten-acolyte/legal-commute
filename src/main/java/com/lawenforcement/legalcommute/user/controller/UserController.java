package com.lawenforcement.legalcommute.user.controller;

import com.lawenforcement.legalcommute.composite_vehicle_offence.offence.model.request.CreateOffenceCaseRequestModel;
import com.lawenforcement.legalcommute.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
//@SessionScope //perhaps to separate request and session scope.
//@RequestMapping( name = "/api")
public class UserController {

    @Autowired
    private UserService userService;

//    @PostMapping(value="/login")
//    public ResponseEntity<UserLoginResponseModel> login() {
//
//        UserLoginResponseModel userLoginResponseModel = new UserLoginResponseModel();
//        //call localhost:4000/login to get the token
//        return  new ResponseEntity<UserLoginResponseModel>(userLoginResponseModel, HttpStatus.OK);
//    }

    @GetMapping(value="/create-case")
    public ModelAndView createANewCase(@ModelAttribute CreateOffenceCaseRequestModel createOffenceCaseRequestModel){
        ModelAndView modelAndView = new ModelAndView("/pages/create_case");
        return modelAndView;
    }

    @PostMapping(value = "/submit-offence-case")
    public ResponseEntity<String> submitOffenceCase(@ModelAttribute CreateOffenceCaseRequestModel createOffenceCaseRequestModel){
        //save
        return ResponseEntity.ok().body(String.valueOf(createOffenceCaseRequestModel.getOffenceType()));
    }

    @GetMapping(value="/fetch-execute")
    public ModelAndView fetchAndExecute(){
        ModelAndView modelAndView = new ModelAndView("/pages/fetch_execute");
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
