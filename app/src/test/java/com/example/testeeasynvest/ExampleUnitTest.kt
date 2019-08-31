package com.example.testeeasynvest

import com.example.testeeasynvest.di.component.DaggerActivityComponent
import com.example.testeeasynvest.di.module.ActivityModule
import com.example.testeeasynvest.models.InvestmentRequest
import com.example.testeeasynvest.models.InvestmentResponse
import com.example.testeeasynvest.ui.investment_form.InvestmentFormActivity
import com.example.testeeasynvest.ui.investment_form.InvestmentFormContract
import com.example.testeeasynvest.ui.investment_form.InvestmentFormPresenter
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations
import javax.inject.Inject

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    lateinit var presenter: InvestmentFormContract.Presenter

    lateinit var view: InvestmentFormContract.View

    private lateinit var request: InvestmentRequest
    private lateinit var response: InvestmentResponse

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Before
    fun setup() {

        presenter = InvestmentFormPresenter()

        MockitoAnnotations.initMocks(this)

        view = mock()
        presenter.attach(view)
    }

    @Test
    fun call_requestInvestmentSuccess() {

        request = InvestmentRequest(1000.0, "CDI", 100, false, "2020-02-11")

        presenter.presentSendDataInvestment(request)

        verify(view).viewRequestInvestment(response)
    }
}
