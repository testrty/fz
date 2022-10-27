package com.md.mybatisplus.t.Utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/*全局捕获异常*/
//@ControllerAdvice
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
   @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    //@ExceptionHandler(value = Exception.class)
    public Map<String, Object> errorResult(Exception e) {
        Map<String, Object> errorResultMap = new HashMap<String, Object>();
        errorResultMap.put("code", "500");
        errorResultMap.put("msg", "系统出现错误!"+e);
        return errorResultMap;
    }
}
