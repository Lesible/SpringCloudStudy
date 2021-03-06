package com.relic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.function.Predicate;

/**
 * <p>date 2020-08-11 18:58</p>
 *
 * @author Lesible
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ConfigClientService {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientService.class, args);
    }

}
