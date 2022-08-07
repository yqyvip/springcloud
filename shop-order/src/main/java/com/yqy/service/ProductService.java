package com.yqy.service;

import com.yqy.domain.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author yqy
 * @date 2022-08-05-13:03
 */
@FeignClient("service-product")
public interface ProductService {

    @GetMapping(value = "/product/{pid}")
    Product findByPid(@PathVariable("pid") Integer pid);
}
