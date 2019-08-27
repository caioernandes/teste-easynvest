package com.example.testeeasynvest.ui.investment_form

import com.example.testeeasynvest.models.InvestmentRequest
import com.example.testeeasynvest.models.InvestmentResponse
import com.example.testeeasynvest.ui.base.BaseContract

class InvestmentFormContract {

    interface View: BaseContract.View {
        fun viewRequestInvestment(result: InvestmentResponse)
        fun showProgress(enable: Boolean)
        fun showErrorMessage(error: String)
    }

    interface Presenter: BaseContract.Presenter<View> {
        fun presentSendDataInvestment(request: InvestmentRequest)
    }
}
