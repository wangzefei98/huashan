package com.example.final_work.service.backend;

import com.example.final_work.dao.AdPromotion.AdPromotionMapper;
import com.example.final_work.pojo.AdPromotion;
import com.example.final_work.pojo.AppInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdPromotionServiceImpl implements AdPromotionService{

    @Resource
    private AdPromotionMapper mapper;

    @Override
    public List<AdPromotion> getAppADinfo() {
        return mapper.getAppADinfo();
    }

    @Override
    public List<AdPromotion> getAppADinfofind(AdPromotion adPromotion) {
        return mapper.getAppADinfofind(adPromotion);
    }


    @Override
    public int modifyad(AdPromotion adPromotion) {
        return mapper.modifyad(adPromotion);
    }

    @Override
    public AdPromotion getadlistnyid(int id) {
        return mapper.getadlistnyid(id);
    }

    @Override
    public int insertad(AdPromotion adPromotion) {
        return mapper.insertad(adPromotion);
    }

    @Override
    public int delappad(int id) {
        return mapper.delappad(id);
    }
}
