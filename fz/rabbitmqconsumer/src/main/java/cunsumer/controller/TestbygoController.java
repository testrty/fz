package cunsumer.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author md
 * @since 2021-06-15
 */

/**
 * author:ZhengXing
 * datetime:2018/1/19 0019 10:16
 * 自定义接收器
 */
//表示该类是mq的监听器,并监听hello队列
@RabbitListener(queues = "QUEUE_A")  //这个名字要和消息生产者的名字对应
@Controller
@RequestMapping("/cu")
@Api(value = "/api", tags = {"消费者 消息队列"}, description = "消费者消息队列")
public class TestbygoController {


    //标识当前对象id
    private final int instance;

    public TestbygoController(  ) {

        instance = 0;
    }

    //构造时传入id
    public TestbygoController(int instance) {
        this.instance = instance;
    }

    /**
     * 收到消息的处理方法
     */
    @RabbitHandler
    @ApiOperation(value = "消息消费者", notes = "")
    @GetMapping(value = "/custom")
    public void receive(String in) throws InterruptedException {
        //计时器
        StopWatch stopWatch = new StopWatch();
        //开始计时
        stopWatch.start();
        System.out.println("实例:" + instance +" 接收到消息:" + in + " 线程id:" + Thread.currentThread().getId());
        //模拟长时间消费
        doWork(in);
        stopWatch.stop();
        System.out.println("实例:" + instance +" 消费消息完毕:" + in + "消费时常:"+ stopWatch.getTotalTimeSeconds() + " 线程id:" + Thread.currentThread().getId());
    }

    /**
     * 根据接收到的消息中的 "."字符的个数,暂停对应描述,模拟长时间任务
     */
    private void doWork(String in) throws InterruptedException {
        for (char ch : in.toCharArray()) {
            if (ch == '.') {
                Thread.sleep(1000);
            }
        }
    }

}

