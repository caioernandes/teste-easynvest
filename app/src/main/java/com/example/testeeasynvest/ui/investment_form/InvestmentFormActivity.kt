package com.example.testeeasynvest.ui.investment_form

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.testeeasynvest.R
import com.example.testeeasynvest.di.component.DaggerActivityComponent
import com.example.testeeasynvest.di.module.ActivityModule
import com.example.testeeasynvest.models.InvestmentRequest
import com.example.testeeasynvest.models.InvestmentResponse
import com.example.testeeasynvest.ui.base.BaseAppCompatActivity
import com.example.testeeasynvest.ui.result_investment.ResultInvestmentActivity
import com.example.testeeasynvest.util.Constants
import com.example.testeeasynvest.util.Helpers
import kotlinx.android.synthetic.main.activity_investment_form.*
import javax.inject.Inject
import com.example.testeeasynvest.util.InputFilterMinMax
import android.text.InputFilter

class InvestmentFormActivity : BaseAppCompatActivity(), InvestmentFormContract.View,
    View.OnClickListener {

    lateinit var edtValueInvestment: EditText
    lateinit var edtDueDate: EditText
    lateinit var investmentPercentage: EditText
    lateinit var btnSimulator: Button

    @Inject
    lateinit var presenter: InvestmentFormContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_investment_form)

        initComponents()

        injectDependency()
    }

    override fun onResume() {
        super.onResume()
        presenter.attach(this)
        presenter.subscribe()
    }

    private fun initComponents() {
        edtValueInvestment = findViewById(R.id.value_investment)
        edtDueDate = findViewById(R.id.due_date)
        investmentPercentage = findViewById(R.id.investment_percentage)
        btnSimulator = findViewById(R.id.btn_simulator)
        btnSimulator.setOnClickListener(this)

        investmentPercentage.filters = arrayOf<InputFilter>(InputFilterMinMax(0, 999))
    }

    override fun viewRequestInvestment(result: InvestmentResponse) {
        val intent = Intent(this, ResultInvestmentActivity::class.java)
        val bundle = Bundle()
        bundle.putSerializable(Constants.INVESTMENT_RESPONSE, result)
        intent.putExtras(bundle)
        startActivity(intent)
    }

    private fun injectDependency() {
        val listComponent = DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this))
            .build()

        listComponent.injectInvestmentFormActivity(this)
    }

    override fun onClick(view: View) {
        val request = InvestmentRequest(
            edtValueInvestment.text.toString().toDouble(),
            "CDI",
            investmentPercentage.text.toString().toInt(),
            false,
            Helpers.formatDateReverse(edtDueDate.text.toString())
        )
        presenter.presentSendDataInvestment(request)
    }

    override fun showProgress(enable: Boolean) {
        if (enable) {
            progressBar.visibility = View.VISIBLE
        } else {
            progressBar.visibility = View.GONE
        }
    }

    override fun showErrorMessage(error: String) {
        Log.e("Error", error)
        Helpers.alertDialog("Ocorreu um erro", error)
    }
}
