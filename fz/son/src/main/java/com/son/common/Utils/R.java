package com.son.common.Utils;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * https://gitee.com/jeecg/jeecg-boot/blob/master/jeecg-boot/jeecg-boot-base/jeecg-boot-base-core/src/main/java/org/jeecg/common/api/vo/Result.java
 * 参考来源
 */

@Data
public class R<T>implements Serializable {
    //成功的标志
    private boolean success=true;

    //返回数据
    private T R ;


    /**
     * 成功的返回 带数据
     */
    public static<T>R<T>OK(T data){
        R<T>r=new R<T>();
        r.setSuccess(true);
        r.setR(data);
        return  r;

    }


}
