package com.md.mybatisplus.t.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotations.TableId;

import java.io.Serializable;


import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;

/**
 * <p>
 * 
 * </p>
 *
 * @author md
 * @since 2021-04-04   带上时间
 */
@ApiModel(description = "教师信息")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value="testbygo")



public class LocalTest extends Model<LocalTest> {

    private static final long serialVersionUID = 1L;

  //  @TableId("id")//  用注解 @TableId 注解表 ID 主键。当然 @TableId 注解可以没有！但是你的主键必须叫 id（忽略大小写）
//    @TableId(type= IdType.AUTO)
//  @TableId
//  @Id

    @ApiModelProperty(value="用户名",name="id",example="xingguo")
    private Integer id;

    @ApiModelProperty(value="用户名",name="name",example="xingguo",required=true)
    private String name;


    @Override
    protected Serializable pkVal() {
        return id;
    }
}
