package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 张志伟
 * @version v1.0
 */
@RestController
public class MainController {



    @GetMapping("/getHi")
    public String getHi(){
        return "Hi";
    }
}
