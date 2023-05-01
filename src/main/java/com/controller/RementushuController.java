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

import com.entity.RementushuEntity;
import com.entity.view.RementushuView;

import com.service.RementushuService;
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
 * 热门图书
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-29 15:06:11
 */
@RestController
@RequestMapping("/rementushu")
public class RementushuController {
    @Autowired
    private RementushuService rementushuService;

    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,RementushuEntity rementushu,
		HttpServletRequest request){
        EntityWrapper<RementushuEntity> ew = new EntityWrapper<RementushuEntity>();

		PageUtils page = rementushuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, rementushu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,RementushuEntity rementushu, 
		HttpServletRequest request){
        EntityWrapper<RementushuEntity> ew = new EntityWrapper<RementushuEntity>();

		PageUtils page = rementushuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, rementushu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( RementushuEntity rementushu){
       	EntityWrapper<RementushuEntity> ew = new EntityWrapper<RementushuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( rementushu, "rementushu")); 
        return R.ok().put("data", rementushuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(RementushuEntity rementushu){
        EntityWrapper< RementushuEntity> ew = new EntityWrapper< RementushuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( rementushu, "rementushu")); 
		RementushuView rementushuView =  rementushuService.selectView(ew);
		return R.ok("查询热门图书成功").put("data", rementushuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        RementushuEntity rementushu = rementushuService.selectById(id);
		rementushu.setClicknum(rementushu.getClicknum()+1);
		rementushu.setClicktime(new Date());
		rementushuService.updateById(rementushu);
        return R.ok().put("data", rementushu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        RementushuEntity rementushu = rementushuService.selectById(id);
		rementushu.setClicknum(rementushu.getClicknum()+1);
		rementushu.setClicktime(new Date());
		rementushuService.updateById(rementushu);
        return R.ok().put("data", rementushu);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        RementushuEntity rementushu = rementushuService.selectById(id);
        if(type.equals("1")) {
        	rementushu.setThumbsupnum(rementushu.getThumbsupnum()+1);
        } else {
        	rementushu.setCrazilynum(rementushu.getCrazilynum()+1);
        }
        rementushuService.updateById(rementushu);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody RementushuEntity rementushu, HttpServletRequest request){
    	rementushu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(rementushu);
        rementushuService.insert(rementushu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody RementushuEntity rementushu, HttpServletRequest request){
    	rementushu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(rementushu);
        rementushuService.insert(rementushu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody RementushuEntity rementushu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(rementushu);
        rementushuService.updateById(rementushu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        rementushuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,RementushuEntity rementushu, HttpServletRequest request,String pre){
        EntityWrapper<RementushuEntity> ew = new EntityWrapper<RementushuEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = rementushuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, rementushu), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 协同算法（按收藏推荐）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,RementushuEntity rementushu, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String inteltypeColumn = "tushufenlei";
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("userid", userId).eq("tablename", "rementushu").orderBy("addtime", false));
        List<String> inteltypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<RementushuEntity> rementushuList = new ArrayList<RementushuEntity>();
        //去重
        if(storeups!=null && storeups.size()>0) {
            for(StoreupEntity s : storeups) {
                rementushuList.addAll(rementushuService.selectList(new EntityWrapper<RementushuEntity>().eq(inteltypeColumn, s.getInteltype())));
            }
        }
        EntityWrapper<RementushuEntity> ew = new EntityWrapper<RementushuEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = rementushuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, rementushu), params), params));
        List<RementushuEntity> pageList = (List<RementushuEntity>)page.getList();
        if(rementushuList.size()<limit) {
            int toAddNum = (limit-rementushuList.size())<=pageList.size()?(limit-rementushuList.size()):pageList.size();
            for(RementushuEntity o1 : pageList) {
                boolean addFlag = true;
                for(RementushuEntity o2 : rementushuList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    rementushuList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        } else if(rementushuList.size()>limit) {
            rementushuList = rementushuList.subList(0, limit);
        }
        page.setList(rementushuList);
        return R.ok().put("data", page);
    }







}
