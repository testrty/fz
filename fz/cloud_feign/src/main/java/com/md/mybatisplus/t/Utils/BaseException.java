package com.md.mybatisplus.t.Utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 47
 * @version 1.0
 * @date 2020/5/16 20:58
 * @description: 自定义异常类
 */
@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class BaseException  extends RuntimeException {

    private Integer code;

    private String msg;


    public BaseException(Integer code, String msg) {
     super(msg);
        this.code = code;
        this.msg = msg;
    }


    public BaseException() {
        super();
    }
}
