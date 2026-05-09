package com.admin.repository;

import com.admin.entity.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminUserRepository extends JpaRepository<AdminUser, Long> {

    // 🔍 Find admin by username (login ke liye)
    Optional<AdminUser> findByUsername(String username);

    // 🔍 Check if username exists (registration / validation)
    boolean existsByUsername(String username);
}