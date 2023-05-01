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

import com.entity.DiscussxinshuxinxiEntity;
import com.entity.view.DiscussxinshuxinxiView;

import com.service.DiscussxinshuxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 新书信息评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-29 15:06:12
 */
@RestController
@RequestMapping("/discussxinshuxinxi")
public class DiscussxinshuxinxiController {
    @Autowired
    private DiscussxinshuxinxiService discussxinshuxinxiService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussxinshuxinxiEntity discussxinshuxinxi,
		HttpServletRequest request){
        EntityWrapper<DiscussxinshuxinxiEntity> ew = new EntityWrapper<DiscussxinshuxinxiEntity>();

		PageUtils page = discussxinshuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussxinshuxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussxinshuxinxiEntity discussxinshuxinxi, 
		HttpServletRequest request){
        EntityWrapper<DiscussxinshuxinxiEntity> ew = new EntityWrapper<DiscussxinshuxinxiEntity>();

		PageUtils page = discussxinshuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussxinshuxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussxinshuxinxiEntity discussxinshuxinxi){
       	EntityWrapper<DiscussxinshuxinxiEntity> ew = new EntityWrapper<DiscussxinshuxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussxinshuxinxi, "discussxinshuxinxi")); 
        return R.ok().put("data", discussxinshuxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussxinshuxinxiEntity discussxinshuxinxi){
        EntityWrapper< DiscussxinshuxinxiEntity> ew = new EntityWrapper< DiscussxinshuxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussxinshuxinxi, "discussxinshuxinxi")); 
		DiscussxinshuxinxiView discussxinshuxinxiView =  discussxinshuxinxiService.selectView(ew);
		return R.ok("查询新书信息评论表成功").put("data", discussxinshuxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussxinshuxinxiEntity discussxinshuxinxi = discussxinshuxinxiService.selectById(id);
        return R.ok().put("data", discussxinshuxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussxinshuxinxiEntity discussxinshuxinxi = discussxinshuxinxiService.selectById(id);
        return R.ok().put("data", discussxinshuxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussxinshuxinxiEntity discussxinshuxinxi, HttpServletRequest request){
    	discussxinshuxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussxinshuxinxi);
        discussxinshuxinxiService.insert(discussxinshuxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussxinshuxinxiEntity discussxinshuxinxi, HttpServletRequest request){
    	discussxinshuxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussxinshuxinxi);
        discussxinshuxinxiService.insert(discussxinshuxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DiscussxinshuxinxiEntity discussxinshuxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussxinshuxinxi);
        discussxinshuxinxiService.updateById(discussxinshuxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussxinshuxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
