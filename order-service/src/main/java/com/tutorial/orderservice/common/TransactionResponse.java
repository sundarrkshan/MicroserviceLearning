package com.tutorial.orderservice.common;

import com.tutorial.orderservice.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponse {

    public Order order;
    public String transactionID;
    public double amount;
    public String message;


}
