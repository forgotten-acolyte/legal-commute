package com.lawenforcement.legalcommute.user.model.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserLoginResponseModel {
    private String token;
    private String username;

}
