package com.appdeveloperblog.app.ws.ui.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users") // http://localhost:8080/users
public class UserController {

    @GetMapping
    public String getUser() {
        return "Get User Called";
    }

    @PostMapping
    public String createUser() {
        return "Create User Called";
    }

    @PutMapping
    public String updateUser() {
        return "Update User Called";
    }

    @DeleteMapping
    public String deleteUser() {
        return "Delete User Called";
    }
}
