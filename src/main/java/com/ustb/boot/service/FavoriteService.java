package com.ustb.boot.service;

import com.ustb.boot.pojo.Favorite;
import com.ustb.boot.pojo.Result;

public interface FavoriteService {
    Result add(Favorite favorite);

    Result delete(Favorite favorite);

    Result getFavoritePropertyByUserId(String userId);

    Result getFavoritePropertyByUserIdAndLikeTitle(String userId, String likeTitle);
}
