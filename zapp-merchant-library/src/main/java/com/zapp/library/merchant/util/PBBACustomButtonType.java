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
 * Type of {@link com.zapp.library.merchant.ui.view.PBBACustomButton} layout
 */
public enum PBBACustomButtonType {
    /**
     * It's displaying branding image with available bank apps logo and link of More about PBBA
     */
    MOREABOUT_AND_BANKLOGOS,
    /**
     * It's displaying branding image with available bank apps logo
     */
    BANKLOGOS,
    /**
     * It's displaying branding image with link More about PBBA
     */
    MOREABOUT,
    /**
     * Default type, it's displaying only branding image
     */
    NONE,
}
