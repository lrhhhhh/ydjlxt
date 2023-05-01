package com.entity.vo;

import com.entity.YuedubijiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 阅读笔记
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-04-29 15:06:11
 */
public class YuedubijiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date bijiriqi;
		
	/**
	 * 用户id
	 */
	
	private Long userid;
				
	
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
