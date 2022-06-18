package com.md.mybatisplus.t.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.md.mybatisplus.t.entity.Order;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author md
 * @since 2021-04-04
 */
public interface OrderService {

    List<Order> orderAndDetails();
}
