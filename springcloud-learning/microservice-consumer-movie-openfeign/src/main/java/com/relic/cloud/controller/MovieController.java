package com.relic.cloud.controller;

import com.relic.cloud.client.UserClient;
import com.relic.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Relic
 * @date 2020-07-01 16:50
 */
@RestController
public class MovieController {

    @Resource
    private UserClient userClient;

    @GetMapping("/movie/{id}")
    public User getUser(@PathVariable Long id) {
        return userClient.getUser(id);
    }

    @GetMapping("/movie/selectAll")
    public List<User> selectAll() {
        return userClient.selectAll();
    }
}
