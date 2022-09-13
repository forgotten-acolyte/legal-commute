//package com.lawenforcement.legalcommute.integration_tests.Web_Client;
//
//
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.stereotype.Component;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.web.reactive.function.client.WebClient;
//
//@Component
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class WebClientTests {
//
//
//    private final WebClient webClient;
//
//    @Autowired
//    public WebClientTest(WebClient.Builder builder) {
//        webClient = builder
//                .baseUrl("http://localhost:8080")
//                .defaultHeaders(httpHeaders -> httpHeaders.setBasicAuth("admin", "password"))
//                .defaultHeaders(httpHeaders -> httpHeaders.setBearerAuth("<bearer token>"))
//                .build();
//    }
//
//    public WebClientTests(WebClient webClient) {
//        this.webClient = webClient;
//    }
//}
