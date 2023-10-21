package com.tutorial.orderservice.service;

import com.tutorial.orderservice.common.Payment;
import com.tutorial.orderservice.common.TransactionRequest;
import com.tutorial.orderservice.common.TransactionResponse;
import com.tutorial.orderservice.entity.Order;
import com.tutorial.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    RestTemplate restTemplate;

    public TransactionResponse newOrder(TransactionRequest request)
    {

        String response = "";
        Order order = request.getOrder();
        Payment payment = request.getPayment();

        payment.setOrderId(order.getId());
        payment.setAmount( order.getPrice());

       Payment paymentResponse= restTemplate.postForObject("http://Payment-Service:8086/payment/doPayment",payment,Payment.class);

        response = paymentResponse.getPaymentStatus().equals("Success")?"Succefully paid and Order placed":"Payment failed";
         orderRepository.save(order);
        return new TransactionResponse(order,paymentResponse.getTransactionID(),paymentResponse.getAmount(),response);
    }
}
