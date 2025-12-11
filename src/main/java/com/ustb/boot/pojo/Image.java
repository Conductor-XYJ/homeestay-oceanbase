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
 * @className Image (此处以class为例)
 * @date 2024/10/9
 * @description TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    @TableId
    private String imageId;         // 图片编号
    private String imageUrl;        // 图片地址
}