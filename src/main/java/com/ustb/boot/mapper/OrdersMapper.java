package com.ustb.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ustb.boot.pojo.Orders;
import com.ustb.boot.pojo.OrdersPropertyDTO;

public interface OrdersMapper extends BaseMapper<Orders> {
    OrdersPropertyDTO findOrdersInfoById(String ordersId);
}
