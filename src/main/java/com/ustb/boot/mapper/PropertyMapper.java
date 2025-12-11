package com.ustb.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ustb.boot.pojo.Property;
import com.ustb.boot.pojo.PropertyRatingDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PropertyMapper extends BaseMapper<Property> {
    List<PropertyRatingDTO> getPropertyAndRatingByReginId(String reginId);

    List<PropertyRatingDTO> getPropertyAndRatingAllByReginId(String reginId);

    Property getPropertyByPropertyId(String propertyId);

    @Select(
            "SELECT *, " +
                    "(6371 * acos(cos(radians(#{latitude})) * cos(radians(latitude)) * cos(radians(longitude) - radians(#{longitude})) + sin(radians(#{latitude})) * sin(radians(latitude)))) AS distance " +
                    "FROM t_property " +
                    "HAVING distance < #{radiusKm} " +
                    "ORDER BY distance ASC"
    )

    List<Property> getNearProperty(@Param("longitude") double longitude,@Param("latitude") double latitude,@Param("radiusKm") double radiusKm);

    //List<Property> getPropertyByRegionIdAndLikeTitle(@Param("regionId") String regionId,@Param("likeTitle") String likeTitle);
}
