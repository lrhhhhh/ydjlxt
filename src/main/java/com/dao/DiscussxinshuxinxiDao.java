package com.dao;

import com.entity.DiscussxinshuxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussxinshuxinxiVO;
import com.entity.view.DiscussxinshuxinxiView;


/**
 * 新书信息评论表
 * 
 * @author 
 * @email 
 * @date 2023-04-29 15:06:12
 */
public interface DiscussxinshuxinxiDao extends BaseMapper<DiscussxinshuxinxiEntity> {
	
	List<DiscussxinshuxinxiVO> selectListVO(@Param("ew") Wrapper<DiscussxinshuxinxiEntity> wrapper);
	
	DiscussxinshuxinxiVO selectVO(@Param("ew") Wrapper<DiscussxinshuxinxiEntity> wrapper);
	
	List<DiscussxinshuxinxiView> selectListView(@Param("ew") Wrapper<DiscussxinshuxinxiEntity> wrapper);

	List<DiscussxinshuxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussxinshuxinxiEntity> wrapper);
	
	DiscussxinshuxinxiView selectView(@Param("ew") Wrapper<DiscussxinshuxinxiEntity> wrapper);
	

}
