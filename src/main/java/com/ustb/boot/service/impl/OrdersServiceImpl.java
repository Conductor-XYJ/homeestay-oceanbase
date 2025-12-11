package com.ustb.boot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.ustb.boot.mapper.OrdersMapper;
import com.ustb.boot.pojo.Orders;
import com.ustb.boot.pojo.OrdersPropertyDTO;
import com.ustb.boot.pojo.Result;
import com.ustb.boot.service.OrdersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Resource
    private OrdersMapper ordersMapper;

    @Override
    public Result add(Orders orders) {
        orders.setOrderStatus("未支付");
        ordersMapper.insert(orders);
        return new Result(true,"预约成功",orders.getOrderId());
    }

    @Override
    public Result changeOrdersStatus(String ordersId, String ordersStatus) {
        UpdateWrapper<Orders> wrapper = new UpdateWrapper<>();
        wrapper.set("order_status", ordersStatus)
                .eq("order_id", ordersId);
        ordersMapper.update(wrapper);
        return new Result(true,"订单状态修改成功",ordersId);
    }

    @Override
    public Result findOrdersInfoById(String ordersId) {
        OrdersPropertyDTO ordersPropertyDTO = ordersMapper.findOrdersInfoById(ordersId);
        return new Result(true,"获取订单信息成功",ordersPropertyDTO);
    }

    @Override
    public Result getOrdersByUserId(String userId) {
        QueryWrapper<Orders> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId);
        return new Result(true, "获取用户订单列表成功", ordersMapper.selectList(wrapper));
    }
}
