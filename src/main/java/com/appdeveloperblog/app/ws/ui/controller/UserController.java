package com.appdeveloperblog.app.ws.ui.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users") // http://localhost:8080/users
public class UserController {

    @GetMapping
    public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "limit", defaultValue = "30") int limit,
                            @RequestParam(value="sort", defaultValue = "desc", required = false) String sort
    ) {
        return "Get Users called for page = " + page + " and number of records = " + limit + " and sort = " + sort;
    }

    @GetMapping(path = "/{userId}")
    public String getUser(@PathVariable("userId") String userId) {
        return "Get User Called for userId = " + userId;
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
