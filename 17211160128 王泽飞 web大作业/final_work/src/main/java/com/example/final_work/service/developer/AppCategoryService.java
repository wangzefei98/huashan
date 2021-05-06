package com.example.final_work.service.developer;



import com.example.final_work.pojo.AppCategory;

import java.util.List;

public interface AppCategoryService {
	/**
	 * 根据父节点parentId获取相应的分类列表
	 * @param parentId
	 * @return
	 * @throws Exception
	 */
	public List<AppCategory> getAppCategoryListByParentId(Integer parentId)throws Exception;
}
