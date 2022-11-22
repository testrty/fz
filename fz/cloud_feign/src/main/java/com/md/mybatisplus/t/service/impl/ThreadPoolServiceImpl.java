package com.md.mybatisplus.t.service.impl;

import com.md.mybatisplus.t.service.ThreadPoolService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Service
public class ThreadPoolServiceImpl implements ThreadPoolService {
    //@Async("taskExecutor")
     @Async
    public Future<String> sms(){

         System.out.println("目标方法执行完没1.........");
         System.out.println(Thread.currentThread().getName()+"：*用户服务被调用"+Thread.currentThread().getId());
            //Thread.sleep(300);

        //return "短信发送完成";
         return new AsyncResult<>("这里是异步用户服务端-2！");
    }



    @Async
    public Future<String> sms2(){
        System.out.println("目标方法执行完没2.........");
        System.out.println(Thread.currentThread().getName()+"：*用户服务被调用"+Thread.currentThread().getId());
        //Thread.sleep(300);

        //return "短信发送完成";
        return new AsyncResult<>("这里是异步用户服务端-2！");
    }

}
