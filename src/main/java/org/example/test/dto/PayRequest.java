package org.example.test.dto;

public class PayRequest {
    // 편의점 종류
    ConvenienceType convenienceType;

    // 결제금액
    Integer PayAmount;

    public PayRequest(ConvenienceType convenienceType, Integer payAmount) {
        this.convenienceType = convenienceType;
        PayAmount = payAmount;
    }

    public ConvenienceType getConvenienceType() {
        return convenienceType;
    }

    public void setConvenienceType(ConvenienceType convenienceType) {
        this.convenienceType = convenienceType;
    }

    public Integer getPayAmount() {
        return PayAmount;
    }

    public void setPayAmount(Integer payAmount) {
        PayAmount = payAmount;
    }
}
