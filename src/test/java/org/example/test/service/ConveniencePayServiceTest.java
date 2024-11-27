package org.example.test.service;

import org.example.test.dto.ConvenienceType;
import org.example.test.dto.PayRequest;
import org.example.test.dto.PayResponse;
import org.example.test.dto.PayResult;
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

}