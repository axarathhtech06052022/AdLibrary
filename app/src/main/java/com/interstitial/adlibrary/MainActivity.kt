package com.interstitial.adlibrary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.adlibrary.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNext.setOnClickListener {
//            showAds(this@MainActivity, object : CloseAds {
//                override fun onCloseAds() {
//                    var intent = Intent(this@MainActivity, NextActivity::class.java)
//                    startActivity(intent)
//                }
//
//            })
        }
    }
}