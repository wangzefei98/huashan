package com.example.final_work.service.backend;

import com.example.final_work.pojo.DataDictionary;

import java.util.List;

public interface DictionaryService {
    public List<DataDictionary> getDictionaryList();
    int modifydata(DataDictionary dataDictionary);
    DataDictionary getdatabyid(int id);
    int insertdata(DataDictionary dataDictionary);
    public List<DataDictionary> finddata(DataDictionary dataDictionary);
}
