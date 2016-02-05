package com.jahra.repository;

import com.jahra.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Артём on 05.02.2016.
 */
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}
