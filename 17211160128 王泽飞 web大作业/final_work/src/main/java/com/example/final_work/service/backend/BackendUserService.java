package com.example.final_work.service.backend;


import com.example.final_work.pojo.BackendUser;

import java.util.List;

public interface BackendUserService {
	/**
	 * 用户登录
	 * @param userCode
	 * @param userPassword
	 * @return
	 */
	public BackendUser login(String userCode, String userPassword) throws Exception;
	List<BackendUser> getUserList();
    public BackendUser getUser(int id);
    int deldevuser1(int id);
    int modifyuser(BackendUser user);
    int getcount();
	int insertuser(BackendUser backendUser);
    public List<BackendUser> backuserfind(String userName);
}
