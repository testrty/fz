package com.md.mybatisplus.t.service;

import org.springframework.scheduling.annotation.AsyncResult;

import java.util.concurrent.Future;

public interface ThreadPoolService {
    public Future<String> sms();
    public Future<String> sms2();
}
