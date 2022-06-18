package com.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.core.SpringVersion;

@EnableEurekaServer//启用Eureka服务
@EnableEurekaClient
//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
 @SpringBootApplication()

public class EurekaApplication {
    public static void main(String[] args)
    {
        String version = SpringVersion.getVersion();
        String version1 = SpringBootVersion.getVersion();
        //结果 4.3.13.RELEAS120000E方法士大夫1.5.9.RELEASE    springboot版本  v1.5.9.RELEASE
        System.out.println(version+"方法士大夫"+version1);
        SpringApplication.run(EurekaApplication.class, args);
    }
}

/**
 * springcloud相关  生产者 消费者参考地址： https://blog.csdn.net/qq_31748587/article/details/86008741
 *
 *
 */