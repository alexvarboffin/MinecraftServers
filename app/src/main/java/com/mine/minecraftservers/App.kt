package com.mine.minecraftservers

import android.app.Application
import com.mine.minecraftservers.di.appModule
import com.mine.minecraftservers.di.dataModule
import com.mine.minecraftservers.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(listOf(appModule, domainModule, dataModule))
        }
    }
}