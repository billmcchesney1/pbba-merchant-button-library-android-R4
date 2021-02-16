/*
 * Copyright (c) 2020 Mastercard
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
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
    REQUEST_TO_PAY("RequestToPay"),

    /**
     * Request to link and pay
     */
    REQUEST_TO_LINK_AND_PAY("RequestToLinkAndPay");

    private final String typeOfRequest;

    RequestType(final String typeOfRequest) {
        this.typeOfRequest = typeOfRequest;
    }

    public String getTypeOfRequest() {
        return typeOfRequest;
    }
}
