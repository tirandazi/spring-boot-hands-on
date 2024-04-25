package com.appdeveloperblog.app.ws.ui.controller;

import com.appdeveloperblog.app.ws.ui.model.request.UpdateUserDetailsModel;
import com.appdeveloperblog.app.ws.ui.model.request.UserDetailsRequestModel;
import com.appdeveloperblog.app.ws.ui.model.response.UserRest;
import com.appdeveloperblog.app.ws.userservice.UserService;
import com.appdeveloperblog.app.ws.userservice.impl.UserServiceImpl;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    Map<String, UserRest> users;

    @Autowired
    UserService userService;

    @GetMapping
    public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "limit", defaultValue = "30") int limit,
            @RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {
        String response = "Get Users called for page = " + page + " and number of records = " + limit + " and sort = "
                + sort;

        return response;
    }

    @GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<UserRest> getUser(@PathVariable("userId") String userId) {
        if (users.containsKey(userId))
            return new ResponseEntity<UserRest>(users.get(userId), HttpStatus.OK);
        else
            return new ResponseEntity<UserRest>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(consumes = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE
    }, produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE
    })
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {

        UserRest returnValue = userService.createUser(userDetails);
        return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
    }

    @PutMapping(path = "/{userId}", consumes = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE
    }, produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE
    })
    public UserRest updateUser(@PathVariable("userId") String userId,
            @Valid @RequestBody UpdateUserDetailsModel updateDetails) {
        UserRest userDetails = users.get(userId);
        userDetails.setFirstName(updateDetails.getFirstName());
        userDetails.setLastName(updateDetails.getLastName());

        users.put(userId, userDetails);

        return userDetails;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") String id) {
        users.remove(id);
        return ResponseEntity.noContent().build();
    }
}
