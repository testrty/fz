package com.md.mybatisplus.t.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.md.mybatisplus.t.entity.Order;
import com.md.mybatisplus.t.mapper.OrderMapper;
import com.md.mybatisplus.t.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author md
 * @since 2021-04-04    orderAndDetails
 */
@Service
public class OrderServiceImpl  implements OrderService {

@Autowired
    OrderMapper orderMapper;
    @Override
    public List<Order> orderAndDetails() {
        return orderMapper.orderAndDetails();
    }
}
