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


import com.dao.XinshuxinxiDao;
import com.entity.XinshuxinxiEntity;
import com.service.XinshuxinxiService;
import com.entity.vo.XinshuxinxiVO;
import com.entity.view.XinshuxinxiView;

@Service("xinshuxinxiService")
public class XinshuxinxiServiceImpl extends ServiceImpl<XinshuxinxiDao, XinshuxinxiEntity> implements XinshuxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XinshuxinxiEntity> page = this.selectPage(
                new Query<XinshuxinxiEntity>(params).getPage(),
                new EntityWrapper<XinshuxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XinshuxinxiEntity> wrapper) {
		  Page<XinshuxinxiView> page =new Query<XinshuxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XinshuxinxiVO> selectListVO(Wrapper<XinshuxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XinshuxinxiVO selectVO(Wrapper<XinshuxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XinshuxinxiView> selectListView(Wrapper<XinshuxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XinshuxinxiView selectView(Wrapper<XinshuxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
