package com.ustb.boot.pojo;


import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
    @TableId
    private String orderId;  // 订单ID

    private String propertyId;  // 房源ID

    private BigDecimal price;  // 价格

    private Date checkInDate;  // 入住时间

    private Date checkOutDate;  // 离开时间

    private Integer numGuests;  // 入住人数

    private String phone;  // 联系电话

    private String contactName;  // 联系人

    private String userId;  // 用户ID

    private String orderStatus;  // 订单状态
}
