package com.zqw.controller;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zqw.common.CommonMethod;
import com.zqw.common.JsonResult;
import com.zqw.common.ReJson;
import com.zqw.connecttion.MpConnecttion;
import com.zqw.entity.JsonEntity;
import com.zqw.entity.UserInfo;
import com.zqw.service.UserInfoService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Controller
public class HomeController {
	
	@Resource
	UserInfoService userInfoService;
	
    @RequestMapping({"/","/index"})
    @ResponseBody
    public JsonResult index(HttpServletRequest request){
    	String sid="";
    	Random rand=new Random();//生成随机数
        for(int a=0;a<12;a++){
        	sid+=rand.nextInt(10);//生成6位验证码
        }
        Map<String, String> maps=new HashMap<String,String>();
        System.out.println("生成Sid："+sid);
        request.getSession().setAttribute("sid", sid);
        System.out.println("保存用户信息到session>>>>>>>>");
        UserInfo userInfo = userInfoService.findByUsername("admin");
        request.getSession().setAttribute("userInfo", userInfo);
        //获取卡号并加密MD5
        Map<String, String> map=new HashMap<String,String>();
    	map.put("username", "admin");
        String str=MpConnecttion.PostWithParas("BP", "MH0011", map);
    	JsonEntity result=ReJson.reJson(str);
    	System.out.println(result.getData());
    	String cardNo = null;
    	if(result.getState().equals("1")) {
    		cardNo=ReJson.toJson(result.getData());
    		System.out.println("对卡号"+cardNo+"进行MD5加密为：574162810e47e71d11dbcceb145da6f1");
    		cardNo=CommonMethod.tCardNo(cardNo);
    		System.out.println("脱敏为："+cardNo);
    	}
        maps.put("sid", sid);
        maps.put("cardNo", cardNo);
        maps.put("cardNo_sequence", "574162810e47e71d11dbcceb145da6f1");
        maps.put("returnCode", "MP10001");
        maps.put("returnMsg", "登录成功");
        return new JsonResult(maps);
    }
    @RequestMapping("/login")
    public JsonResult login(HttpServletRequest request, Map<String, Object> map) throws Exception{
        System.out.println("用户执行登录>>>>>>>>>>>>>>>");
        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        String exception = (String) request.getAttribute("shiroLoginFailure");
        System.out.println("exception=" + exception);
        String msg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                System.out.println("UnknownAccountException -- > 账号不存在：");
                msg = "UnknownAccountException -- > 账号不存在：";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                System.out.println("IncorrectCredentialsException -- > 密码不正确：");
                msg = "IncorrectCredentialsException -- > 密码不正确：";
            } else if ("kaptchaValidateFailed".equals(exception)) {
                System.out.println("kaptchaValidateFailed -- > 验证码错误");
                msg = "kaptchaValidateFailed -- > 验证码错误";
            } else {
                msg = "else >> "+exception;
                System.out.println("else -- >" + exception);
            }
        }
        map.put("msg", msg);
        // 此方法不处理登录成功,由shiro进行处理
        return new JsonResult();
    }

    @RequestMapping("/403")
    public String unauthorizedRole(){
        System.out.println("------没有权限-------");
        return "403";
    }

}