package com.example.repository.account;

import com.example.entity.UserFurama;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserFurama, Integer> {
    UserFurama findByUserName(String name);
}
