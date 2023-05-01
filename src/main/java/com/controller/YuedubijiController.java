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

import com.entity.YuedubijiEntity;
import com.entity.view.YuedubijiView;

import com.service.YuedubijiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 阅读笔记
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-29 15:06:11
 */
@RestController
@RequestMapping("/yuedubiji")
public class YuedubijiController {
    @Autowired
    private YuedubijiService yuedubijiService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YuedubijiEntity yuedubiji,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date bijiriqistart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date bijiriqiend,
		HttpServletRequest request){
    	if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
    		yuedubiji.setUserid((Long)request.getSession().getAttribute("userId"));
    	}
        EntityWrapper<YuedubijiEntity> ew = new EntityWrapper<YuedubijiEntity>();
                if(bijiriqistart!=null) ew.ge("bijiriqi", bijiriqistart);
                if(bijiriqiend!=null) ew.le("bijiriqi", bijiriqiend);

		PageUtils page = yuedubijiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuedubiji), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YuedubijiEntity yuedubiji, 
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date bijiriqistart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date bijiriqiend,
		HttpServletRequest request){
    	if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
    		yuedubiji.setUserid((Long)request.getSession().getAttribute("userId"));
    	}
        EntityWrapper<YuedubijiEntity> ew = new EntityWrapper<YuedubijiEntity>();
                if(bijiriqistart!=null) ew.ge("bijiriqi", bijiriqistart);
                if(bijiriqiend!=null) ew.le("bijiriqi", bijiriqiend);

		PageUtils page = yuedubijiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuedubiji), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YuedubijiEntity yuedubiji){
       	EntityWrapper<YuedubijiEntity> ew = new EntityWrapper<YuedubijiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yuedubiji, "yuedubiji")); 
        return R.ok().put("data", yuedubijiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YuedubijiEntity yuedubiji){
        EntityWrapper< YuedubijiEntity> ew = new EntityWrapper< YuedubijiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yuedubiji, "yuedubiji")); 
		YuedubijiView yuedubijiView =  yuedubijiService.selectView(ew);
		return R.ok("查询阅读笔记成功").put("data", yuedubijiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YuedubijiEntity yuedubiji = yuedubijiService.selectById(id);
        return R.ok().put("data", yuedubiji);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YuedubijiEntity yuedubiji = yuedubijiService.selectById(id);
        return R.ok().put("data", yuedubiji);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YuedubijiEntity yuedubiji, HttpServletRequest request){
    	yuedubiji.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yuedubiji);
    	yuedubiji.setUserid((Long)request.getSession().getAttribute("userId"));
        yuedubijiService.insert(yuedubiji);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YuedubijiEntity yuedubiji, HttpServletRequest request){
    	yuedubiji.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yuedubiji);
    	yuedubiji.setUserid((Long)request.getSession().getAttribute("userId"));
        yuedubijiService.insert(yuedubiji);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YuedubijiEntity yuedubiji, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yuedubiji);
        yuedubijiService.updateById(yuedubiji);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yuedubijiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
