package com.client;

import com.feigncommon.SchedualServiceHiHystric;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;



@EnableDiscoveryClient
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@SpringCloudApplication
@EnableFeignClients(defaultConfiguration = SchedualServiceHiHystric.class)




public class ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication .class, args);


    }



}

