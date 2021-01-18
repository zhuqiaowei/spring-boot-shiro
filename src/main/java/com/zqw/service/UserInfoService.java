package com.zqw.service;

import com.zqw.entity.UserInfo;

public interface UserInfoService {
	public UserInfo findByUsername(String username);
}
