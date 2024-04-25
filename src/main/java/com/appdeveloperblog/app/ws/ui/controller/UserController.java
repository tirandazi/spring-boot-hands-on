package com.appdeveloperblog.app.ws.ui.controller;

import com.appdeveloperblog.app.ws.ui.model.request.UserDetailsRequestModel;
import com.appdeveloperblog.app.ws.ui.model.response.UserRest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<UserRest> getUser(@PathVariable("userId") String userId) {
        UserRest userDetails = new UserRest();
        userDetails.setFirstName("Upendra");
        userDetails.setLastName("Singh");
        userDetails.setEmail("temp@mail.com");

        return new ResponseEntity<UserRest>(userDetails, HttpStatus.OK);
    }

    @PostMapping(consumes = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE
    }, produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE
    })
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {

        UserRest returnValue = new UserRest();
        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());
        returnValue.setEmail(userDetails.getEmail());

        return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
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
