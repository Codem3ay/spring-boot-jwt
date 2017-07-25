package com.codem3ay.springbootjwt.repositories;

import com.codem3ay.springbootjwt.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by HABCHI Hamza on 11/07/2017 - 19:35.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
