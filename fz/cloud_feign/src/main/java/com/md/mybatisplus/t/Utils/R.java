package com.md.mybatisplus.t.Utils;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://gitee.com/jeecg/jeecg-boot/blob/master/jeecg-boot/jeecg-boot-base/jeecg-boot-base-core/src/main/java/org/jeecg/common/api/vo/Result.java
 * 参考来源
 */

@Data
public class R<T>implements Serializable {
    //成功的标志
    private boolean success=true;
    private Map<String, Object> data = new HashMap<String, Object>();

    //返回数据
    private T R ;

    private Integer code;
    private String message;

    //封装返回成功
    public static R ok1(){
        R r = new R();
        r.setSuccess(true);
        r.setCode(200);      //改成动态的    r.setCode(ResultCode.SUCCESS);
        r.setMessage("成功");
        return r;
    }


    /**
     * 成功的返回 带数据
     */
    public static<T>R<T>OK(T data){
        R<T>r=new R<T>();
        r.setSuccess(true);
        r.setR(data);
        return  r;

    }

    public R data(String key,Object value){
         data.put(key,value);
         return this;

    }


}
