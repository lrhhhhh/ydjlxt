package com.entity.view;

import com.entity.ChapterxinshuxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 新书信息章节表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-04-29 15:06:12
 */
@TableName("chapterxinshuxinxi")
public class ChapterxinshuxinxiView  extends ChapterxinshuxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ChapterxinshuxinxiView(){
	}
 
 	public ChapterxinshuxinxiView(ChapterxinshuxinxiEntity chapterxinshuxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, chapterxinshuxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
