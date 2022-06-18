package com.md.mybatisplus.t.service.impl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
@Configuration
public class ThreadServiceImpl extends ThreadPoolExecutor {

  public static   BlockingQueue workQueue =new  LinkedBlockingDeque(1);
    /**
     * 定义线程池bean
     * @return
     */
    @Bean
    public  ThreadPoolExecutor buildThreadPool(){
//        return new ThreadServiceImpl(1,1,1L,TimeUnit.SECONDS,new LinkedBlockingDeque<>());
        return new ThreadServiceImpl(1,1,1L,TimeUnit.SECONDS,workQueue);
    }
    public  ThreadServiceImpl(){
        this(1,1,1L,TimeUnit.SECONDS,workQueue);
    }


    public ThreadServiceImpl(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }


    public static void main(String[] args) {
        ThreadServiceImpl t=new ThreadServiceImpl(1,2,1L,TimeUnit.SECONDS,new LinkedBlockingDeque<>());
        System.out.println(t.getCorePoolSize());
    }

    ///////////////////////////////////////////////////////////



//    /**
//     * 定义线程池bean
//     * @return
//     */
//    @Bean
//    public ThreadPoolExecutor buildThreadPool(){
////        return new ThreadServiceImpl(1,1,1L,TimeUnit.SECONDS,new LinkedBlockingDeque<>());
//        return new ThreadServiceImpl(1,1,1L,TimeUnit.SECONDS,q);
//    }
//    public ThreadServiceImpl(){
//        this(1,1,1L,TimeUnit.SECONDS,new LinkedBlockingDeque<>());
//    }
//
//
//    public ThreadServiceImpl(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
//        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
//    }
//
    ////////////////////////////////////////////////////






    //    int corePoolSize=0;
//   int maximumPoolSize=90;
//    private final long keepAliveTime;
//    private final TimeUnit unit;
//    private final BlockingQueue<Runnable> workQueue;
//
//    public ThreadServiceImpl(corePoolSize,  maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
//        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
//        this.corePoolSize = corePoolSize;
//        this.maximumPoolSize = maximumPoolSize;
//        this.keepAliveTime = keepAliveTime;
//        this.unit = unit;
//        this.workQueue = workQueue;
//    }

}
