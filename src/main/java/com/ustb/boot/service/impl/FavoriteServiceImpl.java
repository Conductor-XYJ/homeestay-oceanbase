package com.ustb.boot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ustb.boot.mapper.FavoriteMapper;
import com.ustb.boot.pojo.Favorite;
import com.ustb.boot.pojo.Property;
import com.ustb.boot.pojo.Result;
import com.ustb.boot.service.FavoriteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FavoriteServiceImpl implements FavoriteService {
    @Resource
    private FavoriteMapper favoriteMapper;
    @Override
    public Result add(Favorite favorite) {
        favoriteMapper.insert(favorite);
        return new Result(true,"收藏成功",null);
    }

    @Override
    public Result delete(Favorite favorite) {
        QueryWrapper<Favorite> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", favorite.getUserId());
        wrapper.eq("property_id", favorite.getPropertyId());
        favoriteMapper.delete(wrapper);
        return new Result(true,"取消收藏成功",null);
    }

    @Override
    public Result getFavoritePropertyByUserId(String userId) {
        List<Property> list = favoriteMapper.getFavoritePropertyByUserId(userId);
        return new Result(true,"获取收藏房源信息成功",list);
    }

    @Override
    public Result getFavoritePropertyByUserIdAndLikeTitle(String userId, String likeTitle) {
        likeTitle = "%" + likeTitle + "%";
        List<Property> list = favoriteMapper.getFavoritePropertyByUserIdAndLikeTitle(userId,likeTitle);

        return new Result(true,"获取收藏房源信息成功",list);
    }

}
