package com.example.testeeasynvest

import android.app.Application
import com.example.testeeasynvest.di.component.ApplicationComponent
import com.example.testeeasynvest.di.component.DaggerApplicationComponent
import com.example.testeeasynvest.di.module.ApplicationModule

class BaseApp: Application() {

    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        instance = this
        setup()
    }

    fun setup() {
        component = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this)).build()
        component.inject(this)
    }

    fun getApplicationComponent(): ApplicationComponent {
        return component
    }

    companion object {
        lateinit var instance: BaseApp private set
    }
}