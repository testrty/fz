package configserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {
//    @Value("${use}")
//    String use;
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
//    @Bean
//    public String aa(){
//        System.out.println(use);
//        return "";
//    }
}
