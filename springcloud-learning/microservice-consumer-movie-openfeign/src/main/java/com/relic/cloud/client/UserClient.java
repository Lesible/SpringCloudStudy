package com.relic.cloud.client;

import com.relic.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * <p>date: 2020-07-01 16:44</p>
 * @author Relic
 */
@FeignClient(name = "microservice-provider-user")
public interface UserClient {


    /**
     * 远程调用微服务获取用户
     *
     * @param id 用户主键
     * @return 用户实体
     */
    @GetMapping("/user/{id}")
    User getUser(@PathVariable("id") Long id);

    /**
     * 远程调用微服务获取所有用户
     *
     * @return 所有用户集合
     */
    @GetMapping("/user/selectAll")
    List<User> selectAll();

}
