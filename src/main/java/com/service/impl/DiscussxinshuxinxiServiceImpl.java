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


import com.dao.DiscussxinshuxinxiDao;
import com.entity.DiscussxinshuxinxiEntity;
import com.service.DiscussxinshuxinxiService;
import com.entity.vo.DiscussxinshuxinxiVO;
import com.entity.view.DiscussxinshuxinxiView;

@Service("discussxinshuxinxiService")
public class DiscussxinshuxinxiServiceImpl extends ServiceImpl<DiscussxinshuxinxiDao, DiscussxinshuxinxiEntity> implements DiscussxinshuxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussxinshuxinxiEntity> page = this.selectPage(
                new Query<DiscussxinshuxinxiEntity>(params).getPage(),
                new EntityWrapper<DiscussxinshuxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussxinshuxinxiEntity> wrapper) {
		  Page<DiscussxinshuxinxiView> page =new Query<DiscussxinshuxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussxinshuxinxiVO> selectListVO(Wrapper<DiscussxinshuxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussxinshuxinxiVO selectVO(Wrapper<DiscussxinshuxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussxinshuxinxiView> selectListView(Wrapper<DiscussxinshuxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussxinshuxinxiView selectView(Wrapper<DiscussxinshuxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
