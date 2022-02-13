package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @Autowired
    HealthStatusService healthStatusSrv;

    @GetMapping("/health")
    public String health(@RequestParam("status") Boolean status) {

        healthStatusSrv.setStatus(status);
        return healthStatusSrv.getStatus();
    }
}
