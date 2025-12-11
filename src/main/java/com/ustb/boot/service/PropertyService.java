package com.ustb.boot.service;

import com.ustb.boot.pojo.Property;
import com.ustb.boot.pojo.Result;
import org.apache.ibatis.annotations.Param;

public interface PropertyService {
    Result addProperty(Property property);

    Result getPropertyByUserId(String userId);

    Result getPropertyByUserIdAndTitleName(String userId, String titleName);

    Result getPropertyAndRatingByReginId(String reginId);

    Result getPropertyAndRatingAllByReginId(String reginId);

    Result getPropertyByRegionIdAndLikeTitle(String regionId, String likeTitle);

    Result getPropertyByPropertyId(String propertyId);

    Result getNearProperty(@Param("longitude") double longitude, double latitude, double radiusKm);
}
