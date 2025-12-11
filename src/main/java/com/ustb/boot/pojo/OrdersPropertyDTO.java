package com.ustb.boot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdersPropertyDTO extends Orders{
    private String title;
    private String address;
    private Double longitude; //经度
    private Double latitude; //维度
}
