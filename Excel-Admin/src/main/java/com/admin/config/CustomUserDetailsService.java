package com.admin.config;

import com.admin.entity.AdminUser;
import com.admin.repository.AdminUserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final AdminUserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        AdminUser user = repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())

                // ✅ IMPORTANT → ROLE_ADMIN already
                .authorities(user.getRole())

                .disabled(!user.isEnabled())
                .build();
    }
}