package com.ustb.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ustb.boot.pojo.User;
import org.apache.ibatis.annotations.Update;

public interface UserMapper extends BaseMapper<User> {
    @Update("update t_user set user_password = #{newPassword} where user_phone = #{phone}")
    void resetPassword(String phone, String newPassword);
}
