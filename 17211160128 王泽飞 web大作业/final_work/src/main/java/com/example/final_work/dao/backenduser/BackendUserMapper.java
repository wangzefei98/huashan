package com.example.final_work.dao.backenduser;


import com.example.final_work.pojo.BackendUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Component
@Repository
public interface BackendUserMapper {

	/**
	 * 通过userCode获取User
	 * @param userCode
	 * @return
	 * @throws Exception
	 */
	public BackendUser getLoginUser(@Param("userCode") String userCode)throws Exception;
	public BackendUser getUser(int id);
	public List<BackendUser> backuserfind(String userName);
	List<BackendUser>getUserList();
	int deldevuser1(int id);
	int modifyuser(BackendUser user);
    int getcount();
    int insertuser(BackendUser backendUser);

}
