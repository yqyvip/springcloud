package com.yqy.service.impl;

import com.yqy.dao.ProductDao;
import com.yqy.domain.Product;
import com.yqy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yqy
 * @date 2022-08-05-0:01
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product findById(Integer pid) {
        return productDao.findById(pid).get();
    }
}
