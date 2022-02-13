package com.example.demo;


import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Ribbon负载均衡
 * @author 张志伟
 * @version v1.0
 */
@RestController
public class RibbonController {
    @Autowired
    RestTemplate restTemplate;
    @Qualifier("eurekaClient")
    @Autowired
    EurekaClient client2;

    @Autowired
    LoadBalancerClient lb;

    @GetMapping("/client6")
    public Object client6() {

        // ribbon 完成客户端的负载均衡，过滤掉down了的节点
        ServiceInstance instance = lb.choose("provider");

        String url ="http://" + instance.getHost() +":"+ instance.getPort() + "/getHi";


        String respStr = restTemplate.getForObject(url, String.class);

        System.out.println("respStr"  + respStr);

        return instance.getPort();
    }

    /**
     * 手动负载均衡
     */
    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/client7")
    public Object client7() {


        List<ServiceInstance> instances = discoveryClient.getInstances("provider");

        // 自定义轮训算法

        // 随机
        int nextInt = new Random().nextInt(instances.size());
        AtomicInteger atomicInteger = new AtomicInteger();

        // 轮训
        int i = atomicInteger.getAndIncrement();
        instances.get(i % instances.size());

        // 权重。。
        for (ServiceInstance serviceInstance : instances) {
            //	int quanzhong = 	serviceInstance.getMetadata(); // 权重  1-9

        }


        ServiceInstance instance = instances.get(nextInt);

        // ribbon 完成客户端的负载均衡，过滤掉down了的节点
        //	ServiceInstance instance = lb.choose("provider");

        String url ="http://" + instance.getHost() +":"+ instance.getPort() + "/getHi";

        String respStr = restTemplate.getForObject(url, String.class);

        return respStr;
    }

    @GetMapping("/client8")
    public Object client8() {



        // ribbon 完成客户端的负载均衡，过滤掉down了的节点
        ServiceInstance instance = lb.choose("provider");

        String url ="http://" + instance.getHost() +":"+ instance.getPort() + "/getHi";

        String respStr = restTemplate.getForObject(url, String.class);

        System.out.println(respStr);
        return respStr;
    }


    @GetMapping("/client9")
    public Object client9() {
        // 自动处理URL
        String url ="http://provider/getHi";

        String respStr = restTemplate.getForObject(url, String.class);

        System.out.println(respStr);
        return respStr;
    }

}
