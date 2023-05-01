package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ChapterxinshuxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ChapterxinshuxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ChapterxinshuxinxiView;


/**
 * 新书信息章节表
 *
 * @author 
 * @email 
 * @date 2023-04-29 15:06:12
 */
public interface ChapterxinshuxinxiService extends IService<ChapterxinshuxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChapterxinshuxinxiVO> selectListVO(Wrapper<ChapterxinshuxinxiEntity> wrapper);
   	
   	ChapterxinshuxinxiVO selectVO(@Param("ew") Wrapper<ChapterxinshuxinxiEntity> wrapper);
   	
   	List<ChapterxinshuxinxiView> selectListView(Wrapper<ChapterxinshuxinxiEntity> wrapper);
   	
   	ChapterxinshuxinxiView selectView(@Param("ew") Wrapper<ChapterxinshuxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChapterxinshuxinxiEntity> wrapper);
   	

}

