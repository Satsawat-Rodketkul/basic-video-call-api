package com.mango.videocall.models.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LoginRequestModel {
    private String email;
    private String password;
}
