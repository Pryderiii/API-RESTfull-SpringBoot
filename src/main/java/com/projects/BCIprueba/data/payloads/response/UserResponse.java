package com.projects.BCIprueba.data.payloads.response;

import com.projects.BCIprueba.data.models.User;

public class UserResponse {

    private User user;
    private String message;

    public UserResponse(String message) {
        this.message = message;
        this.user = null;
    }
    public UserResponse(User user,String message) {
        this.user = user;
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
