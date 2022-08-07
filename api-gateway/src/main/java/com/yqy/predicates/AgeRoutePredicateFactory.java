package com.yqy.predicates;

import com.yqy.config.AgeConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author yqy
 * @date 2022-08-05-20:19
 */
@Component
@Slf4j
public class AgeRoutePredicateFactory extends AbstractRoutePredicateFactory<AgeConfig> {

    public AgeRoutePredicateFactory() {
        super(AgeConfig.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("minAge","maxAge");
    }
    @Override
    public Predicate<ServerWebExchange> apply(AgeConfig config) {
        return serverWebExchange -> {
            //从serverWebExchange获取传入的参数
            String ageStr = serverWebExchange.getRequest().getQueryParams().getFirst("age");
            if (StringUtils.isNotEmpty(ageStr)) {
                log.info("获得参数" + ageStr);
                int age = Integer.parseInt(ageStr);
                return age > config.getMinAge() && age < config.getMaxAge();
            }
            return true;
        };
    }
}