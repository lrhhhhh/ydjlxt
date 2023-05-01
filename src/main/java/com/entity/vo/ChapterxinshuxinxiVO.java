package com.entity.vo;

import com.entity.ChapterxinshuxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 新书信息章节表
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-04-29 15:06:12
 */
public class ChapterxinshuxinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 章节数
	 */
	
	private Integer chapternum;
		
	/**
	 * 章节标题
	 */
	
	private String chaptertitle;
		
	/**
	 * 章节内容
	 */
	
	private String content;
				
	
	/**
	 * 设置：章节数
	 */
	 
	public void setChapternum(Integer chapternum) {
		this.chapternum = chapternum;
	}
	
	/**
	 * 获取：章节数
	 */
	public Integer getChapternum() {
		return chapternum;
	}
				
	
	/**
	 * 设置：章节标题
	 */
	 
	public void setChaptertitle(String chaptertitle) {
		this.chaptertitle = chaptertitle;
	}
	
	/**
	 * 获取：章节标题
	 */
	public String getChaptertitle() {
		return chaptertitle;
	}
				
	
	/**
	 * 设置：章节内容
	 */
	 
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * 获取：章节内容
	 */
	public String getContent() {
		return content;
	}
			
}
