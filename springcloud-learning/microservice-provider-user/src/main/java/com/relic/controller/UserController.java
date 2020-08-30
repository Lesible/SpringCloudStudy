package com.relic.controller;

import com.relic.dao.UserMapper;
import com.relic.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Relic
 * @desc
 * @date 2020/06/03 18:06:18
 */
@RestController
public class UserController {

    private final UserMapper userMapper;

    public UserController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Long id) {
        return userMapper.selectById(id);
    }

    @GetMapping("/user/selectAll")
    public List<User> selectAll() {
        return userMapper.selectList(null);
    }
}
