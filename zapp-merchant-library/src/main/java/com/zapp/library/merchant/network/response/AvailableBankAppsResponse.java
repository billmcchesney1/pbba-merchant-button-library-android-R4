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

public class AvailableBankAppsResponse {
    /**
     * The bank name
     */
    private String bankName;
    /**
     * The logo image url
     */
    private String smallLogo;
    /**
     * The large logo image url
     */
    private String largeLogo;

    /**
     * Get bank name
     * @return bank name
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * Set bank name
     * @param bankName
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    /**
     * Get small logo url
     * @return string url of small logo
     */
    public String getSmallLogo() {
        return smallLogo;
    }

    /**
     * Set small logo url
     * @param smallLogo
     */
    public void setSmallLogo(String smallLogo) {
        this.smallLogo = smallLogo;
    }

    /**
     * Get large logo url
     * @return string url of large logo
     */
    public String getLargeLogo() {
        return largeLogo;
    }

    /**
     * Set large logo url
     * @param largeLogo
     */
    public void setLargeLogo(String largeLogo) {
        this.largeLogo = largeLogo;
    }
}
