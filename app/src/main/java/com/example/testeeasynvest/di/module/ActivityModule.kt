package com.example.testeeasynvest.di.module

import android.app.Activity
import com.example.testeeasynvest.ui.investment_form.InvestmentFormContract
import com.example.testeeasynvest.ui.investment_form.InvestmentFormPresenter
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private var activity: Activity) {

    @Provides
    fun provideActivity(): Activity {
        return activity
    }

    @Provides
    fun providePresenterInvestmentFormActivity(): InvestmentFormContract.Presenter {
        return InvestmentFormPresenter()
    }

    /*@Provides
    fun providePresenterInvestmentResultDetail(): DetailMovieContract.Presenter {
        return DetailMoviePresenter()
    }*/
}