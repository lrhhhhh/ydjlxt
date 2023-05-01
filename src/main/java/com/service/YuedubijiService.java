package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YuedubijiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YuedubijiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YuedubijiView;


/**
 * 阅读笔记
 *
 * @author 
 * @email 
 * @date 2023-04-29 15:06:11
 */
public interface YuedubijiService extends IService<YuedubijiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YuedubijiVO> selectListVO(Wrapper<YuedubijiEntity> wrapper);
   	
   	YuedubijiVO selectVO(@Param("ew") Wrapper<YuedubijiEntity> wrapper);
   	
   	List<YuedubijiView> selectListView(Wrapper<YuedubijiEntity> wrapper);
   	
   	YuedubijiView selectView(@Param("ew") Wrapper<YuedubijiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YuedubijiEntity> wrapper);
   	

}

