package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 阅读笔记
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-04-29 15:06:11
 */
@TableName("yuedubiji")
public class YuedubijiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public YuedubijiEntity() {
		
	}
	
	public YuedubijiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 笔记名称
	 */
					
	private String bijimingcheng;
	
	/**
	 * 图片信息
	 */
					
	private String tupianxinxi;
	
	/**
	 * 笔记内容
	 */
					
	private String bijineirong;
	
	/**
	 * 笔记类型
	 */
					
	private String bijileixing;
	
	/**
	 * 笔记日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date bijiriqi;
	
	/**
	 * 用户id
	 */
					
	private Long userid;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：笔记名称
	 */
	public void setBijimingcheng(String bijimingcheng) {
		this.bijimingcheng = bijimingcheng;
	}
	/**
	 * 获取：笔记名称
	 */
	public String getBijimingcheng() {
		return bijimingcheng;
	}
	/**
	 * 设置：图片信息
	 */
	public void setTupianxinxi(String tupianxinxi) {
		this.tupianxinxi = tupianxinxi;
	}
	/**
	 * 获取：图片信息
	 */
	public String getTupianxinxi() {
		return tupianxinxi;
	}
	/**
	 * 设置：笔记内容
	 */
	public void setBijineirong(String bijineirong) {
		this.bijineirong = bijineirong;
	}
	/**
	 * 获取：笔记内容
	 */
	public String getBijineirong() {
		return bijineirong;
	}
	/**
	 * 设置：笔记类型
	 */
	public void setBijileixing(String bijileixing) {
		this.bijileixing = bijileixing;
	}
	/**
	 * 获取：笔记类型
	 */
	public String getBijileixing() {
		return bijileixing;
	}
	/**
	 * 设置：笔记日期
	 */
	public void setBijiriqi(Date bijiriqi) {
		this.bijiriqi = bijiriqi;
	}
	/**
	 * 获取：笔记日期
	 */
	public Date getBijiriqi() {
		return bijiriqi;
	}
	/**
	 * 设置：用户id
	 */
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	/**
	 * 获取：用户id
	 */
	public Long getUserid() {
		return userid;
	}

}
