package com.zqw.controller;
import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zqw.common.CommonMethod;
import com.zqw.common.JsonResult;
import com.zqw.common.ReJson;
import com.zqw.connecttion.MpConnecttion;
import com.zqw.entity.JsonEntity;

@Controller
@RequestMapping("/MP")
public class UserInfoController {

    /**
     * 用户查询.
     * @return
     */
    @RequestMapping("/MP10001")
    @RequiresPermissions("userInfo:view")//权限管理;
    public String userInfo(){
        return "userInfo";
    }
    /**
     * 用户添加;
     * @return
     */
    @RequestMapping("/MP10002")
    @RequiresPermissions("userInfo:add")//权限管理;
    public String userInfoAdd(){
        return "userInfoAdd";
    }

    /**
     * 用户删除;
     * @return
     */
    @RequestMapping("/MP10003")
    @RequiresPermissions("userInfo:del")//权限管理;
    public String userDel(){
        return "userInfoDel";
    }
    
    @RequestMapping("/MP10004")
    @ResponseBody
    public JsonResult test1() {
		return new JsonResult("测试成功");
 
    }
    @RequestMapping("/MP10005")
    @ResponseBody
    public JsonResult test2() {
    	Map<String, String> map=new HashMap<String,String>();
    	map.put("username", "admin");
    	String str=MpConnecttion.PostWithParas("BP", "MH0011", map);
    	JsonEntity result=ReJson.reJson(str);
    	System.out.println(result.getData());
    	if(result.getState().equals("1")) {
    		String cardNo=ReJson.toJson(result.getData());
    		cardNo=CommonMethod.tCardNo(cardNo);
    		Map<String, String> map2=new HashMap<String,String>();
        	map2.put("cardNo", cardNo);
    		return new JsonResult(map2);
    	}else {
    		return new JsonResult("MP10002",result.getMessage());	
    	}
		
    	
    }
}