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

import com.entity.DiscussrementushuEntity;
import com.entity.view.DiscussrementushuView;

import com.service.DiscussrementushuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 热门图书评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-29 15:06:12
 */
@RestController
@RequestMapping("/discussrementushu")
public class DiscussrementushuController {
    @Autowired
    private DiscussrementushuService discussrementushuService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussrementushuEntity discussrementushu,
		HttpServletRequest request){
        EntityWrapper<DiscussrementushuEntity> ew = new EntityWrapper<DiscussrementushuEntity>();

		PageUtils page = discussrementushuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussrementushu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussrementushuEntity discussrementushu, 
		HttpServletRequest request){
        EntityWrapper<DiscussrementushuEntity> ew = new EntityWrapper<DiscussrementushuEntity>();

		PageUtils page = discussrementushuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussrementushu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussrementushuEntity discussrementushu){
       	EntityWrapper<DiscussrementushuEntity> ew = new EntityWrapper<DiscussrementushuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussrementushu, "discussrementushu")); 
        return R.ok().put("data", discussrementushuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussrementushuEntity discussrementushu){
        EntityWrapper< DiscussrementushuEntity> ew = new EntityWrapper< DiscussrementushuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussrementushu, "discussrementushu")); 
		DiscussrementushuView discussrementushuView =  discussrementushuService.selectView(ew);
		return R.ok("查询热门图书评论表成功").put("data", discussrementushuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussrementushuEntity discussrementushu = discussrementushuService.selectById(id);
        return R.ok().put("data", discussrementushu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussrementushuEntity discussrementushu = discussrementushuService.selectById(id);
        return R.ok().put("data", discussrementushu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussrementushuEntity discussrementushu, HttpServletRequest request){
    	discussrementushu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussrementushu);
        discussrementushuService.insert(discussrementushu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussrementushuEntity discussrementushu, HttpServletRequest request){
    	discussrementushu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussrementushu);
        discussrementushuService.insert(discussrementushu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DiscussrementushuEntity discussrementushu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussrementushu);
        discussrementushuService.updateById(discussrementushu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussrementushuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
