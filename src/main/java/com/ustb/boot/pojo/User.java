package com.ustb.boot.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * packageName com.xja.boot.pojo
 *
 * @author 你的名字
 * @version JDK 8
 * @className User (此处以class为例)
 * @date 2024/10/8
 * @description TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @TableId
    private String userId;
    private String userName;
    private String userPassword;
    private String userGender;
    private String userPhone;
    private String userCardId;
    private String userHobby;
    private String userAddress;
    private String userOccupation;
}
