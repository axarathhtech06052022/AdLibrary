package com.allads.adslibrarycode

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.RequestConfiguration
import java.util.*

class MyApp : Application() {
    var isShowAds = true
    var appOpenManager: AppOpenAdsManager? = null


    override fun onCreate() {
        super.onCreate()
        app = this
        MobileAds.initialize(this) { }

        MobileAds.setRequestConfiguration(
            RequestConfiguration.Builder()
                .setTestDeviceIds(
                    Arrays.asList(
                        "3595C5B1C6814D03CFE7FEE31A53DF14",
                        "8925BF11E80FE28FFAD53F523C79D881",
                        "EC2705C82D1013442B9A6A619FEB9AE8",
                        "475A88F4C4D4AEC389CC4D3CDE27DCFB",
                        "EC2705C82D1013442B9A6A619FEB9AE8",
                        "FE8660D83CE73058A451894670B185B1",
                        "1D0DD662715E7B403D259C97F16025F3",
                        "86403F3838C7E939613C80A351E252C8",
                        "16A02B434B145BD1B206ED17C38D846F"
                    )
                ).build()
        )

        appOpenManager = AppOpenAdsManager(this)
    }

    companion object {
        //        private const val ONESIGNAL_APP_ID = "########-####-####-####-############"
        lateinit var app: MyApp
            private set

    }
}