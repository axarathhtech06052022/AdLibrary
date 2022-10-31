package com.allads.adslibrarycode

import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.interstitial.InterstitialAd

var testAdsId = "/6499/example/interstitial"
var mInterstitialAd: InterstitialAd? = null




fun showAds(activity: AppCompatActivity, closeAds: CloseAds) {
    if (mInterstitialAd != null) {
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