package org.example.test.service;

import org.example.test.type.ConvenienceType;
import org.example.test.dto.PayRequest;
import org.example.test.dto.PayResponse;
import org.example.test.type.PayCancelResult;
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

    @Test
    void pay_cancel_success() {
        // given
        PayCancelRequest payRequest = new PayCancelRequest(ConvenienceType.G25,1000);
        // when
        PayCancelResponse payResponse = conveniencePayService.payCancel(payRequest);
        // then
        assertEquals(PayCancelResult.PAY_CANCEL_SUCCESS, payResponse.getPayCancelResult());
        assertEquals(1000,payResponse.getPayCancelAmount());
    }
    @Test
    void pay_cancel_fail() {
        // given
        PayCancelRequest payRequest = new PayCancelRequest(ConvenienceType.G25,99);
        // when
        PayCancelResponse payResponse = conveniencePayService.payCancel(payRequest);
        // then
        assertEquals(PayCancelResult.PAY_CANCEL_FAILED, payResponse.getPayCancelResult());
        assertEquals(0,payResponse.getPayCancelAmount());
    }

}