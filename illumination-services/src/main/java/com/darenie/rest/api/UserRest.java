package com.darenie.rest.api;


import com.darenie.json.model.UserJson;
import com.darenie.service.UserService;
import com.darenie.service.impl.LightLampMockBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;

@RestController
@RequestMapping("/user")
public class UserRest {

    @Autowired
    private UserService userService;
    @Autowired
    private LightLampMockBean lightLampMockBean;

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public UserJson getUserById(@PathVariable(name = "userId") Integer userId) {
        return userService.findByUsrId(userId);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void save(@RequestBody UserJson userJson) {
        userService.save(userJson);
    }

}