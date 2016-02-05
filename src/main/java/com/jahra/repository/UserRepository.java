package com.jahra.repository;

import com.jahra.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

/**
 * Created by Артём on 29.01.2016.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update User u set u.isUserEnabled = :status where u.id = :userId")
    void changeUserStatus(@Param("userId") Long userId, @Param("status") boolean isEnabled);
}
