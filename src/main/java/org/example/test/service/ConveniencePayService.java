package org.example.test.service;

import org.example.test.dto.PayRequest;
import org.example.test.dto.PayResponse;
import org.example.test.type.PayResult;
import org.example.test.type.MoneyUseResult;

public class ConveniencePayService {
    private final MoneyAdapter moneyAdapter = new MoneyAdapter();

    public PayResponse pay(PayRequest request) {
        MoneyUseResult moneyUseResult = moneyAdapter.use(request.getPayAmount());

        // fail fast + Success Case (Only one)
        if (moneyUseResult == MoneyUseResult.USE_FAIL) {
            return new PayResponse(PayResult.FAIL,0);
        }
        return new PayResponse(PayResult.SUCCESS, request.getPayAmount());
    }

    public PayCancelResponse payCancel(PayCancelRequest payCancelRequest) {
        moneyAdapter.useCancel(payCancelRequest.getPayCancelAmount());
    }
}
