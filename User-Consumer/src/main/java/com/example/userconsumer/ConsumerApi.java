package com.example.userconsumer;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * 不结合eureka，就是自定义一个client名字。就用url属性指定 服务器列表。url=“http://ip:port/”
 * @author 张志伟
 * @version v1.0
 */
@FeignClient(name = "user-provider")
public interface ConsumerApi extends UserApi{

}
