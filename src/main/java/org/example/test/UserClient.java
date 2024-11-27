package org.example.test;

import org.example.test.dto.PayRequest;
import org.example.test.dto.PayResponse;
import org.example.test.service.ConveniencePayService;
import org.example.test.service.PayCancelRequest;
import org.example.test.service.PayCancelResponse;
import org.example.test.type.ConvenienceType;
import org.example.test.type.PayMethodType;

// 사용자
public class UserClient {
    public static void main(String[] args) {
        ConveniencePayService conveniencePayService = new ConveniencePayService();

        // 결제 : G25, 1000 원
        PayRequest payRequest = new PayRequest(PayMethodType.MONEY, ConvenienceType.G25, 1000);
        PayResponse payResponse = conveniencePayService.pay(payRequest);
        System.out.println("payResponse = " + payResponse);

        // 취소 : G25, 500 원
        PayCancelRequest payCancelRequest = new PayCancelRequest(PayMethodType.MONEY, ConvenienceType.G25, 500);
        PayCancelResponse payCancelResponse = conveniencePayService.payCancel(payCancelRequest);
        System.out.println("payCancelResponse = " + payCancelResponse);
    }
}
