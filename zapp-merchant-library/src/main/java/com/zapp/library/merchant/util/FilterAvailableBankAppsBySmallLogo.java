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

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.zapp.library.merchant.network.response.AvailableBankAppsResponse;

import java.util.ArrayList;
import java.util.List;

public class FilterAvailableBankAppsBySmallLogo implements FilterAvailableBankApps {
    @Override
    public List<AvailableBankAppsResponse> filter(@NonNull final List<AvailableBankAppsResponse> list) {
        List<AvailableBankAppsResponse> filteredList = new ArrayList<>();
        for (AvailableBankAppsResponse availableBankAppsResponse : list) {
            if (!TextUtils.isEmpty(availableBankAppsResponse.getSmallLogo())){
                filteredList.add(availableBankAppsResponse);
            }
        }
        return filteredList;
    }
}
