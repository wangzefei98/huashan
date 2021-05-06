package com.example.final_work.service.backend;

import com.example.final_work.dao.appcategory.AppCategoryMapper;
import com.example.final_work.pojo.AppCategory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Resource
    private AppCategoryMapper categoryMapper;

    @Override
    public List<AppCategory> getAppCategoryList() {
        return categoryMapper.getAppCategoryList();
    }

    @Override
    public int insertcategory(AppCategory appCategory) {
        return categoryMapper.insertcategory(appCategory);
    }

    @Override
    public AppCategory getAppCategory(int id) {
        return categoryMapper.getAppCategory(id);
    }

    @Override
    public int appcategorymodify(AppCategory appCategory) {
        return categoryMapper.appcategorymodify(appCategory);
    }

    @Override
    public int deleteappcategory(int id) {
        return categoryMapper.deleteappcategory(id);
    }

    @Override
    public List<AppCategory> appcategoryfind(AppCategory appCategory) {
        return categoryMapper.appcategoryfind(appCategory);
    }
}
