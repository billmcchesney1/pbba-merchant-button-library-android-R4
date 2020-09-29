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
package com.zapp.library.merchant.network.response;

import android.support.annotation.Nullable;

import com.zapp.library.merchant.exception.ZappError;

import java.util.List;

/**
 * PBBA bank Logo service response
 */
public class PBBABankLogoResponse {
    private final List<AvailableBankAppsResponse> availableBankAppsResponseList;
    private final ZappError zappError;

    public PBBABankLogoResponse(@Nullable final List<AvailableBankAppsResponse> availableBankAppsResponseList, @Nullable final ZappError
            zappError) {
        this.availableBankAppsResponseList = availableBankAppsResponseList;
        this.zappError = zappError;
    }

    public List<AvailableBankAppsResponse> getAvailableBankAppsResponseList() {
        return availableBankAppsResponseList;
    }

    public ZappError getZappError() {
        return zappError;
    }
}
