//package com.lawenforcement.legalcommute.integration_tests.Web;
//
//
//import com.lawenforcement.legalcommute.Utils.Security.JwtProvider;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//import java.util.Optional;
//
//import static org.springframework.http.MediaType.APPLICATION_JSON;
//
///**
// * Helper class for creating HTTP Headers before invoking an API with TestRestClient.
// */
//@Component
//public class JwtRequestHelper {
//
////    @Autowired
////    private JwtProvider jwtProvider;
//
//    /**
//     * Generate the appropriate headers for JWT Authentication.
//     *
//     * @param roleName role identifier
//     * @return Http Headers for Content-Type and Authorization
//     */
////    public  HttpHeaders withRole(String roleName){
////        HttpHeaders headers = new HttpHeaders();
////        SecurityRole r = new SecurityRole();
////        r.setRoleName(roleName);
////        Optional<SecurityUser> securityUser = null;
////        String token =  jwtProvider.createToken(securityUser, Arrays.asList(r));
////        headers.setContentType(APPLICATION_JSON);
////        headers.add("Authorization", "Bearer " + token);
////        return headers;
////    }
//}
