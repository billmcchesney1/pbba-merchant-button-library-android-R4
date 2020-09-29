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

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * A custom deserializer for {@link AvailableBankAppsResponse}
 */

public class AvailableBankAppsDeserializer extends BaseDeserializer implements JsonDeserializer<List<AvailableBankAppsResponse>> {

    @Override
    public List<AvailableBankAppsResponse> deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context) throws JsonParseException {
        final JsonArray jsonArray = json.getAsJsonArray();
        final List<AvailableBankAppsResponse> availableBankAppsRepons = new ArrayList<>();
        for (JsonElement jsonElement : jsonArray) {
            final JsonObject jsonObject = jsonElement.getAsJsonObject();
            final AvailableBankAppsResponse availableBank = new AvailableBankAppsResponse();
            availableBank.setBankName(getStringElement(jsonObject, "name"));
            availableBank.setSmallLogo(getStringElement(jsonObject, "shortLogo"));
            availableBank.setLargeLogo(getStringElement(jsonObject, "longLogo"));
            availableBankAppsRepons.add(availableBank);
        }
        return availableBankAppsRepons;
    }
}
