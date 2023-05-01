package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ChapterrementushuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ChapterrementushuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ChapterrementushuView;


/**
 * 热门图书章节表
 *
 * @author 
 * @email 
 * @date 2023-04-29 15:06:12
 */
public interface ChapterrementushuService extends IService<ChapterrementushuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChapterrementushuVO> selectListVO(Wrapper<ChapterrementushuEntity> wrapper);
   	
   	ChapterrementushuVO selectVO(@Param("ew") Wrapper<ChapterrementushuEntity> wrapper);
   	
   	List<ChapterrementushuView> selectListView(Wrapper<ChapterrementushuEntity> wrapper);
   	
   	ChapterrementushuView selectView(@Param("ew") Wrapper<ChapterrementushuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChapterrementushuEntity> wrapper);
   	

}

