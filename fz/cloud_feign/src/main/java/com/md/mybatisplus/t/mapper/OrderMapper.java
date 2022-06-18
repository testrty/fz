package com.md.mybatisplus.t.mapper;




import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.md.mybatisplus.t.entity.LocalTest;
import com.md.mybatisplus.t.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author md
 * @since 2021-04-04
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {
    List<Order> orderAndDetails();

}
