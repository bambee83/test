package org.example.test.service;

import org.example.test.dto.PayRequest;
import org.example.test.dto.PayResponse;
import org.example.test.type.MoneyUseCancelResult;
import org.example.test.type.PayCancelResult;
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
        MoneyUseCancelResult moneyUseCancelResult = moneyAdapter.useCancel(payCancelRequest.getPayCancelAmount());

        // fail fast + Success Case (Only one)
        if (moneyUseCancelResult == MoneyUseCancelResult.MONEY_USE_CANCEL_FAILED) {
            return new PayCancelResponse(PayCancelResult.PAY_CANCEL_FAILED,0);
        }
        return new PayCancelResponse(PayCancelResult.PAY_CANCEL_SUCCESS,payCancelRequest.getPayCancelAmount());
    }
}
