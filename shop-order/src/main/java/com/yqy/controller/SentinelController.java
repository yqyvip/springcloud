package com.yqy.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yqy
 * @date 2022-08-05-14:50
 */
@RestController
@Slf4j
public class SentinelController {
    @SentinelResource(value = "/order/message1")
    @RequestMapping("/order/message1")
    public String message1() {
        return "message1";
    }

    @GetMapping("/order/message2")
    public String message2() {
        return "message2";
    }
}
