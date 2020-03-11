/*
 * Copyright (c) 2020  PayMaya Philippines, Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.paymaya.sdk.android.paywithpaymaya

import com.paymaya.sdk.android.BuildConfig
import com.paymaya.sdk.android.common.PayMayaEnvironment
import com.paymaya.sdk.android.paywithpaymaya.internal.PayWithPayMayaRepository
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import okhttp3.OkHttpClient
import org.junit.Before
import org.junit.Test

class PayWithPayMayaRepositoryTest {

    private lateinit var json: Json

    @Before
    fun setup() {
        json = Json(JsonConfiguration.Stable)
    }

    @Test
    fun sandbox() {
        val repository =
            PayWithPayMayaRepository(
                PayMayaEnvironment.SANDBOX,
                CLIENT_PUBLIC_KEY,
                json,
                httpClient = OkHttpClient()
            )

        assert(repository.baseUrl == BuildConfig.API_PAY_WITH_PAYMAYA_BASE_URL_SANDBOX)
    }

    @Test
    fun production() {
        val repository =
            PayWithPayMayaRepository(
                PayMayaEnvironment.PRODUCTION,
                CLIENT_PUBLIC_KEY,
                json,
                httpClient = OkHttpClient()
            )

        assert(repository.baseUrl == BuildConfig.API_PAY_WITH_PAYMAYA_BASE_URL_PRODUCTION)
    }

    companion object {
        private const val CLIENT_PUBLIC_KEY = "SOME KEY"
    }
}