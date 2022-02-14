package com.example.userconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

/**
 * @author 张志伟
 * @version v1.0
 */
@RestController
public class MainController {

    @Value("${server.port}")
    String port;

    @GetMapping("/getHi")
    public String getHi(){
        return "Hi,我的port" + port;
    }

    @GetMapping("/getMap")
    public Map<String,String> getMap(){
        return Collections.singletonMap("id","100");
    }

    @GetMapping("/getObj")
    public Person getObj() {
        Person person = new Person(100,"xiao6");
        return person;
    }

    @GetMapping("/getObj2")
    public Person getObj2(String name) {
        Person person = new Person(100,name);
        return person;
    }


    @Autowired
    HealthStatusService healthStatusSrv;

    @GetMapping("/health")
    public String health(@RequestParam("status") Boolean status) {

        healthStatusSrv.setStatus(status);
        return healthStatusSrv.getStatus();
    }
}
