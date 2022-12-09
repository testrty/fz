package com.md.mybatisplus.t.Utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
//@Component
public class TaskThreadPoolConfig {
    /* 核心线程数*/
    private int corePoolSize;
    /*最大线程数 */
    private int maxPoolSize;

  // @Bean // 有这个就会报错
//public TaskExecutor taskExecutor(){
public Executor taskExecutor(){
        ThreadPoolTaskExecutor executor=new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setThreadNamePrefix("thredad_");
        return  executor;
    }
}

