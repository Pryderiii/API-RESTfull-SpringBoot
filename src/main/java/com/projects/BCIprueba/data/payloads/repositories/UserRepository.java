package com.projects.BCIprueba.data.payloads.repositories;

import com.projects.BCIprueba.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Query(value = "SELECT CASEWHEN (COUNT(*) > 0,TRUE,FALSE) value FROM PUBLIC.user WHERE email = :email", nativeQuery = true)
    boolean existsByEmail(@Param("email") String email);
}
