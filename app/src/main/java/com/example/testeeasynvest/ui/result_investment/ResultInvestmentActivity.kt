package com.example.testeeasynvest.ui.result_investment

import android.content.Intent
import android.os.Bundle
import com.example.testeeasynvest.R
import com.example.testeeasynvest.models.InvestmentResponse
import com.example.testeeasynvest.ui.base.BaseAppCompatActivity
import com.example.testeeasynvest.ui.investment_form.InvestmentFormActivity
import com.example.testeeasynvest.util.Constants
import com.example.testeeasynvest.util.Helpers
import kotlinx.android.synthetic.main.activity_result_investment.*

class ResultInvestmentActivity : BaseAppCompatActivity() {

    lateinit var response: InvestmentResponse

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_investment)

        initComponents()
    }

    private fun initComponents() {
        if (intent != null) {
            response =
                intent?.extras?.getSerializable(Constants.INVESTMENT_RESPONSE) as InvestmentResponse

            gross_value_investment_large.text = response.grossAmount.toString()
            yield_value_large.text = "Rendimento total de R$" + response.annualGrossRateProfit.toString()

            value_initially_applied.text = response.investmentParameter.investedAmount.toString()
            gross_value_investment.text = response.grossAmount.toString()
            yield_value.text = response.annualGrossRateProfit.toString()
            ir_investment.text =
                response.taxesAmount.toString() + "/" + response.taxesRate.toString()
            net_investment_value.text = response.netAmount.toString()
            redemption_date.text = Helpers.formatDate(response.investmentParameter.maturityDate)
            busy_days.text = response.investmentParameter.maturityTotalDays.toString()
            mensal_rendemption.text = response.monthlyGrossRateProfit.toString()
            cdi_investment.text = response.investmentParameter.rate.toString()
            annual_profitability.text = response.investmentParameter.yearlyInterestRate.toString()
            period_profitability.text = response.rateProfit.toString()
        }

        btn_simulator.setOnClickListener {
            val intent = Intent(this, InvestmentFormActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
