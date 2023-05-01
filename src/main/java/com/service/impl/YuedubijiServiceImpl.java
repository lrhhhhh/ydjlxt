package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.YuedubijiDao;
import com.entity.YuedubijiEntity;
import com.service.YuedubijiService;
import com.entity.vo.YuedubijiVO;
import com.entity.view.YuedubijiView;

@Service("yuedubijiService")
public class YuedubijiServiceImpl extends ServiceImpl<YuedubijiDao, YuedubijiEntity> implements YuedubijiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YuedubijiEntity> page = this.selectPage(
                new Query<YuedubijiEntity>(params).getPage(),
                new EntityWrapper<YuedubijiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YuedubijiEntity> wrapper) {
		  Page<YuedubijiView> page =new Query<YuedubijiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YuedubijiVO> selectListVO(Wrapper<YuedubijiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YuedubijiVO selectVO(Wrapper<YuedubijiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YuedubijiView> selectListView(Wrapper<YuedubijiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YuedubijiView selectView(Wrapper<YuedubijiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
