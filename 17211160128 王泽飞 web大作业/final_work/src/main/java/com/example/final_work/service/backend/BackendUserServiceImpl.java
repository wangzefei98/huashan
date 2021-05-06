package com.example.final_work.service.backend;


import com.example.final_work.dao.backenduser.BackendUserMapper;
import com.example.final_work.pojo.BackendUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BackendUserServiceImpl implements BackendUserService {
	@Resource
	private BackendUserMapper mapper;
	
	@Override
	public BackendUser login(String userCode, String userPassword) throws Exception {
		// TODO Auto-generated method stub
		BackendUser user = null;
		user = mapper.getLoginUser(userCode);
		//匹配密码
		if(null != user){
			if(!user.getUserPassword().equals(userPassword))
				user = null;
		}
		return user;
	}

	@Override
	public List<BackendUser> getUserList() {
		return mapper.getUserList();
	}

	@Override
	public BackendUser getUser(int id) {
		return mapper.getUser(id);
	}

	@Override
	public int deldevuser1(int id) {
		return mapper.deldevuser1(id);
	}

	@Override
	public int modifyuser(BackendUser user) {
		return mapper.modifyuser(user);
	}

	@Override
	public int getcount() {
		return mapper.getcount();
	}

	@Override
	public int insertuser(BackendUser backendUser) {
		return mapper.insertuser(backendUser);
	}

	@Override
	public List<BackendUser> backuserfind(String userName) {
		return mapper.backuserfind(userName);
	}


}
