package com.example.testeeasynvest.di.module

import android.app.Application
import com.example.testeeasynvest.BaseApp
import com.example.testeeasynvest.di.scope.PerApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val baseApp: BaseApp) {

    @Provides
    @Singleton
    @PerApplication
    fun provideApplication(): Application {
        return baseApp
    }
}