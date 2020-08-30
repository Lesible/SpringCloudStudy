package com.relic.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Relic
 * @date 2020-07-01 16:43
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceConsumerMovieOpenFeign {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceConsumerMovieOpenFeign.class, args);
    }
}
