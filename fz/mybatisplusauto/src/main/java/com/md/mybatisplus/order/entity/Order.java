package com.md.mybatisplus.order.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.Version;

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
public class Order extends Model<Order> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "orderid", type = IdType.AUTO)
    private Integer orderid;
    private String ordername;
    private String orderdress;
    private String orderstatus;


    @Override
    protected Serializable pkVal() {
        return this.orderid;
    }

}
