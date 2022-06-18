package com.feigncommon;






import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value ="cloudprover" ,  configuration= FeignClientsConfiguration.class,fallback = SchedualServiceHiHystric.class)
public interface FeignTestInterface {
    @GetMapping(value="/get")
    String get();
}
