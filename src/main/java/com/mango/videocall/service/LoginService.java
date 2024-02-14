package com.mango.videocall.service;

import com.mango.videocall.models.entity.UserEntity;
import com.mango.videocall.models.request.UserRequestModel;
import com.mango.videocall.repository.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@Slf4j
@Service
public class LoginService {

    private final User user;

    public LoginService(User user) {
        this.user = user;
    }

    public UserEntity login(UserRequestModel userRequestModel) {

        try {
            // Get user from database
            List<UserEntity> allUser = user.findAll();

            int userIndex = IntStream.range(0, allUser.size())
                    .filter(i -> allUser.get(i).getEmail().equals(userRequestModel.getEmail()))
                    .findAny()
                    .orElseThrow(() -> new RuntimeException("User not found"));

            UserEntity connectedUser = allUser.get(userIndex);
            log.info("Found user data: {}", connectedUser);
            if (!connectedUser.getPassword().equals(userRequestModel.getPassword())) {
                throw new RuntimeException("Password incorrect");
            }
            connectedUser.setStatus("online");
            return connectedUser;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
