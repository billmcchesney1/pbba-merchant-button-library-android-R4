/*
 * Copyright 2016 IPCO 2012 Limited
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
package com.zapp.library.merchant.test.pbbaapputils;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.support.test.espresso.intent.Intents;
import android.support.test.espresso.intent.matcher.IntentMatchers;
import android.support.test.filters.SmallTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.zapp.library.merchant.test.TestActivity;
import com.zapp.library.merchant.test.TestSuite;
import com.zapp.library.merchant.util.PBBAAppUtils;
import com.zapp.library.merchant.util.PBBALibraryUtils;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Instrumented unit tests for PBBAAppUtils class.
 *
 * @author msagi
 */
@SuppressWarnings({"ProhibitedExceptionDeclared", "InstanceMethodNamingConvention", "ConstantConditions", "unused", "CyclicClassDependency"})
@RunWith(AndroidJUnit4.class)
@SmallTest
public class OpenBankingAppTest {

    @SuppressWarnings("PublicField")
    @Rule
    public ActivityTestRule<TestActivity> mActivityTestRule = new ActivityTestRule<>(TestActivity.class, /* initialTouchMode */ true, /* launchActivity */ true);

    @Before
    public void setUp() {
        final Context context = mActivityTestRule.getActivity();
        PBBALibraryUtils.setOpenBankingAppButtonClicked(context, Boolean.FALSE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOpenBankingAppNulls() throws Exception {
        PBBAAppUtils.openBankingApp(/* context */ null, /* secureToken */ null, /*type of request*/ null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOpenBankingAppNoContext() throws Exception {
        PBBAAppUtils.openBankingApp(/* context */ null, "secureToken", TestSuite.REQUEST_TO_PAY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOpenBankingAppNoSecureToken() throws Exception {
        final TestActivity activity = mActivityTestRule.getActivity();
        PBBAAppUtils.openBankingApp(activity, /* secureToken */ null, TestSuite.REQUEST_TO_PAY);
        activity.finish();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOpenBankingAppEmptySecureToken() throws Exception {
        final TestActivity activity = mActivityTestRule.getActivity();
        PBBAAppUtils.openBankingApp(activity, /* secureToken */ "", TestSuite.REQUEST_TO_PAY);
        activity.finish();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOpenBankingAppNoTypeOfRequest() throws Exception {
        final TestActivity activity = mActivityTestRule.getActivity();
        PBBAAppUtils.openBankingApp(activity, "secureToken",/*type of request*/ null);
        activity.finish();
    }

    @Test
    public void testOpenBankingAppOKPay() throws Exception {
        Intents.init();
        final TestActivity activity = mActivityTestRule.getActivity();
        final Intent resultData = new Intent();
        final Instrumentation.ActivityResult result = new Instrumentation.ActivityResult(Activity.RESULT_OK, resultData);
        Intents.intending(IntentMatchers.hasData(TestSuite.OPEN_BANKING_APP_INTENT_URI)).respondWith(result);
        PBBAAppUtils.openBankingApp(activity, TestSuite.SECURE_TOKEN, TestSuite.REQUEST_TO_PAY);
        activity.finish();
        Intents.release();
    }

    @Test
    public void testOpenBankingAppOKLinking() throws Exception {
        Intents.init();
        final TestActivity activity = mActivityTestRule.getActivity();
        final Intent resultData = new Intent();
        final Instrumentation.ActivityResult result = new Instrumentation.ActivityResult(Activity.RESULT_OK, resultData);
        Intents.intending(IntentMatchers.hasData(TestSuite.LINKING_INTENT_URI)).respondWith(result);
        PBBAAppUtils.openBankingApp(activity, TestSuite.SECURE_TOKEN, TestSuite.REQUEST_TO_LINK);
        activity.finish();
        Intents.release();
    }

    @Test
    public void testOpenBankingAppWithAppContextOK() throws Exception {
        Intents.init();
        final TestActivity activity = mActivityTestRule.getActivity();
        final Intent resultData = new Intent();
        final Instrumentation.ActivityResult result = new Instrumentation.ActivityResult(Activity.RESULT_OK, resultData);
        Intents.intending(IntentMatchers.hasData(TestSuite.OPEN_BANKING_APP_INTENT_URI)).respondWith(result);
        PBBAAppUtils.openBankingApp(activity.getApplicationContext(), TestSuite.SECURE_TOKEN, TestSuite.REQUEST_TO_PAY);
        activity.finish();
        Intents.release();
    }

    @After
    public void tearDown() {
        final Context context = mActivityTestRule.getActivity();
        PBBALibraryUtils.setOpenBankingAppButtonClicked(context, Boolean.FALSE);
    }
}