package com.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy //网关
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class ZuulApplication {

    public static void main(String[] args){

        SpringApplication.run(ZuulApplication.class, args);
        System.out.println("网关服务");
    }

    @Bean
    public  util.MyZuulFilter myZuulFilter(){
        return  new  util.MyZuulFilter();
    }
}
