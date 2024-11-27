package org.example.test.service;

import org.example.test.dto.PayRequest;
import org.example.test.dto.PayResponse;
import org.example.test.dto.PayResult;

public class ConveniencePayService {
    public PayResponse pay(PayRequest request) {
        return new PayResponse(PayResult.SUCCESS, 100);
    }

    public void refund() {}
}
