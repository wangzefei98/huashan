package com.example.final_work.dao.appcategory;


import com.alibaba.fastjson.support.odps.udf.CodecCheck;
import com.example.final_work.pojo.AppCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Component
@Repository
public interface AppCategoryMapper {
	
	public List<AppCategory> getAppCategoryListByParentId(@Param("parentId") Integer parentId)throws Exception;
	public List<AppCategory> getAppCategoryList();
	public List<AppCategory> appcategoryfind(AppCategory appCategory);
	int insertcategory(AppCategory appCategory);
	AppCategory getAppCategory(int id);
	int appcategorymodify(AppCategory appCategory);
	int deleteappcategory(int id);

}
