package com.zqw.dao;
import org.springframework.data.repository.CrudRepository;

import com.zqw.entity.UserInfo;

public interface UserInfoDao extends CrudRepository<UserInfo,Long>{
	public UserInfo findByUsername(String username);
}
	