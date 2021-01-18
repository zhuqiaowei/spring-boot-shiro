package com.zqw.service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.zqw.dao.UserInfoDao;
import com.zqw.entity.UserInfo;
import com.zqw.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements	UserInfoService{
	
	@Resource
	UserInfoDao userDao;

	@Override
	@Transactional
	public UserInfo findByUsername(String username) {
        System.out.println("UserInfoServiceImpl.findByUsername()");
        return userDao.findByUsername(username);

	}

}
