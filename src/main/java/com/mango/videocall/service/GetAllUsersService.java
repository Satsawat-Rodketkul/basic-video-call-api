package com.mango.videocall.service;

import com.mango.videocall.models.entity.UserEntity;
import com.mango.videocall.models.request.UserRequestModel;
import com.mango.videocall.repository.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class GetAllUsersService {

    private final User user;

    public GetAllUsersService(User user) {
        this.user = user;
    }

    public List<UserRequestModel> findAll() {
        List<UserRequestModel> userListResponse = new ArrayList<>();
        UserRequestModel userResponse;

        try {
            // Get user from database
            List<UserEntity> allUser = user.findAll();

            if (!allUser.isEmpty()) {
                for (UserEntity userEntity : allUser) {
                    userResponse = UserRequestModel.builder()
                            .username(userEntity.getUsername())
                            .email(userEntity.getEmail())
                            .password(userEntity.getPassword())
                            .status(userEntity.getStatus())
                            .build();
                    userListResponse.add(userResponse);
                }
            } else {
                throw new RuntimeException("User not found");
            }
            log.info("Get users success");
            return userListResponse;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
