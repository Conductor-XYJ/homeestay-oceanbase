package com.ustb.boot.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * packageName com.xja.boot.pojo
 *
 * @author 你的名字
 * @version JDK 8
 * @className Review (此处以class为例)
 * @date 2024/10/9
 * @description TODO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    private String reviewId;        // 评价编号
    private String userId;          // 用户编号
    private String propertyId;      // 房源编号
    private String content;         // 评价内容
    private Integer rating;          // 评分

    @TableField(exist = false)
    private String reviewUserName;
}