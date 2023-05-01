package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussxinshuxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussxinshuxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussxinshuxinxiView;


/**
 * 新书信息评论表
 *
 * @author 
 * @email 
 * @date 2023-04-29 15:06:12
 */
public interface DiscussxinshuxinxiService extends IService<DiscussxinshuxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussxinshuxinxiVO> selectListVO(Wrapper<DiscussxinshuxinxiEntity> wrapper);
   	
   	DiscussxinshuxinxiVO selectVO(@Param("ew") Wrapper<DiscussxinshuxinxiEntity> wrapper);
   	
   	List<DiscussxinshuxinxiView> selectListView(Wrapper<DiscussxinshuxinxiEntity> wrapper);
   	
   	DiscussxinshuxinxiView selectView(@Param("ew") Wrapper<DiscussxinshuxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussxinshuxinxiEntity> wrapper);
   	

}

