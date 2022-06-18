package com.feign;

import com.feigncommon.FeignTestInterface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "/api", tags = {"微服务"}, description = "微服务接口")
@RequestMapping("/cloudtest")
public class FeignTestController {
    @Autowired
    FeignTestInterface feignTestInterface;

    @ApiOperation(value = "微服务走了", notes = "微服务跑了")
    @GetMapping("/getByFeign")
    public String get(){
        return  feignTestInterface.get();
    }


}
