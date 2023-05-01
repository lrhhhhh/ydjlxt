package com.entity.view;

import com.entity.YuedubijiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 阅读笔记
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-04-29 15:06:11
 */
@TableName("yuedubiji")
public class YuedubijiView  extends YuedubijiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YuedubijiView(){
	}
 
 	public YuedubijiView(YuedubijiEntity yuedubijiEntity){
 	try {
			BeanUtils.copyProperties(this, yuedubijiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
