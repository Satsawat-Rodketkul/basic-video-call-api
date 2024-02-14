package com.mango.videocall.repository;

import com.mango.videocall.models.entity.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface User extends JpaRepository<UserEntity, Long> {

    @Modifying
    @Transactional
    @Query(value = """
            UPDATE user_video_call SET status = 'offline' WHERE email = :email
            """, nativeQuery = true)
    void updateStatus(@Param("email") String email);
}
