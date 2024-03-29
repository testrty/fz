package com.md.mybatisplus.t;

import com.alibaba.fastjson.JSONObject;
import com.md.mybatisplus.t.Utils.AutoIdempotent;
import com.md.mybatisplus.t.Utils.KafkaSender;
import com.md.mybatisplus.t.service.impl.TokenService;
import com.thoughtworks.xstream.core.BaseException;
import io.netty.util.Constant;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.bcel.Const;
import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

@Component
public class AdminInterceptor implements HandlerInterceptor {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    TokenService tokenService;

    @Autowired
    private KafkaSender<JSONObject> kafkaSender;



    /**
     * 在请求处理之前进行调用（Controller方法调用之前）
     */
    //@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler, JoinPoint joinPoint) throws IOException, ServletException {
        System.out.println("执行了TestInterceptor的preHandle方法  请求method前打印内容");



        if (!(handler instanceof HandlerMethod))
            return true;
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        //拿到方法上面的自定义注解
        AutoIdempotent annotation = method.getAnnotation(AutoIdempotent.class);

//        //如果不等于null说明该方法要进行幂等
//        if (null != annotation) {
//            System.out.println();
//            System.out.println("异常了吗   。。。。。。。。。。。。。。。。。。。。。。。。");
//            return  tokenService.checktoen(request);
//        }

        JSONObject jsonObject = new JSONObject();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
        jsonObject.put("request_time", df.format(new Date()));
        jsonObject.put("request_url", request.getRequestURL().toString());
        jsonObject.put("request_method", request.getMethod());
        jsonObject.put("signature", joinPoint.getSignature());
        jsonObject.put("request_args", Arrays.toString(joinPoint.getArgs()));
        JSONObject requestJsonObject = new JSONObject();
        requestJsonObject.put("request", jsonObject);
        kafkaSender.send(requestJsonObject);
       return true;
    }


    /**
     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        System.out.println("执行了TestInterceptor的postHandle方法");
    }

    /**
     * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        System.out.println("执行了TestInterceptor的afterCompletion方法");
    }


}
