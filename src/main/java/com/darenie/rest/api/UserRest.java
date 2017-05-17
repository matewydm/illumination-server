package com.darenie.rest.api;

import com.darenie.json.model.UserJson;
import com.darenie.rest.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserRest {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public UserJson getUserById(@PathVariable(name = "userId") Integer userId) {
        return userService.findByUsrId(userId);
    }
}

