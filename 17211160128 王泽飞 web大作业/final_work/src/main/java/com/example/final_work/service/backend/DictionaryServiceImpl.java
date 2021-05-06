package com.example.final_work.service.backend;

import com.example.final_work.dao.datadictionary.DataDictionaryMapper;
import com.example.final_work.pojo.DataDictionary;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class DictionaryServiceImpl implements DictionaryService {
    @Resource
    private DataDictionaryMapper mapper;
    @Override
    public List<DataDictionary> getDictionaryList() {
        return mapper.getDictionaryList();
    }

    @Override
    public int modifydata(DataDictionary dataDictionary) {
        return mapper.modifydata(dataDictionary);
    }

    @Override
    public DataDictionary getdatabyid(int id) {
        return mapper.getdatabyid(id);
    }

    @Override
    public int insertdata(DataDictionary dataDictionary) {
        return mapper.insertdata(dataDictionary);
    }

    @Override
    public List<DataDictionary> finddata(DataDictionary dataDictionary) {
        return mapper.finddata(dataDictionary);
    }
}
