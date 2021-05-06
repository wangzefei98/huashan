package com.example.final_work.dao.devuser;


import com.example.final_work.pojo.DevUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Component
@Repository
public interface DevUserMapper {
	/**
	 * 通过userCode获取User
	 * @param userCode
	 * @return
	 * @throws Exception
	 */
	public DevUser getLoginUser(@Param("devCode") String devCode)throws Exception;
	int insert(DevUser devUser);
	DevUser getUser(int id);
	int modify(DevUser devUser);

	List<DevUser>getDevUserList();
	List<DevUser>devfind(String devName);
	int updateStatus(int id);
	int updateStatus2(int id);
	int deldevuser(int id);
}
