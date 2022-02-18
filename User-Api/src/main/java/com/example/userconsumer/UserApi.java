package com.example.userconsumer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author 张志伟
 * @version v1.0
 */
public interface UserApi {
    @GetMapping("/alive")
    public String alive();

    @GetMapping("/getById")
    public String getById(Integer id);

    @PostMapping("/postPserson")
    public Person postPerson(@RequestBody Person person);
}
