package com.example.testeeasynvest.di.component

import com.example.testeeasynvest.BaseApp
import com.example.testeeasynvest.di.module.ApplicationModule
import dagger.Component

@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {
    fun inject(application: BaseApp)
}