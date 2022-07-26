package org.gen.springboot.service;

import org.gen.springboot.bean.User;
import org.gen.springboot.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	UserMapper userMapper;

	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

	
	public User getUserById(Integer id) {
//		LOGGER.debug("debug log test......");
//		LOGGER.info("info log test......");
//		LOGGER.error("error log test......");
//		System.out.println("get...");
        return userMapper.Sel(id);
	}

	public void deleteUserById(Integer id) {
		int i = 1 / 0;
		System.out.println("delete...");
	}
}
