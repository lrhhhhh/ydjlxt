package com.dao;

import com.entity.XinshuxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XinshuxinxiVO;
import com.entity.view.XinshuxinxiView;


/**
 * 新书信息
 * 
 * @author 
 * @email 
 * @date 2023-04-29 15:06:11
 */
public interface XinshuxinxiDao extends BaseMapper<XinshuxinxiEntity> {
	
	List<XinshuxinxiVO> selectListVO(@Param("ew") Wrapper<XinshuxinxiEntity> wrapper);
	
	XinshuxinxiVO selectVO(@Param("ew") Wrapper<XinshuxinxiEntity> wrapper);
	
	List<XinshuxinxiView> selectListView(@Param("ew") Wrapper<XinshuxinxiEntity> wrapper);

	List<XinshuxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<XinshuxinxiEntity> wrapper);
	
	XinshuxinxiView selectView(@Param("ew") Wrapper<XinshuxinxiEntity> wrapper);
	

}
