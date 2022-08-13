package com.md.mybatisplus.t.controller;


import com.md.mybatisplus.t.Utils.R;
import com.md.mybatisplus.t.entity.Order;
import com.md.mybatisplus.t.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
  具体业务方面的
 */



//@Controller
@RestController
@RequestMapping("/order/order")
@Api(value = "/api", tags = {"订单"}, description = "订单接口")
public class BusinessController {

    @Autowired
    OrderService orderService;

    @ApiOperation(value = "订单跑", notes = "")
    @GetMapping(value = "/hi")
    public Object hello() {
        return "hello";
    }




    @ApiOperation(value = "订单下的订单详情", notes = "一个订单，多个详情")
    @GetMapping(value = "/oderDetails")
    public R orderAndDetails() {
        List<Order> list= orderService.orderAndDetails();
        return  R.OK(list);
    }


}

