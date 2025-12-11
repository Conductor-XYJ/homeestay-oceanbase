package com.ustb.boot.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyRatingDTO {
    @TableId
    private String propertyId;      // 房源编号
    private String title;           // 标题
    private String address;         // 地址
    private Double deposit;         // 押金
    private Double rent;            // 租金
    private String regionId;          // 地方区域编号
    private String rentalType;      // 租房类型（日租/月租）
    private String description;     // 详细说明
    private String userId;          // 所属用户编号
    private Integer capacity;     // 可接待人数
    private Integer bedrooms;   // 卧室数量
    private Integer beds;       // 床位数量
    private Integer bathrooms;  // 卫生间数量
    private Double area;            // 面积
    private Double longitude; //经度
    private Double latitude; //维度

    private Double rating; //房源的评价的平均分
}
