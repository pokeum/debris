package com.example.dependency_injection

import android.app.Application
import com.bean.airbridge.Airbridge
import com.bean.airbridge.AirbridgeConfig

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        val config = AirbridgeConfig.Builder("YOUR_APP_NAME", "YOUR_APP_SDK_TOKEN")
            .build()
        Airbridge.init(this, config)
    }
}