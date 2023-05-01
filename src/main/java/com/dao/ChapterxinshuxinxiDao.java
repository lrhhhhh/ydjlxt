package com.dao;

import com.entity.ChapterxinshuxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ChapterxinshuxinxiVO;
import com.entity.view.ChapterxinshuxinxiView;


/**
 * 新书信息章节表
 * 
 * @author 
 * @email 
 * @date 2023-04-29 15:06:12
 */
public interface ChapterxinshuxinxiDao extends BaseMapper<ChapterxinshuxinxiEntity> {
	
	List<ChapterxinshuxinxiVO> selectListVO(@Param("ew") Wrapper<ChapterxinshuxinxiEntity> wrapper);
	
	ChapterxinshuxinxiVO selectVO(@Param("ew") Wrapper<ChapterxinshuxinxiEntity> wrapper);
	
	List<ChapterxinshuxinxiView> selectListView(@Param("ew") Wrapper<ChapterxinshuxinxiEntity> wrapper);

	List<ChapterxinshuxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<ChapterxinshuxinxiEntity> wrapper);
	
	ChapterxinshuxinxiView selectView(@Param("ew") Wrapper<ChapterxinshuxinxiEntity> wrapper);
	

}
