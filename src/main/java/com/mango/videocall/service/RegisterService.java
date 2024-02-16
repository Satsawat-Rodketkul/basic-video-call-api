package com.mango.videocall.service;

import com.mango.videocall.models.entity.UserEntity;
import com.mango.videocall.models.request.UserRequestModel;
import com.mango.videocall.repository.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RegisterService {

    private final User user;

    public RegisterService(User user) {
        this.user = user;
    }

    public void register(UserRequestModel userRequestModel) {
        try {
            UserEntity userEntity = new UserEntity();
            userEntity.setUsername(userRequestModel.getUsername());
            userEntity.setEmail(userRequestModel.getEmail());
            userEntity.setPassword(userRequestModel.getPassword());
            userEntity.setStatus("online");

            user.save(userEntity);
            log.info("Register success");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
