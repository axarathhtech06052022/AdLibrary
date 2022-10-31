package com.allads.adslibrarycode

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.lifecycle.Lifecycle.Event.*
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ProcessLifecycleOwner
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.appopen.AppOpenAd
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import java.util.*

class AppOpenAdsManager(private val app: MyApp) : LifecycleObserver,
    Application.ActivityLifecycleCallbacks {
    init {
        app.registerActivityLifecycleCallbacks(this)
        ProcessLifecycleOwner.get().lifecycle.addObserver(this)
    }

    private var isShowingAd = false
    private val TAG = "AppOpenManager"
    private var appOpenAd: AppOpenAd? = null
    private var currentActivity: Activity? = null
    private var loadCallback: AppOpenAd.AppOpenAdLoadCallback? = null
    private var loadTime: Long = 0

    @OnLifecycleEvent(ON_START)
    fun onStart() {
        //  showAdIfAvailable()
    }

    @OnLifecycleEvent(ON_PAUSE)
    fun onPause() {
    }

    @OnLifecycleEvent(ON_STOP)
    fun onStop() {
    }

    @OnLifecycleEvent(ON_DESTROY)
    fun onDestroy() {
    }

//    fun fetchAd(ads: ArrayList<String>) {
//        if (isAdAvailable()) {
//            return
//        }
//        loadCallback = object : AppOpenAd.AppOpenAdLoadCallback() {
//            override fun onAdLoaded(ad: AppOpenAd) {
//                super.onAdLoaded(ad)
//                appOpenAd = ad
//                loadTime = Date().time
//            }
//
//            @SuppressLint("NewApi")
//            override fun onAdFailedToLoad(p0: LoadAdError) {
//                super.onAdFailedToLoad(p0)
//                app.adsWaterFallData(
//                    app_open
//                )
//                fetchAd(app.adsBuilder(app_open))
//            }
//        }
//        if (ads.size > 0) {
//            when (ads[0]) {
//                NO_DATA_FOUND -> {
//                }
//                GOOGLE -> {
//                    val request = getAdRequest()
//                    AppOpenAd.load(
//                        app, if (BuildConfig.DEBUG) "/6499/example/app-open" else ads[1], request!!,
//                        AppOpenAd.APP_OPEN_AD_ORIENTATION_PORTRAIT, loadCallback as AppOpenAd.AppOpenAdLoadCallback
//                    )
//                }
//
//            }
//        }
//    }

    private fun getAdRequest(): AdRequest? {
        return AdRequest.Builder().build()
    }

    private fun isAdAvailable(): Boolean {
        return appOpenAd != null && wasLoadTimeLessThanNHoursAgo(4);
    }

    private fun wasLoadTimeLessThanNHoursAgo(numHours: Long): Boolean {
        val dateDifference = Date().time - loadTime
        val numMilliSecondsPerHour: Long = 3600000
        return dateDifference < numMilliSecondsPerHour * numHours
    }


//    private fun showAdIfAvailable() {
//        if (!isShowingAd && isAdAvailable()) {
//            when (currentActivity) {
//                is SplashActivity -> {}
//                else -> {
//                    appOpenAd?.show(currentActivity!!)
//                    appOpenAd?.fullScreenContentCallback = object : FullScreenContentCallback() {
//                        override fun onAdFailedToShowFullScreenContent(p0: AdError) {
//                            super.onAdFailedToShowFullScreenContent(p0)
//                            fetchAd(app.adsBuilder(app_open))
//                        }
//
//                        override fun onAdShowedFullScreenContent() {
//                            super.onAdShowedFullScreenContent()
//                            appOpenAd = null
//                        }
//
//                        override fun onAdDismissedFullScreenContent() {
//                            super.onAdDismissedFullScreenContent()
//                            fetchAd(app.adsBuilder(app_open))
//                        }
//
//                        override fun onAdImpression() {
//                            super.onAdImpression()
//                        }
//                    }
//                }
//            }
//        } else {
//            fetchAd(app.adsBuilder(app_open))
//        }
//    }

    override fun onActivityCreated(activity: Activity, bundle: Bundle?) {

    }

    override fun onActivityStarted(activity: Activity) {
        currentActivity = activity

        if (mInterstitialAd == null) {

            InterstitialAd.load(
                app,
                testAdsId,
                AdRequest.Builder().build(),
                object : InterstitialAdLoadCallback() {
                    override fun onAdFailedToLoad(adError: LoadAdError) {
                        mInterstitialAd = null
                    }

                    override fun onAdLoaded(interstitialAd: InterstitialAd) {
                        mInterstitialAd = interstitialAd
                    }
                })
        }

    }

    override fun onActivityResumed(activity: Activity) {
        currentActivity = activity
    }

    override fun onActivityPaused(activity: Activity) {

    }

    override fun onActivityStopped(activity: Activity) {

    }

    override fun onActivitySaveInstanceState(activity: Activity, bundle: Bundle) {

    }

    override fun onActivityDestroyed(activity: Activity) {
        currentActivity = null
    }


}