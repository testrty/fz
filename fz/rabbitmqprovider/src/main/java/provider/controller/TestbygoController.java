package provider.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author md
 * @since 2021-06-15
 */
@RestController
@RequestMapping("/pro")
@Api(value = "/api", tags = {"生产着消息队列消费"}, description = "生产者生产队列")
public class TestbygoController {
    public static final String QUEUE_A = "QUEUE_A";
    @Autowired
    public RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue helloQueue;

    //定时发送
    @Scheduled(fixedDelay = 60000,initialDelay = 1000)
    @ApiOperation(value = "消息生产", notes = "")
    @GetMapping(value = "/send")
    public void send() {
        for (int i = 0; i < 100; i++) {
            String m = "xxx" + ".....";
            rabbitTemplate.convertAndSend(helloQueue.getName(),m);
            System.out.println("发送:" + m);
        }
    }

    @Bean
    public Queue q1(){
return  new Queue(QUEUE_A,true);
    }
}

