package com.md.mybatisplus.order.service.impl;

import com.md.mybatisplus.order.entity.Order;
import com.md.mybatisplus.order.mapper.OrderMapper;
import com.md.mybatisplus.order.service.OrderService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author md
 * @since 2021-07-26
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

}
