package com.example.testeeasynvest.di.component

import com.example.testeeasynvest.di.module.ActivityModule
import com.example.testeeasynvest.ui.investment_form.InvestmentFormActivity
import com.example.testeeasynvest.ui.result_investment.ResultInvestmentActivity
import dagger.Component

@Component(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun injectInvestmentFormActivity(investmentActivity: InvestmentFormActivity)
    fun injectResultInvestmentActivity(detailMovieActivity: ResultInvestmentActivity)
}