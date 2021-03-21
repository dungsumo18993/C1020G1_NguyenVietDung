package com.example.service.account;

import com.example.entity.UserFurama;
import com.example.entity.UserRole;
import com.example.repository.account.UserRepository;
import com.example.repository.account.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserFurama userFurama = this.userRepository.findByUserName(username);

        if (userFurama == null) {
            System.out.println("UserFurama not found! " + username);
            throw new UsernameNotFoundException("UserFurama " + username + " was not found in the database");
        }
        System.out.println("Found UserFurama: " + userFurama);

        // [ROLE_USER, ROLE_MANAGER,..]
        List<UserRole> userRoles = this.userRoleRepository.findByUserFurama(userFurama);

        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if (userRoles != null) {
            for (UserRole role : userRoles) {
                // ROLE_USER, ROLE_MANAGER,..
                GrantedAuthority authority = new SimpleGrantedAuthority(role.getRole().getRoleName());
                grantList.add(authority);
            }
        }

        UserDetails userDetails = (UserDetails) new org.springframework.security.core.userdetails.User(userFurama.getUserName(), //
                userFurama.getUserPassword(), grantList);

        return userDetails;
    }
}
