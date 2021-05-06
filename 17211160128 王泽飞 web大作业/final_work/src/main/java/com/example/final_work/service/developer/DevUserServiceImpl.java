package com.example.final_work.service.developer;


import com.example.final_work.dao.devuser.DevUserMapper;
import com.example.final_work.pojo.DevUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DevUserServiceImpl implements DevUserService {
	@Resource
	private DevUserMapper mapper;
	@Override
	public DevUser login(String devCode, String devPassword) throws Exception {
		// TODO Auto-generated method stub
		DevUser user = null;
		user = mapper.getLoginUser(devCode);
		//匹配密码
		if(null != user){
			if(!user.getDevPassword().equals(devPassword))
				user = null;
		}
		return user;
	}

	@Override
	public int insert(DevUser devUser) {
		return mapper.insert(devUser);
	}

	@Override
	public DevUser getUser(int id) {
		return mapper.getUser(id);
	}

    @Override
    public int modify(DevUser devUser) {
        return mapper.modify(devUser);
    }

	@Override
	public List<DevUser> getDevUserList() {
		return mapper.getDevUserList();
	}

	@Override
	public int updateStatus(int id) {
		return mapper.updateStatus(id);
	}

	@Override
	public int updateStatus2(int id) {
		return mapper.updateStatus2(id);
	}

	@Override
	public int deldevuser(int id) {
		return mapper.deldevuser(id);
	}

	@Override
	public List<DevUser> devfind(String devName) {
		return mapper.devfind(devName);
	}

}
