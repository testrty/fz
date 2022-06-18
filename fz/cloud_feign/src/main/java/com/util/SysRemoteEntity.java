package com.util;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2021-03-03 15:18:50
 */
@Data
@Getter
@Setter
@TableName("remote")
public class SysRemoteEntity implements Serializable {
	private static final long serialVersionUID = 1L;
//	@TableId(value="id")
//	@TableField("id")
	private Integer id;

	@TableField(value="platForm")
	private String platForm;

	private String sprd;

	private String modem;

	@TableField(value="projectName")
	private String projectName;

	@TableField(value="compileCommand")
	private String compileCommand;
	@TableField(value="androidVersion")
	private String  androidVersion;
	@TableField(value="softwareVersion")
	private String  softwareVersion;

	private String reqs;

	@TableField(value="userName")
	private String  userName;

	@TableField(value="reqsId")
	private String reqsId;





}


