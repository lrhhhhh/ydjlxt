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


import com.dao.ChapterxinshuxinxiDao;
import com.entity.ChapterxinshuxinxiEntity;
import com.service.ChapterxinshuxinxiService;
import com.entity.vo.ChapterxinshuxinxiVO;
import com.entity.view.ChapterxinshuxinxiView;

@Service("chapterxinshuxinxiService")
public class ChapterxinshuxinxiServiceImpl extends ServiceImpl<ChapterxinshuxinxiDao, ChapterxinshuxinxiEntity> implements ChapterxinshuxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChapterxinshuxinxiEntity> page = this.selectPage(
                new Query<ChapterxinshuxinxiEntity>(params).getPage(),
                new EntityWrapper<ChapterxinshuxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChapterxinshuxinxiEntity> wrapper) {
		  Page<ChapterxinshuxinxiView> page =new Query<ChapterxinshuxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ChapterxinshuxinxiVO> selectListVO(Wrapper<ChapterxinshuxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ChapterxinshuxinxiVO selectVO(Wrapper<ChapterxinshuxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ChapterxinshuxinxiView> selectListView(Wrapper<ChapterxinshuxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChapterxinshuxinxiView selectView(Wrapper<ChapterxinshuxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
