package com.relic.cloud.config;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p> @date: 2020-09-15 19:28</p>
 *
 * @author Lesible
 */
@Configuration
public class RouteConfig {

    @Resource
    private GatewayFilter headerFilter;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("baidu", route -> route.path("/s").and().query("wd")
                        .filters(f -> f.filter(headerFilter)).uri("https://www.baidu.com"))
                .route("google",route->route.path("/search").and().query("q")
                .filters(f->f.filter(headerFilter)).uri("https://www.google.com/"))
                .build();
    }

    @Bean
    public GatewayFilter headerFilter() {
        return (exchange, chain) -> {
            HttpHeaders headers = exchange.getRequest().getHeaders();
            Set<Map.Entry<String, List<String>>> entries = headers.entrySet();
            for (Map.Entry<String, List<String>> entry : entries) {
                String key = entry.getKey();
                System.out.printf("%s:%s%n", key, headers.get(key));
            }
            return chain.filter(exchange);
        };
    }

}
