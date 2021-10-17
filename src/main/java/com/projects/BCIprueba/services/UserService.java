package com.projects.BCIprueba.services;

import com.projects.BCIprueba.data.payloads.request.UserRequest;
import com.projects.BCIprueba.data.payloads.response.UserResponse;
import org.springframework.stereotype.Component;

@Component
public interface UserService {
    UserResponse createUser(UserRequest userRequest);
    boolean existsMail(String email);
}
