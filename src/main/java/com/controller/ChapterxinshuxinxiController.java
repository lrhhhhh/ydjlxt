package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.ChapterxinshuxinxiEntity;
import com.entity.view.ChapterxinshuxinxiView;

import com.service.ChapterxinshuxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 新书信息章节表
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-29 15:06:12
 */
@RestController
@RequestMapping("/chapterxinshuxinxi")
public class ChapterxinshuxinxiController {
    @Autowired
    private ChapterxinshuxinxiService chapterxinshuxinxiService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ChapterxinshuxinxiEntity chapterxinshuxinxi,
		HttpServletRequest request){
        EntityWrapper<ChapterxinshuxinxiEntity> ew = new EntityWrapper<ChapterxinshuxinxiEntity>();

		PageUtils page = chapterxinshuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chapterxinshuxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ChapterxinshuxinxiEntity chapterxinshuxinxi, 
		HttpServletRequest request){
        EntityWrapper<ChapterxinshuxinxiEntity> ew = new EntityWrapper<ChapterxinshuxinxiEntity>();

		PageUtils page = chapterxinshuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chapterxinshuxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ChapterxinshuxinxiEntity chapterxinshuxinxi){
       	EntityWrapper<ChapterxinshuxinxiEntity> ew = new EntityWrapper<ChapterxinshuxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( chapterxinshuxinxi, "chapterxinshuxinxi")); 
        return R.ok().put("data", chapterxinshuxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChapterxinshuxinxiEntity chapterxinshuxinxi){
        EntityWrapper< ChapterxinshuxinxiEntity> ew = new EntityWrapper< ChapterxinshuxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( chapterxinshuxinxi, "chapterxinshuxinxi")); 
		ChapterxinshuxinxiView chapterxinshuxinxiView =  chapterxinshuxinxiService.selectView(ew);
		return R.ok("查询新书信息章节表成功").put("data", chapterxinshuxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChapterxinshuxinxiEntity chapterxinshuxinxi = chapterxinshuxinxiService.selectById(id);
        return R.ok().put("data", chapterxinshuxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ChapterxinshuxinxiEntity chapterxinshuxinxi = chapterxinshuxinxiService.selectById(id);
        return R.ok().put("data", chapterxinshuxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChapterxinshuxinxiEntity chapterxinshuxinxi, HttpServletRequest request){
    	chapterxinshuxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(chapterxinshuxinxi);
        chapterxinshuxinxiService.insert(chapterxinshuxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChapterxinshuxinxiEntity chapterxinshuxinxi, HttpServletRequest request){
    	chapterxinshuxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(chapterxinshuxinxi);
        chapterxinshuxinxiService.insert(chapterxinshuxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ChapterxinshuxinxiEntity chapterxinshuxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(chapterxinshuxinxi);
        chapterxinshuxinxiService.updateById(chapterxinshuxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        chapterxinshuxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
