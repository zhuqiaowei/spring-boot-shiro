package com.zqw.inteceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInceptor implements HandlerInterceptor{
	
	/*
	 * 进入方法前执行
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		System.out.println("前置拦截器执行>>>>>>>>>>>");
		HttpSession session=request.getSession();
		String s_sid=(String) session.getAttribute("sid");
		System.out.println("s_sid:"+s_sid);
		String sid=(String) request.getParameter("sid");
		System.out.println("sid:"+sid);
		if(s_sid.equals(sid)) {
			System.out.println("sid匹配成功！");
			System.out.println("前置拦截器结束>>>>>>>>>>>");
			return true;
		}else{
			System.out.println("sid匹配失败！");
			System.out.println("前置拦截器结束>>>>>>>>>>>");
			throw new RuntimeException("login time out");
		}
		
	}

	/*
	 * 方法执行后
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView modelAndView)
			throws Exception {
		System.out.println("后置1拦截器执行");
		if (null != modelAndView && null != modelAndView.getModel()) {
			Object obj=modelAndView.getModel().get("data");
			if (null != obj) {
				String str=(String) obj;
				System.out.println(str);
			}
		}
	}
	/*
	 * 请求结束后
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("后置2拦截器执行");
		
	}

	

}
