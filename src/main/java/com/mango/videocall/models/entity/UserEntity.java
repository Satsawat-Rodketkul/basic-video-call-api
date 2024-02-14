package com.mango.videocall.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Setter
@Getter
@Entity
@Table(name = "user_video_call")
public class UserEntity {

    @Id
    @SequenceGenerator(name = "user_video_call_user_id_seq", sequenceName = "user_video_call_user_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "user_video_call_user_id_seq")
    @Column(name = "user_id")
    private int userId;

    private String username;

    private String email;

    private String password;

    private String status;

    @Column(name = "created_date")
    private Timestamp createdDate;

    @PrePersist
    protected void createDate() {
        createdDate = Timestamp.valueOf(LocalDateTime.now());
    }
}
