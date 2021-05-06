package com.example.final_work.service.backend;

import com.example.final_work.pojo.AdPromotion;
import com.example.final_work.pojo.AppInfo;

import java.util.List;

public interface AdPromotionService {
    List<AdPromotion> getAppADinfo();
    List<AdPromotion>getAppADinfofind(AdPromotion adPromotion);
    int modifyad(AdPromotion adPromotion);
    AdPromotion getadlistnyid(int id);
    int insertad(AdPromotion adPromotion);
    int delappad(int id);
}
