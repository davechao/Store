package com.swiper.store

import android.app.Application
import com.facebook.stetho.Stetho
import com.swiper.store.widget.log.DebugLogTree
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class App : Application() {

    companion object {
        lateinit var self: Application
        fun applicationContext(): Application {
            return self
        }
    }

    init {
        self = this
    }

    override fun onCreate() {
        super.onCreate()

        Timber.plant(DebugLogTree())
        Stetho.initializeWithDefaults(this)

    }
}