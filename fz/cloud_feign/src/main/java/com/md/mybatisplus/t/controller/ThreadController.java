package com.md.mybatisplus.t.controller;

import com.md.mybatisplus.t.Utils.R;


import com.md.mybatisplus.t.service.impl.ThreadServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/t")
@Api(value = "/api", tags = {"线程池"}, description = "线程池接口")
public class ThreadController {

    @Autowired
    //   ThreadPoolExecutor d;
            ThreadServiceImpl d;

    @ApiOperation(value = "222", notes = "")
    @GetMapping(value = "/xcc")
    public R goMybatisp() {
        d.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                d.execute(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(2);
                    }
                });
            }
        });

//
        d.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(3);
            }
        });


        return null;
    }


}
