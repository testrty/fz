package com.feign;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.SpringVersion;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@SpringBootApplication
//@SpringBootApplication(scanBasePackages = {"com.md.mybatisplus.t.Utils"})
@EnableFeignClients(basePackages = {"com.feigncommon","com.feign"})
@ComponentScan(basePackages = {"com.md.mybatisplus.t","com.util"})
@EnableDiscoveryClient
@EnableHystrix
@MapperScan("com.md.mybatisplus.t.mapper")
@EnableSwagger2

/*启动类中开启异步注解*/
@EnableAsync
@EnableScheduling
//@ConditionalOnProperty(name="swagger.enable" ,havingValue="true")
public class FeignApplication {

    public static void main(String[] args) {
        String version = SpringVersion.getVersion();
        String version1 = SpringBootVersion.getVersion();
        //结果 4.3.13.RELEASE 1.5.9.RELEASE    springboot版本  v1.5.9.RELEASE
     //   BeanFactory
       ApplicationContext ctx= SpringApplication.run(FeignApplication.class, args);
       String []benaNames=ctx.getBeanDefinitionNames();
        System.out.println(benaNames.length+"十分");
       for (String str : benaNames){
          System.out.println(str +"好好哈");
       }
    }
}
