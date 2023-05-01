package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XinshuxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XinshuxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XinshuxinxiView;


/**
 * 新书信息
 *
 * @author 
 * @email 
 * @date 2023-04-29 15:06:11
 */
public interface XinshuxinxiService extends IService<XinshuxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XinshuxinxiVO> selectListVO(Wrapper<XinshuxinxiEntity> wrapper);
   	
   	XinshuxinxiVO selectVO(@Param("ew") Wrapper<XinshuxinxiEntity> wrapper);
   	
   	List<XinshuxinxiView> selectListView(Wrapper<XinshuxinxiEntity> wrapper);
   	
   	XinshuxinxiView selectView(@Param("ew") Wrapper<XinshuxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XinshuxinxiEntity> wrapper);
   	

}

