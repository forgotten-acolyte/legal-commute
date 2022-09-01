package com.lawenforcement.legalcommute.user.model.request;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserLoginRequestModel {
    private String userName;
    private String password;
}
