package com.example.repository.account;

import com.example.entity.UserFurama;
import com.example.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
    List<UserRole> findByUserFurama(UserFurama userFurama);
}
