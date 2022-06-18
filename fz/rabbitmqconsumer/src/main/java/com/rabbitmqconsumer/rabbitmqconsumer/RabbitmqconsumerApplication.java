package com.rabbitmqconsumer.rabbitmqconsumer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("cunsumer.mapper")
@ComponentScan(basePackages = {"cunsumer" })
@EnableSwagger2
public class RabbitmqconsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqconsumerApplication.class, args);
    }

}
