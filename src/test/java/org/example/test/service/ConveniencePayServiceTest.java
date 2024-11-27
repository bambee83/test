package org.example.test.service;

import org.example.test.type.ConvenienceType;
import org.example.test.dto.PayRequest;
import org.example.test.dto.PayResponse;
import org.example.test.type.PayResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConveniencePayServiceTest {
    ConveniencePayService conveniencePayService = new ConveniencePayService();
    @Test
    void pay_success() {
        // given
        PayRequest payRequest = new PayRequest(ConvenienceType.G25,100);
        // when
        PayResponse payResponse = conveniencePayService.pay(payRequest);
        // then
        assertEquals(PayResult.SUCCESS, payResponse.getPayResult());
        assertEquals(100,payResponse.getPaidAmount());
    }
    @Test
    void pay_fail() {
        // given
        PayRequest payRequest = new PayRequest(ConvenienceType.G25,1000_001);
        // when
        PayResponse payResponse = conveniencePayService.pay(payRequest);
        // then
        assertEquals(PayResult.FAIL, payResponse.getPayResult());
        assertEquals(0,payResponse.getPaidAmount());
    }

}