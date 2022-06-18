package com.feigncommon;

import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class SchedualServiceHiHystric implements FeignTestInterface {
    @Override
    public String get() {
        return "sorry";
    }
}
