package com.md.mybatisplus.t.controller;

import com.md.mybatisplus.t.Utils.R;


import com.md.mybatisplus.t.entity.LocalTest;
import com.md.mybatisplus.t.service.LocalTestService;
import com.md.mybatisplus.t.service.impl.ThreadServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 主要体现在线程方面
 */

@RestController
@RequestMapping("/t")
@Api(value = "/api", tags = {"线程池"}, description = "线程池接口")
public class ThreadController {
    @Autowired
    LocalTestService localTestService;

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



    /**
     * 先线程，后线程池  线程池 批量新增40万数据
     *
     * 这样一次性新增20-40万数据，很慢 也可能和电脑cpu有关，自己电脑cpu好一些，一万数据也用了8秒
     *
     */
    @ApiOperation(value = "线程池", notes="threadPool" )
    @PostMapping(value = "/threadPool")
    public  R threadPool(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        // for (int k=0;k<5;k++) {
        new Thread(() -> {
            List<LocalTest> entityList=null;
            entityList = new ArrayList<>();
            for (int i = 0; i <= 10000; i++) {  //
                LocalTest l = new LocalTest();
                l.setName("你好");
                l.setName("用户名");
                entityList.add(l);
            }
            localTestService.saveBatch(entityList);
        }).start();
        //  }
        return R.OK(true);

    }

}
