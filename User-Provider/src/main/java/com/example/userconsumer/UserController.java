package com.example.userconsumer;

import org.springframework.web.bind.annotation.RestController;

/**
 * @author 张志伟
 * @version v1.0
 */
@RestController
public class UserController implements UserApi{


    @Override
    public String alive() {
        return "ok";
    }

    @Override
    public String getById(Integer id) {
        return id+"5";
    }
}
