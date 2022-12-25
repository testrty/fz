package com.md.mybatisplus.t.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

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

    private List<Orderdetails> orderdetailss; //订单详情表



    @Override
    protected Serializable pkVal() {
        return this.orderid;
    }

}
