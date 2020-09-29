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
package com.zapp.library.merchant.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.zapp.library.merchant.R;
import com.zapp.library.merchant.network.response.AvailableBankAppsResponse;

import java.util.List;

final class CfiLogosCustomView extends FrameLayout {

    private LinearLayout firstBlock;
    private LinearLayout secondBlock;
    private int imageCountPerLine;

    public CfiLogosCustomView(Context context) {
        this(context, null);
    }

    public CfiLogosCustomView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CfiLogosCustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        final View view = inflate(getContext(), R.layout.pbba_custom_cfi_layout, this);
        firstBlock = (LinearLayout) view.findViewById(R.id.firstBlock);
        secondBlock = (LinearLayout) view.findViewById(R.id.secondBlock);
    }

    public void setListOfAvailableBankAppsResponse(final List<AvailableBankAppsResponse> list) {
        bindData(list);
    }

    private void bindData(final List<AvailableBankAppsResponse> list) {
        if (list.size() < imageCountPerLine) {
            secondBlock.setVisibility(GONE);
            displayCfiLogos(firstBlock, list);
        } else {
            final List<AvailableBankAppsResponse> firstLine = list.subList(0, imageCountPerLine);
            final List<AvailableBankAppsResponse> secondLine = list.subList(imageCountPerLine, list.size());
            displayCfiLogos(firstBlock, firstLine);
            displayCfiLogos(secondBlock, secondLine);
        }
    }

    private void displayCfiLogos(final LinearLayout layout, final List<AvailableBankAppsResponse> list) {
        for (AvailableBankAppsResponse availableBankAppsResponse : list) {

            final View view = LayoutInflater.from(getContext()).inflate(R.layout.pbba_popup_custom_pbba_cfi_logo, null);
            final ImageView imageView = (ImageView) view.findViewById(R.id.pbba_available_bank_image);
            Glide.with(getContext()).load(availableBankAppsResponse.getSmallLogo())
                    .apply(RequestOptions.centerCropTransform())
                    .apply(RequestOptions.bitmapTransform(new RoundedCorners(getContext().getResources().getDimensionPixelSize(R.dimen.pbba_available_bank_app_corner))))
                    .into(imageView);
            layout.addView(view, new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        }
    }

    public void setNumberOfCfiLogosPerLine(int imageCountPerLine) {
        this.imageCountPerLine = imageCountPerLine;
    }
}
