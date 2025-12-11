package com.ustb.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ustb.boot.pojo.Favorite;
import com.ustb.boot.pojo.Property;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FavoriteMapper extends BaseMapper<Favorite> {
    List<Property> getFavoritePropertyByUserId(String userId);

    List<Property> getFavoritePropertyByUserIdAndLikeTitle(@Param("userId") String userId,@Param("likeTitle") String likeTitle);
}
