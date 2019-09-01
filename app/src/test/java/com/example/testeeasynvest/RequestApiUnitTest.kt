package com.example.testeeasynvest

import com.example.testeeasynvest.models.InvestmentParameter
import com.example.testeeasynvest.models.InvestmentRequest
import com.example.testeeasynvest.models.InvestmentResponse
import com.example.testeeasynvest.ui.investment_form.InvestmentFormContract
import com.example.testeeasynvest.ui.investment_form.InvestmentFormPresenter
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Assert
import org.junit.Before
import org.junit.ClassRule
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class RequestApiUnitTest {

    lateinit var presenter: InvestmentFormContract.Presenter

    @Mock
    lateinit var view: InvestmentFormContract.View

    companion object {
        @ClassRule
        @JvmField
        val schedulers = RxImmediateSchedulerRule()
    }

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        presenter = InvestmentFormPresenter()
        view = mock()
        presenter.attach(view)
    }

    @Test
    fun call_requestInvestmentDifferentResponse() {
        val request = InvestmentRequest(1000.0, "CDI", 100, false, "2020-02-11")

        presenter.presentSendDataInvestment(request)

        val response = InvestmentResponse()

        verify(view).viewRequestInvestment(response)
    }

    @Test
    fun call_requestInvestmentEqualsResponse() {
        val request = InvestmentRequest(1000.0, "CDI", 100, false, "2020-02-11")

        presenter.presentSendDataInvestment(request)

        val response = InvestmentResponse(
            investmentParameter = InvestmentParameter(
                investedAmount = 1000,
                yearlyInterestRate = 5.9186,
                maturityTotalDays = 163,
                maturityBusinessDays = 110,
                maturityDate = "2020-02-11T00:00:00",
                rate = 100,
                isTaxFree = false
            ),
            grossAmount = 1025.42,
            taxesAmount = 5.72,
            netAmount = 1019.7,
            grossAmountProfit = 25.42,
            netAmountProfit = 19.7,
            annualGrossRateProfit = 2.54,
            monthlyGrossRateProfit = 0.48,
            dailyGrossRateProfit = 2.28203370105318E-4,
            taxesRate = 22.5,
            rateProfit = 5.9186,
            annualNetRateProfit = 1.97
        )

        verify(view).viewRequestInvestment(response)
    }

    @Test
    fun call_requestInvestmentResponseNotNull() {
        val request = InvestmentRequest(1000.0, "CDI", 100, false, "2020-02-11")

        presenter.presentSendDataInvestment(request)

        val response = InvestmentResponse()

        view.viewRequestInvestment(response)

        Assert.assertNotNull(response)
    }

    @Test
    fun call_requestInvestmentResponseEmpty() {
        val request = InvestmentRequest(1000.0, "CDI", 100, false, "00000")

        presenter.presentSendDataInvestment(request)

        val responseEmpty = InvestmentResponse()
        val responseServerApi = InvestmentResponse()

        view.viewRequestInvestment(responseServerApi)

        Assert.assertEquals(responseEmpty, responseServerApi)
    }
}
