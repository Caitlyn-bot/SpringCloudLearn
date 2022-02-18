package com.example.userconsumer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * 不结合eureka，就是自定义一个client名字。就用url属性指定 服务器列表。url=“http://ip:port/”
 * @author 张志伟
 * @version v1.0
 */
@FeignClient(name = "user-provider",fallbackFactory = UserProviderBackFactory.class)
public interface ConsumerApi extends UserApi{

    @Override
    @GetMapping("/active")
    String alive();
    @GetMapping("/getMap")
    Map<Integer, String> getMap(@RequestParam("id") Integer id);
    @GetMapping("/getMap2")
    Map<Integer, String> getMap2(@RequestParam("id") Integer id,@RequestParam("name") String name);

    @GetMapping("/getMap3")
    Map<Integer, String> getMap3(@RequestParam Map<String, Object> map);

    @PostMapping("/postMap")
    Map<Integer, String> postMap(Map<String, Object> map);
}
