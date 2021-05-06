package com.example.final_work.service.backend;

import com.example.final_work.pojo.AppCategory;

import java.util.List;

public interface CategoryService {
    public List<AppCategory> getAppCategoryList();
    int insertcategory(AppCategory appCategory);
    AppCategory getAppCategory(int id);
    int appcategorymodify(AppCategory appCategory);
    int deleteappcategory(int id);
    public List<AppCategory> appcategoryfind(AppCategory appCategory);
}
