package com.example.testeeasynvest.ui.investment_form

import com.example.testeeasynvest.api.ApiServiceInterface
import com.example.testeeasynvest.models.InvestmentRequest
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class InvestmentFormPresenter : InvestmentFormContract.Presenter {

    private val subscriptions = CompositeDisposable()
    private lateinit var view: InvestmentFormContract.View
    private val api: ApiServiceInterface = ApiServiceInterface.create()

    override fun subscribe() {}

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: InvestmentFormContract.View) {
        this.view = view
    }

    override fun presentSendDataInvestment(request: InvestmentRequest) {
        try {
            val subscribe = api.calculateFutureValues(
                request.investedAmount,
                request.index,
                request.rate,
                request.isTaxFree,
                request.maturityDate
            ).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view.showProgress(true)
                    view.viewRequestInvestment(it)
                }, { error ->
                    view.showProgress(false)
                    view.showErrorMessage(error.localizedMessage)
                })
            subscriptions.add(subscribe)
        } catch (e: Exception) {
            view.showErrorMessage(e.localizedMessage)
        }
    }
}