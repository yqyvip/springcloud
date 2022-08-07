package com.yqy.service.impl;

import com.yqy.dao.OrderDao;
import com.yqy.domain.Order;
import com.yqy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yqy
 * @date 2022-08-05-11:01
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Override
    public void save(Order order) {
        orderDao.save(order);
    }
}
