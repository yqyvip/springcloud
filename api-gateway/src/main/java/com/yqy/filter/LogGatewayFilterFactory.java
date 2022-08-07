package com.yqy.filter;

import com.yqy.config.LogConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

/**
 * @author yqy
 * @date 2022-08-06-11:23
 */
@Slf4j
@Component
public class LogGatewayFilterFactory extends AbstractGatewayFilterFactory<LogConfig> {
    public LogGatewayFilterFactory() {
        super(LogConfig.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("consoleLog", "cacheLog");
    }

    @Override
    public GatewayFilter apply(LogConfig config) {
        return (exchange, chain) -> {
            if (config.isCacheLog()) {
                log.info("cacheLog已经开启");
            }
            if (config.isConsoleLog()) {
                log.info("consoleLog已经开启");
            }
            return chain.filter(exchange);
        };
    }
}
