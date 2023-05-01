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


import com.dao.ChapterrementushuDao;
import com.entity.ChapterrementushuEntity;
import com.service.ChapterrementushuService;
import com.entity.vo.ChapterrementushuVO;
import com.entity.view.ChapterrementushuView;

@Service("chapterrementushuService")
public class ChapterrementushuServiceImpl extends ServiceImpl<ChapterrementushuDao, ChapterrementushuEntity> implements ChapterrementushuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChapterrementushuEntity> page = this.selectPage(
                new Query<ChapterrementushuEntity>(params).getPage(),
                new EntityWrapper<ChapterrementushuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChapterrementushuEntity> wrapper) {
		  Page<ChapterrementushuView> page =new Query<ChapterrementushuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ChapterrementushuVO> selectListVO(Wrapper<ChapterrementushuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ChapterrementushuVO selectVO(Wrapper<ChapterrementushuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ChapterrementushuView> selectListView(Wrapper<ChapterrementushuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChapterrementushuView selectView(Wrapper<ChapterrementushuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
