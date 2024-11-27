package org.example.test.service;

import org.example.test.dto.PayRequest;
import org.example.test.dto.PayResponse;
import org.example.test.type.*;

public class ConveniencePayService {
    private final MoneyAdapter moneyAdapter = new MoneyAdapter();
    private final CardAdapter cardAdapter = new CardAdapter();

    public PayResponse pay(PayRequest request) {
        CardUseResult cardUseResult;
        MoneyUseResult moneyUseResult;

        if (request.getPayMethodType() == PayMethodType.CARD) {
            cardAdapter.authorization();
            cardAdapter.approval();
            cardUseResult = cardAdapter.capture(request.getPayAmount());
        } else {
            moneyUseResult = moneyAdapter.use(request.getPayAmount());
        }

        // fail fast + Success Case (Only one)
        if (cardUseResult == CardUseResult.USE_FAIL ||
                moneyUseResult == MoneyUseResult.USE_FAIL) {
            return new PayResponse(PayResult.FAIL, 0);
        }
        return new PayResponse(PayResult.SUCCESS, request.getPayAmount());
    }

    public PayCancelResponse payCancel(PayCancelRequest payCancelRequest) {
        MoneyUseCancelResult moneyUseCancelResult = moneyAdapter.useCancel(payCancelRequest.getPayCancelAmount());

        // fail fast + Success Case (Only one)
        if (moneyUseCancelResult == MoneyUseCancelResult.MONEY_USE_CANCEL_FAILED) {
            return new PayCancelResponse(PayCancelResult.PAY_CANCEL_FAILED, 0);
        }
        return new PayCancelResponse(PayCancelResult.PAY_CANCEL_SUCCESS, payCancelRequest.getPayCancelAmount());
    }
}
