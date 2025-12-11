package com.ustb.boot.controller;

import com.ustb.boot.pojo.Property;
import com.ustb.boot.pojo.Result;
import com.ustb.boot.service.PropertyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/property")
public class PropertyController {

    @Resource
    private PropertyService propertyService;

    @PostMapping("/add-property")
    public Result addProperty(@RequestBody Property property) {
        return propertyService.addProperty(property);

    }

    @GetMapping("/get-property-by-userid/{userId}")
    public Result getPropertyByUserId(@PathVariable String userId) {
        return propertyService.getPropertyByUserId(userId);
    }

    @GetMapping("/get-property-by-userid-title/{userId}/{titleName}")
    public Result getPropertyByUserIdAndTitleName(@PathVariable String userId, @PathVariable String titleName) {
        return propertyService.getPropertyByUserIdAndTitleName(userId,titleName);
    }

    //根据热门目的地获取房源的基本信息和评价平均分
    @GetMapping("/get-property-rating-by-reginId/{reginId}")
    public Result getPropertyAndRatingByReginId(@PathVariable String reginId) {
        return propertyService.getPropertyAndRatingByReginId(reginId);
    }

    //根据热门目的地获取房源的基本信息和评价平均分
    @GetMapping("/get-property-rating-all-by-reginId/{reginId}")
    public Result getPropertyAndRatingAllByReginId(@PathVariable String reginId) {
        return propertyService.getPropertyAndRatingAllByReginId(reginId);
    }

    //根据房源ID获取房源的详细信息（周边配套，房源图片，评价）
    @GetMapping("/get-property-info-by-id/{propertyId}")
    public Result getPropertyByPropertyId(@PathVariable String propertyId) {
        return propertyService.getPropertyByPropertyId(propertyId);
    }

    //附近房源
    @GetMapping("/near/{longitude}/{latitude}/{radiusKm}")
    public Result getNearProperty(@PathVariable double longitude, @PathVariable double latitude, @PathVariable double radiusKm) {
        return propertyService.getNearProperty(longitude,latitude,radiusKm);
    }
}
