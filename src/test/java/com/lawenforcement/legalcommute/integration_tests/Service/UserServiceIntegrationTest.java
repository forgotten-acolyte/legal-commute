package com.lawenforcement.legalcommute.integration_tests.Service;


import com.lawenforcement.legalcommute.user.model.User;
import com.lawenforcement.legalcommute.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceIntegrationTest {
    @Autowired
    private UserService service;
    @Test
    public void signup() {
//        Optional<User> user = service.signUpForTesting("0904334482", "dummyEmail@gmail.com","dummyFirst dummyLast","@User1234");
        Optional<User> user = null;
        assertThat(user.get().getPassword(), not("dummypassword"));
        System.out.println("Encoded Password = " + user.get().getPassword());
    }
}