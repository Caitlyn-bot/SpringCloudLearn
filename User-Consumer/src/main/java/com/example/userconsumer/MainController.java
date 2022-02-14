package com.example.userconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 张志伟
 * @version v1.0
 */
@RestController
public class MainController {
    @Autowired
    ConsumerApi api;

    @GetMapping("/alive")
    public String alive(){
        System.out.println(api.getById(5));
        return api.alive();
    }
}
