package com.yqy.controller;

import com.alibaba.fastjson.JSON;
import com.yqy.domain.Order;
import com.yqy.domain.Product;
import com.yqy.service.OrderService;
import com.yqy.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

/**
 * @author yqy
 * @date 2022-08-05-11:11
 */
@RestController
@Slf4j
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderService orderService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private ProductService productService;

    //准备买1件商品
    @GetMapping("/order/prod/{pid}")
    public Order order(@PathVariable("pid") Integer pid) {
        log.info(">>客户下单，这时候要调用商品微服务查询商品信息");
//从nacos中获取服务地址
//        ServiceInstance serviceInstance = discoveryClient.getInstances("service-product").get(0);
//        String url = serviceInstance.getHost() + ":" + serviceInstance.getPort();
//        log.info(">>从nacos中获取到的微服务地址为:" + url);
//        log.info(">>客户下单，这时候要调用商品微服务查询商品信息");

//从nacos中获取服务地址
//自定义规则实现随机挑选服
//        List<ServiceInstance> instances = discoveryClient.getInstances("service-product");
//        int index = new Random().nextInt(instances.size());
//        ServiceInstance serviceInstance = instances.get(index);
//        String url = serviceInstance.getHost() + ":" + serviceInstance.getPort();
//        log.info(">>从nacos中获取到的微服务地址为:" + url);

//通过restTemplate调用商品微服务
//        Product product = restTemplate.getForObject(
//                "http://localhost:8081/product/" + pid, Product.class);

        //通过fegin调用商品微服务
        Product product = productService.findByPid(pid);

        log.info(">>商品信息,查询结果:" + JSON.toJSONString(product));
        Order order = new Order();
        order.setUid(1);
        order.setUsername("qq");
        order.setPid(product.getPid());
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());
        order.setNumber(1);
        orderService.save(order);
        return order;
    }

}
