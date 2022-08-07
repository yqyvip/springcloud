package com.yqy.dao;

import com.yqy.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yqy
 * @date 2022-08-04-23:58
 */
public interface ProductDao extends JpaRepository<Product,Integer> {
}
