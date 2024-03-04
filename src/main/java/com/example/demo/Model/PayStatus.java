package com.example.demo.Model;

public enum PayStatus {
    PAYDONE( "PAYDONE" ),
    NOTPAY( "NOTPAY" );

    private String payCode;

    PayStatus(String PayStatus ) {
        this.payCode = PayStatus;
    }

    public String getCode() {
        return this.payCode;
    }
}
