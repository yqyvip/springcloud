package com.yqy.dao;

import com.yqy.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yqy
 * @date 2022-08-05-10:59
 */
public interface OrderDao extends JpaRepository<Order,Long> {
}
