package com.example.entity;

import javax.persistence.*;

@Entity
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_role_id")
    private Integer UserRoleId;

    //------------------- Tạo mối quan hệ --------------------
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserFurama userFurama;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    private Role role;
    //--------------------------------------------------------


    public UserRole() {
    }

    public Integer getUserRoleId() {
        return UserRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        UserRoleId = userRoleId;
    }

    public UserFurama getUserFurama() {
        return userFurama;
    }

    public void setUserFurama(UserFurama userFurama) {
        this.userFurama = userFurama;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
