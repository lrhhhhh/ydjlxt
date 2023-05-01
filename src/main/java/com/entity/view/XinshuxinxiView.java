package com.entity.view;

import com.entity.XinshuxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 新书信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-04-29 15:06:11
 */
@TableName("xinshuxinxi")
public class XinshuxinxiView  extends XinshuxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public XinshuxinxiView(){
	}
 
 	public XinshuxinxiView(XinshuxinxiEntity xinshuxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, xinshuxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
