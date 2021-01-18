package com.zqw;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zqw.dao.UserInfoDao;
import com.zqw.entity.SysPermission;
import com.zqw.entity.SysRole;
import com.zqw.entity.UserInfo;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootShiroApplicationTests {

	@Resource
	UserInfoDao dao;
	

	
	@Test
	public void contextLoads() {
		
	}
	

}
