package com.ustb.boot.service;

import com.ustb.boot.pojo.Orders;
import com.ustb.boot.pojo.Result;

public interface OrdersService {
    Result add(Orders orders);

    Result changeOrdersStatus(String ordersId, String ordersStatus);

    Result findOrdersInfoById(String ordersId);

    Result getOrdersByUserId(String userId);
}
