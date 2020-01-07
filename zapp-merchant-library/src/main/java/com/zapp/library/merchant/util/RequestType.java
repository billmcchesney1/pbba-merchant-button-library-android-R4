package com.zapp.library.merchant.util;

/**
 * Request type
 */
public enum RequestType {
    /**
     * Request to link account
     */
    REQUEST_TO_LINK("RequestToLink"),
    /**
     * Request to pay
     */
    REQUEST_TO_PAY("RequestToPay");

    private final String typeOfRequest;

    RequestType(final String typeOfRequest) {
        this.typeOfRequest = typeOfRequest;
    }

    public String getTypeOfRequest() {
        return typeOfRequest;
    }
}
