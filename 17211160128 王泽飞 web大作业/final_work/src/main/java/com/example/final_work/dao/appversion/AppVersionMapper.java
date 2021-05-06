package com.example.final_work.dao.appversion;


import com.example.final_work.pojo.AppVersion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Component
@Repository
public interface AppVersionMapper {
	
	public List<AppVersion> getAppVersionList(@Param("appId") Integer appId) throws Exception;
	
	public int add(AppVersion appVersion)throws Exception;
	
	public int getVersionCountByAppId(@Param("appId") Integer appId)throws Exception;
	
	public int deleteVersionByAppId(@Param("appId") Integer appId)throws Exception;
	
	public AppVersion getAppVersionById(@Param("id") Integer id)throws Exception;
	
	public int modify(AppVersion appVersion)throws Exception;
	
	public int deleteApkFile(@Param("id") Integer id)throws Exception;
}
