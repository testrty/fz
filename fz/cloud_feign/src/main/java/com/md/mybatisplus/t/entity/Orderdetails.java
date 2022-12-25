package com.md.mybatisplus.t.entity;

import java.util.Date;

import java.io.Serializable;


import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author md
 * @since 2021-07-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Orderdetails extends Model<Orderdetails> {

    private static final long serialVersionUID = 1L;

    private Integer orderid;
    private String ordername;
    private Date orderdate;
    private String orderprice;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
