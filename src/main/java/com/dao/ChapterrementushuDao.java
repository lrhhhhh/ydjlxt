package com.dao;

import com.entity.ChapterrementushuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ChapterrementushuVO;
import com.entity.view.ChapterrementushuView;


/**
 * 热门图书章节表
 * 
 * @author 
 * @email 
 * @date 2023-04-29 15:06:12
 */
public interface ChapterrementushuDao extends BaseMapper<ChapterrementushuEntity> {
	
	List<ChapterrementushuVO> selectListVO(@Param("ew") Wrapper<ChapterrementushuEntity> wrapper);
	
	ChapterrementushuVO selectVO(@Param("ew") Wrapper<ChapterrementushuEntity> wrapper);
	
	List<ChapterrementushuView> selectListView(@Param("ew") Wrapper<ChapterrementushuEntity> wrapper);

	List<ChapterrementushuView> selectListView(Pagination page,@Param("ew") Wrapper<ChapterrementushuEntity> wrapper);
	
	ChapterrementushuView selectView(@Param("ew") Wrapper<ChapterrementushuEntity> wrapper);
	

}
