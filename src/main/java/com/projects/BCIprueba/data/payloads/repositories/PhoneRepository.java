package com.projects.BCIprueba.data.payloads.repositories;

import com.projects.BCIprueba.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<User, String> {

}
