package com.ustb.boot.pojo;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * packageName com.xja.boot.pojo
 *
 * @author 你的名字
 * @version JDK 8
 * @className Property (此处以class为例)
 * @date 2024/10/9
 * @description TODO
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Property {
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
    @TableField(exist = false)
    private List<Facility> facilityList; //房源对应的周边配套信息
    @TableField(exist = false)
    private Region region; //房源对应的区域信息
    @TableField(exist = false)
    private List<Image> imageList; //房源对应的图片信息
    @TableField(exist = false)
    private List<Review> reviewList; //房源对应的评价信息
    @TableField(exist = false)
    private String newRegionName; // 新增的区域名称


}

