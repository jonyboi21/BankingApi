package com.atm.atmproject.successfulresponse;

public class SuccessfulResponseWrapper {

    private SuccessfulResponseIterable successfulResponseIterable;

    public SuccessfulResponseWrapper(SuccessfulResponseIterable successfulResponseIterable) {
        this.successfulResponseIterable = successfulResponseIterable;
    }

    public SuccessfulResponseIterable getSuccessfulResponse() {
        return successfulResponseIterable;
    }

    public void setSuccessfulResponse(SuccessfulResponseIterable successfulResponseIterable) {
        this.successfulResponseIterable = successfulResponseIterable;
    }
}
