package com.entity.view;

import com.entity.ChapterrementushuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 热门图书章节表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-04-29 15:06:12
 */
@TableName("chapterrementushu")
public class ChapterrementushuView  extends ChapterrementushuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ChapterrementushuView(){
	}
 
 	public ChapterrementushuView(ChapterrementushuEntity chapterrementushuEntity){
 	try {
			BeanUtils.copyProperties(this, chapterrementushuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
