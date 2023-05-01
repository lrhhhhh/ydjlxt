package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.BijileixingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.BijileixingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.BijileixingView;


/**
 * 笔记类型
 *
 * @author 
 * @email 
 * @date 2023-04-29 15:06:11
 */
public interface BijileixingService extends IService<BijileixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<BijileixingVO> selectListVO(Wrapper<BijileixingEntity> wrapper);
   	
   	BijileixingVO selectVO(@Param("ew") Wrapper<BijileixingEntity> wrapper);
   	
   	List<BijileixingView> selectListView(Wrapper<BijileixingEntity> wrapper);
   	
   	BijileixingView selectView(@Param("ew") Wrapper<BijileixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<BijileixingEntity> wrapper);
   	

}

