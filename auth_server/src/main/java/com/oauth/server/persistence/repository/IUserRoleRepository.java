package com.oauth.server.persistence.repository;

import com.oauth.server.persistence.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRoleRepository extends JpaRepository<UserRole, Integer> {

    List<UserRole> findByUserId(Long userId);

}
