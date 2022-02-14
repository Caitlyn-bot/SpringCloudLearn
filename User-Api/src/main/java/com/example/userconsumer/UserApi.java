package com.example.userconsumer;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 张志伟
 * @version v1.0
 */
public interface UserApi {
    @GetMapping("/alive")
    public String alive();

    @GetMapping("/getById")
    public String getById(Integer id);
}
