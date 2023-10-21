package com.tutorial.orderservice.controller;

import com.tutorial.orderservice.common.Payment;
import com.tutorial.orderservice.common.TransactionRequest;
import com.tutorial.orderservice.common.TransactionResponse;
import com.tutorial.orderservice.entity.Order;
import com.tutorial.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;


    @PostMapping("/createOrders")
    public TransactionResponse createNewOder(@RequestBody TransactionRequest request)
    {
        return orderService.newOrder(request);
    }
}
