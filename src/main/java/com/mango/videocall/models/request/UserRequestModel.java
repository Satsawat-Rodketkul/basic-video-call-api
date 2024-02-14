package com.mango.videocall.models.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserRequestModel {
    private String username;
    private String email;
    private String password;
    private String status;
}
