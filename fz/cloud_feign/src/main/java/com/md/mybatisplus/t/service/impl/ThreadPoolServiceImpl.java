package com.md.mybatisplus.t.service.impl;

import com.md.mybatisplus.t.service.ThreadPoolService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ThreadPoolServiceImpl implements ThreadPoolService {
    @Async
    public String sms(){
        try {
            System.out.println("正在发送短信");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "短信发送完成";
    }

}
