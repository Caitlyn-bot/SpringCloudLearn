package com.example.userconsumer;

import feign.FeignException;
import feign.FeignException.InternalServerError;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author 张志伟
 * @version v1.0
 */
@Component
public class UserProviderBackFactory implements FallbackFactory<ConsumerApi> {

    @Override
    public ConsumerApi create(Throwable cause) {
        // TODO Auto-generated method stub
        return new ConsumerApi() {

            @Override
            public Person postPerson(Person person) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public String getById(Integer id) {
                // TODO Auto-generated method stub
                return null;
            }



            @Override
            public String alive() {
                // TODO Auto-generated method stub
                System.out.println(cause);
                if(cause instanceof InternalServerError) {

                    return "远程服务器 500" + cause.getLocalizedMessage();
                }else {

                    return "呵呵";
                }
            }

            @Override
            public Map<Integer, String> postMap(Map<String, Object> map) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public Map<Integer, String> getMap3(Map<String, Object> map) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public Map<Integer, String> getMap2(Integer id, String name) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public Map<Integer, String> getMap(Integer id) {
                // TODO Auto-generated method stub
                return null;
            }
        };
    }

}

