package com.serviceInterface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="cloudprover")
public interface FeignTestInterface {
    @GetMapping(value="/get")
        String get();
}
