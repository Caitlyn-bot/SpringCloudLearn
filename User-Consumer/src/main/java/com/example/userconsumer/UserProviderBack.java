package com.example.userconsumer;

import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author 张志伟
 * @version v1.0
 */
@Component
public class UserProviderBack implements ConsumerApi{

    final String message = "降级了";

    @Override
    public Map<Integer, String> getMap(Integer id) {
        return null;
    }

    @Override
    public Map<Integer, String> getMap2(Integer id, String name) {
        return null;
    }

    @Override
    public Map<Integer, String> getMap3(Map<String, Object> map) {
        return null;
    }

    @Override
    public Map<Integer, String> postMap(Map<String, Object> map) {
        return null;
    }

    @Override
    public String alive() {
        return message;
    }

    @Override
    public String getById(Integer id) {
        return message;
    }

    @Override
    public Person postPerson(Person person) {
        return null;
    }
}
