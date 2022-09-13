package com.lawenforcement.legalcommute.user.controller;

import com.lawenforcement.legalcommute.composite_vehicle_offence.offence.model.entity.Offence;
import com.lawenforcement.legalcommute.composite_vehicle_offence.offence.model.request.CreateOffenceCaseRequestModel;
import com.lawenforcement.legalcommute.composite_vehicle_offence.offence.model.response.OffenceCaseResponseModel;
import com.lawenforcement.legalcommute.composite_vehicle_offence.offence.model.response.ResultantHtmlContent;
import com.lawenforcement.legalcommute.composite_vehicle_offence.offence.repository.OffenceRepository;
import com.lawenforcement.legalcommute.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.PostRemove;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
//@SessionScope // session scope.
//@RequestMapping( name = "/api")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private OffenceRepository offenceRepository;

    //this
//    @PostMapping(value="/login")
//    public ResponseEntity<UserLoginResponseModel> login() {
//
//        UserLoginResponseModel userLoginResponseModel = new UserLoginResponseModel();
//        //call localhost:4000/login to get the token
//        return  new ResponseEntity<UserLoginResponseModel>(userLoginResponseModel, HttpStatus.OK);
//

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
    @GetMapping(value="/list-cases")
    @ModelAttribute("listCases")
    public ModelAndView showList(){
//        List<OffenceCaseResponseModel> list = new ArrayList<>();
//        list.add(new OffenceCaseResponseModel("Córdoba", "Stolen", "2022-06-02"));
//        list.add(new OffenceCaseResponseModel("Adam", "Stolen", "2022-03-02"));
//        list.add(new OffenceCaseResponseModel("John", "Stolen", "2022-07-02"));
//        list.add(new OffenceCaseResponseModel("Downy", "Stolen", "2022-05-02"));
        ModelAndView modelAndView = new ModelAndView("/pages/list_cases");
//        modelAndView.addObject("listCases", list);
        return modelAndView;
    }

    @PostMapping(value="/welcome")
    public ModelAndView welcomePage(){
        ModelAndView modelAndView = new ModelAndView("/pages/welcome_page");
        return modelAndView;
    }

    @GetMapping(value="/logout")
    public ModelAndView logout(){
        ModelAndView modelAndView = new ModelAndView("homepage");
        return modelAndView;
    }
    @PostMapping(value = "/submit-offence-case")
    public ModelAndView submitOffenceCase(HttpSession httpSession, @ModelAttribute CreateOffenceCaseRequestModel createOffenceCaseRequestModel){
        //validate token
        //validate data
//        //persist into db
//        if (createOffenceCaseRequestModel.getGlobalResponse().equalsIgnoreCase("none"))
//            return new ModelAndView("redirect:/create-case");

        httpSession.setAttribute("result","saved");
        List<OffenceCaseResponseModel> list = new ArrayList<>();
        list.add(new OffenceCaseResponseModel(1,"Stolen", "Nguyen Van A", "2022-06-02"));
        list.add(new OffenceCaseResponseModel(2,"Stolen", "Tran Thi B", "2022-03-02"));
        list.add(new OffenceCaseResponseModel(3,"Stolen", "Nguyen Van Hau", "2022-07-02"));
        list.add(new OffenceCaseResponseModel(4,"Wanted", "Tran Kim Kim", "2022-05-02"));
        ModelAndView modelAndView = new ModelAndView("/pages/list_cases");
        modelAndView.addObject("listCases", list);
        return modelAndView;
//        return "/list-cases";
    }

    @GetMapping(value="/fetch-execute")
    public ModelAndView fetchAndExecute(){
        ModelAndView modelAndView = new ModelAndView("/pages/fetch_execute");
        return modelAndView;
    }

    @PostMapping(value="/update-status")
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
