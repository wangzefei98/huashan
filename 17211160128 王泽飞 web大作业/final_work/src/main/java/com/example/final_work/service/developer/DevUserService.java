package com.example.final_work.service.developer;


import com.example.final_work.pojo.DevUser;

import java.util.List;

public interface DevUserService {
	/**
	 * 用户登录
	 * @param devCode
	 * @param devPassword
	 * @return
	 */
	public DevUser login(String devCode, String devPassword) throws Exception;
	int insert(DevUser devUser);
	DevUser getUser(int id);
    int modify(DevUser devUser);
    List<DevUser> getDevUserList();
    int updateStatus(int id);
    int updateStatus2(int id);
    int deldevuser(int id);
	List<DevUser>devfind(String devName);
}
