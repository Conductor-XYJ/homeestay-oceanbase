package com.ustb.boot.controller;

import com.ustb.boot.pojo.Orders;
import com.ustb.boot.pojo.Result;
import com.ustb.boot.service.OrdersService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {
    @Resource
    private OrdersService ordersService;

    @PostMapping("/add")
    public Result add(@RequestBody Orders orders) {
        return ordersService.add(orders);
    }

    @PutMapping("/change-orders-status/{ordersId}/{ordersStatus}")
    public Result changeOrdersStatus(@PathVariable("ordersId") String ordersId, @PathVariable("ordersStatus") String ordersStatus) {
        return ordersService.changeOrdersStatus(ordersId,ordersStatus);
    }

    @GetMapping("/find-orders-info-by-id/{ordersId}")
    public Result findOrdersInfoById(@PathVariable("ordersId") String ordersId) {
        return ordersService.findOrdersInfoById(ordersId);
    }

    @GetMapping("/get-orders-by-userid/{userId}")
    public Result getOrdersByUserId(@PathVariable("userId") String userId) {
        return ordersService.getOrdersByUserId(userId);
    }
}
