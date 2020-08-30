package com.relic.cloud.controller;

import com.relic.entity.User;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Relic
 * @desc
 * @date 2020/06/03 18:06:18
 */
@RestController
public class MovieController {

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/movie/{id}")
    public User findById(@PathVariable("id") Long id) {
        return restTemplate.getForObject("http://microservice-provider-user1/user/{id}", User.class, id);
    }

    @GetMapping("/movie/selectAll")
    public List<User> selectAll() {
        return restTemplate.exchange("http://microservice-provider-user1/user/selectAll",
                HttpMethod.GET,null,new ParameterizedTypeReference<List<User>>(){}).getBody();
    }
}
