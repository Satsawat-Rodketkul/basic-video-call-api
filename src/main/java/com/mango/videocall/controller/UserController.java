package com.mango.videocall.controller;

import com.mango.videocall.models.entity.UserEntity;
import com.mango.videocall.models.request.LoginRequestModel;
import com.mango.videocall.models.request.LogoutRequestModel;
import com.mango.videocall.models.request.UserRequestModel;
import com.mango.videocall.service.GetAllUsersService;
import com.mango.videocall.service.LoginService;
import com.mango.videocall.service.LogoutService;
import com.mango.videocall.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "*") //Not recommend for production
public class UserController {

    private final GetAllUsersService getAllUsersService;

    private final RegisterService registerService;

    private final LoginService loginService;

    private final LogoutService logoutService;

    @PostMapping("/register")
    public void register(@RequestBody UserRequestModel userRequestModel) {
        registerService.register(userRequestModel);
    }

    @PostMapping("/login")
    public UserEntity login(@RequestBody LoginRequestModel loginRequestModel) {
        return loginService.login(loginRequestModel);
    }

    @PostMapping("/logout")
    public void logout(@RequestBody String email) {
        logoutService.logout(email);
    }

    @PostMapping("/getAllUsers")
    public List<UserRequestModel> findAll() {
        return getAllUsersService.findAll();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handle(Exception ex) {
        ex.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }

}
