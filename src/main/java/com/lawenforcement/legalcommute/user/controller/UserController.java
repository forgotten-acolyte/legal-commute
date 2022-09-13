package com.lawenforcement.legalcommute.user.controller;

import com.lawenforcement.legalcommute.composite_vehicle_offence.offence.model.request.CreateOffenceCaseRequestModel;
import com.lawenforcement.legalcommute.composite_vehicle_offence.offence.model.response.OffenceCaseResponseModel;
import com.lawenforcement.legalcommute.composite_vehicle_offence.offence.model.response.ResultantHtmlContent;
import com.lawenforcement.legalcommute.composite_vehicle_offence.offence.repository.OffenceRepository;
import com.lawenforcement.legalcommute.outbound_ws.ALPR_service.AlPRProxy;
import com.lawenforcement.legalcommute.outbound_ws.ALPR_service.model.response.ALPRResponseModel;
import com.lawenforcement.legalcommute.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

@Controller
//@SessionScope // session scope.
//@RequestMapping( name = "/api")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private AlPRProxy alPRProxy;

    @Autowired
    private OffenceRepository offenceRepository;

    private final RestTemplate restTemplate;

    public UserController(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

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
        list.add(new OffenceCaseResponseModel(1,"Stolen", "Le Thi Tao", "2022-06-02"));
        list.add(new OffenceCaseResponseModel(2,"Stolen", "Tran Thi B", "2022-03-02"));
        list.add(new OffenceCaseResponseModel(3,"Stolen", "Nguyen Van Hau", "2022-07-02"));
        list.add(new OffenceCaseResponseModel(4,"Wanted", "Tran Kim Kim", "2022-05-02"));
        list.add(new OffenceCaseResponseModel(5,"Stolen", "Nguyen Van A", "2022-06-02"));
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

    private MultipartFile conversion() throws IOException {
        return new MockMultipartFile("upload", new FileInputStream(new File("/Users/trung/Documents/Advanced SWE/backend/legal-commute/src/main/resources/static/imgs/vehicle.jpeg")));
    }

//    @PostMapping(value="/update-status")
//    public ModelAndView updateStatus() throws IOException {
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);
//        httpHeaders.setAccept(Collections.singletonList(MediaType.ALL));
//        httpHeaders.add("Authorization", "Token b53d7b9e2bfb69401a7973b5341a4d8743d1df48");
//
//        List<MultipartFile> multipartFiles = new ArrayList<>();
//        multipartFiles.add(conversion());
////        MultiValueMap<String, Object> parts =
////                new LinkedMultiValueMap<String, Object>();
////        parts.add("file", new ByteArrayResource(file.getBytes()));
////        parts.add("filename", file.getOriginalFilename());
//
//        alPRProxy.retrieveRecognizedLicensePlateNumber(multipartFiles);
//        ModelAndView modelAndView = new ModelAndView("/pages/update_status");
//        return modelAndView;
//    }

    @GetMapping(value="/update-status")
    public ModelAndView updateStatus() throws IOException {

        File file = new File("/Users/trung/Documents/Advanced SWE/backend/legal-commute/src/main/resources/static/imgs/vehicle.jpeg");

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);
        httpHeaders.add("Authorization", "Token " + "b53d7b9e2bfb69401a7973b5341a4d8743d1df48");
        MultiValueMap<String, Object> form = new LinkedMultiValueMap<>();
//        form.add("upload", conversion().getResource());
        form.add("upload", new FileSystemResource(file));

//        form.add("Authorization", "Token b53d7b9e2bfb69401a7973b5341a4d8743d1df48");
//        form.add("sendTo", "test");

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(form, httpHeaders);

        String serverUrl = "https://api.platerecognizer.com/v1/plate-reader/";

        ResponseEntity<ALPRResponseModel> response  = restTemplate.postForEntity(serverUrl, requestEntity, ALPRResponseModel.class);

        logger.info(response.getBody().toString());

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
        return modelAndView;
    }

//    @GetMapping(value = "/list")
//    public ResponseEntity userDetails() {
//
//        List userDetails = userService.getUserDetails();
//        return new ResponseEntity(userDetails, HttpStatus.OK);
//    }
}
