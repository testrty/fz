//package com.feigncommon;
//
//
//import feign.RequestInterceptor;
//import feign.RequestTemplate;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.context.annotation.Bean;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.ResponseEntity;
//import org.springframework.http.client.ClientHttpResponse;
//import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
//import org.springframework.stereotype.Component;
//import org.springframework.util.LinkedMultiValueMap;
//import org.springframework.util.MultiValueMap;
//import org.springframework.web.client.DefaultResponseErrorHandler;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.context.request.RequestAttributes;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//import java.net.URI;
//import java.util.*;
//
//@Component
//public class FeignClientInterceptor implements RequestInterceptor {
//
//    @Value("${encrypt.urls}")
//    private String[] urlList;
//
//    @Override
//    public void apply(RequestTemplate template) {
//        if (Arrays.asList(urlList).contains(template.url())) {//根据URL地址过滤请求
//            //log.info("请求参数为：{}", template.queryLine());//?param=123456
//            Collection<String> paramList = template.queries().get("param");
//            String param = paramList.iterator().next();
////            try {
////                // 加密
////                param = SM4Util.encryptEcb("1234567890", param);
////            } catch (Exception e) {
////                e.printStackTrace();
////            }
//            Map<String, Collection<String>> newQueries = new HashMap<>();
//            Collection<String> value = new ArrayList<>();
//            value.add(param);
//            newQueries.put("param", value);
//            template.queries(newQueries);// 替换原有对象
//           // log.info("加密后参数为：{}", template.queryLine());//?param=xxxxxx
//        }
//    }
//    }
//
//
//
