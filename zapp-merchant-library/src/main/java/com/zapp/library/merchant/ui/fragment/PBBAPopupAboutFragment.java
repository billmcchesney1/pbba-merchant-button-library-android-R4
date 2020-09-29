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
package com.zapp.library.merchant.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zapp.library.merchant.R;
import com.zapp.library.merchant.network.response.PBBABankLogoResponse;

/**
 * Pop up fragment for PBBA about screen
 */
public final class PBBAPopupAboutFragment extends PBBAPopup implements LoaderManager.LoaderCallbacks<PBBABankLogoResponse> {

    /**
     * Create new instance of Pay by Bank app About Popup fragment
     *
     * @return The new fragment instance.
     */
    public static PBBAPopupAboutFragment newInstanceAbout() {
        return new PBBAPopupAboutFragment();
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.pbba_popup_about, container, false);
    }

}
