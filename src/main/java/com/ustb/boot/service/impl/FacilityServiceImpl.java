package com.ustb.boot.service.impl;

import com.ustb.boot.mapper.FacilityMapper;
import com.ustb.boot.pojo.Facility;
import com.ustb.boot.pojo.Result;
import com.ustb.boot.service.FacilityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FacilityServiceImpl implements FacilityService {
    @Resource
    private FacilityMapper facilityMapper;

    @Override
    public Result getFacilityAll() {
        try {
            List<Facility> list = facilityMapper.selectList(null);
            return new Result(true,"查询周边配置成功",list);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "查询周边配置失败", null);
        }
    }
}
