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

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * The base custom deserializer from json to java objects. Contains common helper methods.
 */
public abstract class BaseDeserializer {
    /**
     * A helper method which returns null in case such element name doesn't exist in the given json object.
     *
     * @param jsonObject the json object which contains the element with such name.
     * @param name       name of the member that is being requested.
     * @return the string value of member matching the name. Null if no such member exists.
     */
    protected String getStringElement(final JsonObject jsonObject, final String name) {
        final JsonElement element = jsonObject.get(name);
        String value = null;
        if (element != null) {
            value = element.getAsString();
        }
        return value;
    }
}
