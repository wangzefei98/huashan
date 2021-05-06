package com.example.final_work.dao.AdPromotion;

import com.example.final_work.pojo.AdPromotion;
import com.example.final_work.pojo.AppInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Component
@Repository
public interface AdPromotionMapper {
    List<AdPromotion>getAppADinfo();
    List<AdPromotion>getAppADinfofind(AdPromotion adPromotion);
    int modifyad(AdPromotion adPromotion);
    AdPromotion getadlistnyid(int id);
    int insertad(AdPromotion adPromotion);
    int delappad(int id);
}
