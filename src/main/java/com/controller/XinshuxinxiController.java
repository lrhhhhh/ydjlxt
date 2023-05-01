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

import com.entity.XinshuxinxiEntity;
import com.entity.view.XinshuxinxiView;

import com.service.XinshuxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 新书信息
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-29 15:06:11
 */
@RestController
@RequestMapping("/xinshuxinxi")
public class XinshuxinxiController {
    @Autowired
    private XinshuxinxiService xinshuxinxiService;

    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XinshuxinxiEntity xinshuxinxi,
		HttpServletRequest request){
        EntityWrapper<XinshuxinxiEntity> ew = new EntityWrapper<XinshuxinxiEntity>();

		PageUtils page = xinshuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xinshuxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XinshuxinxiEntity xinshuxinxi, 
		HttpServletRequest request){
        EntityWrapper<XinshuxinxiEntity> ew = new EntityWrapper<XinshuxinxiEntity>();

		PageUtils page = xinshuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xinshuxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XinshuxinxiEntity xinshuxinxi){
       	EntityWrapper<XinshuxinxiEntity> ew = new EntityWrapper<XinshuxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xinshuxinxi, "xinshuxinxi")); 
        return R.ok().put("data", xinshuxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XinshuxinxiEntity xinshuxinxi){
        EntityWrapper< XinshuxinxiEntity> ew = new EntityWrapper< XinshuxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xinshuxinxi, "xinshuxinxi")); 
		XinshuxinxiView xinshuxinxiView =  xinshuxinxiService.selectView(ew);
		return R.ok("查询新书信息成功").put("data", xinshuxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XinshuxinxiEntity xinshuxinxi = xinshuxinxiService.selectById(id);
        return R.ok().put("data", xinshuxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XinshuxinxiEntity xinshuxinxi = xinshuxinxiService.selectById(id);
        return R.ok().put("data", xinshuxinxi);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        XinshuxinxiEntity xinshuxinxi = xinshuxinxiService.selectById(id);
        if(type.equals("1")) {
        	xinshuxinxi.setThumbsupnum(xinshuxinxi.getThumbsupnum()+1);
        } else {
        	xinshuxinxi.setCrazilynum(xinshuxinxi.getCrazilynum()+1);
        }
        xinshuxinxiService.updateById(xinshuxinxi);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XinshuxinxiEntity xinshuxinxi, HttpServletRequest request){
    	xinshuxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xinshuxinxi);
        xinshuxinxiService.insert(xinshuxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XinshuxinxiEntity xinshuxinxi, HttpServletRequest request){
    	xinshuxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xinshuxinxi);
        xinshuxinxiService.insert(xinshuxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XinshuxinxiEntity xinshuxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xinshuxinxi);
        xinshuxinxiService.updateById(xinshuxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xinshuxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
