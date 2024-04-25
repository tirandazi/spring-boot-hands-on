package com.appdeveloperblog.app.ws.ui.controller;

import com.appdeveloperblog.app.ws.ui.model.response.UserRest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "limit", defaultValue = "30") int limit, @RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {
        String response = "Get Users called for page = " + page + " and number of records = " + limit + " and sort = " + sort;

        return response;
    }

    @GetMapping(path = "/{userId}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public UserRest getUser(@PathVariable("userId") String userId) {
        UserRest userDetails = new UserRest();
        userDetails.setFirstName("Upendra");
        userDetails.setLastName("Singh");
        userDetails.setEmail("temp@mail.com");

        return userDetails;
    }

    @PostMapping
    public String createUser() {
        String createResponse = "Create User Called";
        return createResponse;
    }

    @PutMapping
    public String updateUser() {
        String updateResponse = "Update User Called";
        return updateResponse;
    }

    @DeleteMapping
    public String deleteUser() {
        String deleteResponse = "Delete User Called";
        return deleteResponse;
    }
}
