package com.raana.marco.ui

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MarcoApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}