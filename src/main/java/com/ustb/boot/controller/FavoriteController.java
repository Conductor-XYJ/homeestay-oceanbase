package com.ustb.boot.controller;

import com.ustb.boot.pojo.Favorite;
import com.ustb.boot.pojo.Result;
import com.ustb.boot.service.FavoriteService;
import com.ustb.boot.service.PropertyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/favorite")
public class FavoriteController {

    @Resource
    private FavoriteService favoriteService;
    @Resource
    private PropertyService propertyService;
    //1.收藏房源
    @PostMapping("/add")
    public Result add(@RequestBody Favorite favorite) {
        return favoriteService.add(favorite);
    }
    //2.删除房源
    @DeleteMapping("/delete")
    public Result delete(@RequestBody Favorite favorite) {
        return favoriteService.delete(favorite);
    }
    //3.根据用户ID获取所有的收藏房源信息
    @GetMapping("/get-favorite-property-by-userId/{userId}")
    public Result getFavoritePropertyByUserId(@PathVariable String userId) {
        return favoriteService.getFavoritePropertyByUserId(userId);
    }
    //4.根据用户ID获取所有的收藏房源信息进行模糊查询
    @GetMapping("/get-favorite-property-by-userId-likeTitle/{userId}/{likeTitle}")
    public Result getFavoritePropertyByUserIdAndLikeTitle(@PathVariable String userId, @PathVariable String likeTitle) {
        return favoriteService.getFavoritePropertyByUserIdAndLikeTitle(userId,likeTitle);
    }
    //5.找相似
    @GetMapping("/get-property-by-regionId-likeTitle/{regionId}/{likeTitle}")
    public Result getPropertyByRegionIdAndLikeTitle(@PathVariable String regionId, @PathVariable String likeTitle) {
        return propertyService.getPropertyByRegionIdAndLikeTitle(regionId,likeTitle);
    }
}
