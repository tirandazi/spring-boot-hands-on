package com.appdeveloperblog.app.ws.userservice.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.appdeveloperblog.app.ws.ui.model.request.UserDetailsRequestModel;
import com.appdeveloperblog.app.ws.ui.model.response.UserRest;
import com.appdeveloperblog.app.ws.userservice.UserService;

@Service
public class UserServiceImpl implements UserService {

    Map<String, UserRest> users;

    @Override
    public UserRest createUser(UserDetailsRequestModel userDetails) {
        UserRest returnValue = new UserRest();
        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());
        returnValue.setEmail(userDetails.getEmail());

        String userId = UUID.randomUUID().toString();
        returnValue.setUserId(userId);

        if (users == null)
            users = new HashMap<>();
        users.put(userId, returnValue);

        return returnValue;
    }

}
