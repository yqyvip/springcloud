package com.yqy.controller;

import com.alibaba.fastjson.JSON;
import com.yqy.domain.Product;
import com.yqy.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yqy
 * @date 2022-08-05-0:04
 */
@RestController
@Slf4j
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/product/{pid}")
    public Product product(@PathVariable("pid") Integer pid) {
        Product product = productService.findById(pid);
        log.info("查询到的商品" + JSON.toJSONString(product));
        return product;

    }
}
