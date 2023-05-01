package com.dao;

import com.entity.YuedubijiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YuedubijiVO;
import com.entity.view.YuedubijiView;


/**
 * 阅读笔记
 * 
 * @author 
 * @email 
 * @date 2023-04-29 15:06:11
 */
public interface YuedubijiDao extends BaseMapper<YuedubijiEntity> {
	
	List<YuedubijiVO> selectListVO(@Param("ew") Wrapper<YuedubijiEntity> wrapper);
	
	YuedubijiVO selectVO(@Param("ew") Wrapper<YuedubijiEntity> wrapper);
	
	List<YuedubijiView> selectListView(@Param("ew") Wrapper<YuedubijiEntity> wrapper);

	List<YuedubijiView> selectListView(Pagination page,@Param("ew") Wrapper<YuedubijiEntity> wrapper);
	
	YuedubijiView selectView(@Param("ew") Wrapper<YuedubijiEntity> wrapper);
	

}
