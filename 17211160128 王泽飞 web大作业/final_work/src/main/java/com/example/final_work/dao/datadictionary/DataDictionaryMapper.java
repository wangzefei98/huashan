package com.example.final_work.dao.datadictionary;


import com.example.final_work.pojo.DataDictionary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Component
@Repository
public interface DataDictionaryMapper {
	
	public List<DataDictionary> getDataDictionaryList(@Param("typeCode") String typeCode)throws Exception;
	public List<DataDictionary> getDictionaryList();
	int modifydata(DataDictionary dataDictionary);
	DataDictionary getdatabyid(int id);
    int insertdata(DataDictionary dataDictionary);
    public List<DataDictionary> finddata(DataDictionary dataDictionary);

}
