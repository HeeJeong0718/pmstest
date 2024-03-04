package com.example.demo.Model;

public enum Status {
    CLEAN( "01" ),
    DIRTY( "02" );

    private String cleanCode;

    Status( String cleanStatus ) {
        this.cleanCode = cleanStatus;
    }

    public String getCode() {
        return this.cleanCode;
    }
}
