package com.ustb.boot.service.impl;

import com.ustb.boot.mapper.RegionMapper;
import com.ustb.boot.pojo.Region;
import com.ustb.boot.pojo.Result;
import com.ustb.boot.service.RegionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RegionServiceImpl implements RegionService {

    @Resource
    private RegionMapper regionMapper;

    @Override
    public Result getRegionAll() {
        try {
            List<Region> list = regionMapper.selectList(null);
            return new Result(true,"查询区域信息成功",list);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "查询区域信息失败", null);
        }
    }
}
