package com.tutorial.orderservice.common;

import com.tutorial.orderservice.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRequest {

    public Order order;
    public Payment payment;
}
