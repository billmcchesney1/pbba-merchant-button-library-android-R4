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
package com.zapp.library.merchant.network.rest;

import com.zapp.library.merchant.network.exception.GenericException;
import com.zapp.library.merchant.network.exception.NetworkException;
import com.zapp.library.merchant.network.response.AvailableBankAppsResponse;

import java.util.List;

import retrofit.http.GET;

/**
 * REST network client interface.
 */
public interface IPBBABankLogoService {
    /**
     * URL for get available bank apps
     */
    String AVAILABLE_BANK_APP_URL = "/merchant-lib/banks.json";

    @GET(AVAILABLE_BANK_APP_URL)
    List<AvailableBankAppsResponse> getAvailableBankApps() throws NetworkException, GenericException;
}
