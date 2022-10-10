package com.analyticssakha.bloggingwebapp.repositories;

import com.analyticssakha.bloggingwebapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
