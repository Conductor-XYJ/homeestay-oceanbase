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
 * @className Area (此处以class为例)
 * @date 2024/10/9
 * @description TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Region {
    @TableId
    private String regionId;          // 地方区域编号
    private String regionName;        // 地区名
}