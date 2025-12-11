package com.ustb.boot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ustb.boot.mapper.*;
import com.ustb.boot.pojo.*;
import com.ustb.boot.service.PropertyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Resource
    private PropertyMapper propertyMapper;
    @Resource
    private PropertyFacilityMapper propertyFacilityMapper;
    @Resource
    private ImageMapper imageMapper;
    @Resource
    private PropertyImageMapper propertyImageMapper;
    @Resource
    private RegionMapper regionMapper;

    @Override
    public Result addProperty(Property property) {
        // 处理新增区域
        if ((property.getRegionId() == null || property.getRegionId().isEmpty()) 
                && property.getNewRegionName() != null && !property.getNewRegionName().isEmpty()) {
            Region region = new Region();
            region.setRegionName(property.getNewRegionName());
            regionMapper.insert(region);
            property.setRegionId(region.getRegionId());
        }

        //把房屋的基本信息存储到数据库中
        propertyMapper.insert(property);
        //和周边配套信息建立连接
        for (Facility facility : property.getFacilityList()) {
            PropertyFacility propertyFacility = new PropertyFacility(property.getPropertyId(), facility.getFacilityId());
            propertyFacilityMapper.insert(propertyFacility);
        }
        //图片入库
        for (Image image : property.getImageList()) {
            imageMapper.insert(image);//图片的阿里云oss路径存储到数据库中
            PropertyImage propertyImage = new PropertyImage();
            propertyImage.setPropertyId(property.getPropertyId());
            propertyImage.setImageId(image.getImageId());
            propertyImageMapper.insert(propertyImage);
        }


        return new Result(true,"添加房源成功",property.getPropertyId());
    }

    @Override
    public Result getPropertyByUserId(String userId) {
        QueryWrapper<Property> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId);
        List<Property> list = propertyMapper.selectList(wrapper);
        return new Result(true,"根据用户ID查询房源基本信息成功",list);
    }

    @Override
    public Result getPropertyByUserIdAndTitleName(String userId, String titleName) {
        QueryWrapper<Property> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId)
                .like("title",titleName);
        List<Property> list = propertyMapper.selectList(wrapper);
        return new Result(true,"根据用户ID和房源标题查询房源基本信息成功",list);
    }

    @Override
    public Result getPropertyAndRatingByReginId(String reginId) {
        List<PropertyRatingDTO> list = propertyMapper.getPropertyAndRatingByReginId(reginId);

        return new Result(true,"获取房源基本信息和评分成功",list);
    }

    @Override
    public Result getPropertyAndRatingAllByReginId(String reginId) {
        List<PropertyRatingDTO> list = propertyMapper.getPropertyAndRatingAllByReginId(reginId);

        return new Result(true,"获取房源基本信息和评分成功",list);
    }

    @Override
    public Result getPropertyByRegionIdAndLikeTitle(String regionId, String likeTitle) {
        QueryWrapper<Property> wrapper = new QueryWrapper<>();
        wrapper.eq("region_id", regionId)
                .like("title",likeTitle);
        List<Property> list = propertyMapper.selectList(wrapper);
        return new Result(true,"获取房源基本信息成功",list);
    }

    @Override
    public Result getPropertyByPropertyId(String propertyId) {
        Property property = propertyMapper.getPropertyByPropertyId(propertyId);
        return new Result(true,"获取房源详细信息成功",property);
    }

    @Override
    public Result getNearProperty(double longitude, double latitude, double radiusKm) {
        List<Property> list = propertyMapper.getNearProperty(longitude,latitude,radiusKm);
        return new Result(true,"获取"+radiusKm+"公里内的房源成功",list);
    }
}
