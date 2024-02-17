package com.mango.videocall.service;

import com.mango.videocall.models.request.LogoutRequestModel;
import com.mango.videocall.repository.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LogoutService {

    private final User user;

    public LogoutService(User user) {
        this.user = user;
    }

    public void logout(LogoutRequestModel email) {
        try {
            // Update user status to offline
            user.updateStatus(email.getEmail());
            log.info("User logout success");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
