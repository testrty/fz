package com.rabbitmq.provider.rabbitmqprovider;

import javafx.application.Application;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("provider.mapper")
@ComponentScan(basePackages = {"provider" })
@EnableSwagger2 //是这个原因吧  少了 这个注解
public class RabbitmqproviderApplication {

    /**
     *
     * 参考的不是官网  是源码https://github.com/BrightStarry/RabbitMQ
     */


    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(RabbitmqproviderApplication.class, args);
        //所有的bean,参考：http://412887952-qq-com.iteye.com/blog/2314051
        String[] beanNames = ctx.getBeanDefinitionNames();
        //String[] beanNames = ctx.getBeanNamesForAnnotation(RestController.class);//所有添加该注解的bean
       // logger.info("bean总数:{}", ctx.getBeanDefinitionCount());
        System.out.println( ctx.getBeanDefinitionCount());
        int i = 0;
        for (String str : beanNames) {
           // logger.info("{},beanName:{}", ++i, str);
          //  System.out.println(++i+"beanName"+str);
        }

       // SpringApplication.run(RabbitmqproviderApplication.class, args);
    }

}
