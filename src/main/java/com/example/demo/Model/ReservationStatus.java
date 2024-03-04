package com.example.demo.Model;

public enum ReservationStatus {
    BOOKING( "BOOK" ),
    CONFIRM( "CONFIRM" ),
    CHECKIN( "CHECKIN" ),
    CHECKOUT( "CHECKOUT" ),
    NON_BOOKING("EMPTY");
    private String reservationCode;

    ReservationStatus(String ReservationStatus ) {
        this.reservationCode = ReservationStatus;
    }

    public String getCode() {
        return this.reservationCode;
    }
}
