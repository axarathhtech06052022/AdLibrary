package com.example.adslibrary

import android.app.Activity
import android.content.Context
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.interstitial.InterstitialAd

var testAdsId = "ca-app-pub-3940256099942544/1033173712"
var mInterstitialAd: InterstitialAd? = null




fun showAds(activity: Activity, closeAds: CloseAds) {
    if (
        mInterstitialAd != null
    ) {
        mInterstitialAd?.show(activity)
        mInterstitialAd?.fullScreenContentCallback =
            object : FullScreenContentCallback() {
                override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                    super.onAdFailedToShowFullScreenContent(adError)
                }

                override fun onAdShowedFullScreenContent() {
                    super.onAdShowedFullScreenContent()
                    mInterstitialAd = null
                }

                override fun onAdDismissedFullScreenContent() {
                    super.onAdDismissedFullScreenContent()
                    closeAds.onCloseAds()
                }
            }
    } else {
        closeAds.onCloseAds()
    }
}

interface CloseAds {
    fun onCloseAds()
}