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

    private lateinit var response: InvestmentResponse

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_investment)

        initComponents()
    }

    private fun initComponents() {
        if (intent != null) {
            response =
                intent?.extras?.getSerializable(Constants.INVESTMENT_RESPONSE) as InvestmentResponse

            populateFields(response)
        }

        btn_simulator.setOnClickListener {
            val intent = Intent(this, InvestmentFormActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun populateFields(response: InvestmentResponse) {
        gross_value_investment_large.text =
            getString(R.string.rs) + Helpers.truncate(response.grossAmount)
        yield_value_large.text =
            getString(R.string.total_income_rs) + Helpers.truncate(response.grossAmountProfit)
        value_initially_applied.text =
            getString(R.string.rs) + Helpers.truncate(response.investmentParameter.investedAmount.toDouble())
        gross_value_investment.text = getString(R.string.rs) + response.grossAmount.toString()
        yield_value.text = getString(R.string.rs) + Helpers.truncate(response.grossAmountProfit)
        ir_investment.text =
            getString(R.string.rs) + response.taxesAmount.toString() + "[" + response.taxesRate.toString() + getString(
                R.string.percente
            ) + "]"
        net_investment_value.text = getString(R.string.rs) + response.netAmount.toString()
        redemption_date.text = Helpers.formatDate(response.investmentParameter.maturityDate)
        busy_days.text = response.investmentParameter.maturityTotalDays.toString()
        mensal_rendemption.text =
            response.monthlyGrossRateProfit.toString() + getString(R.string.percente)
        cdi_investment.text =
            response.investmentParameter.rate.toString() + getString(R.string.percente)
        annual_profitability.text =
            Helpers.truncate(response.investmentParameter.yearlyInterestRate) + getString(R.string.percente)
        period_profitability.text =
            Helpers.truncate(response.rateProfit) + getString(R.string.percente)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, InvestmentFormActivity::class.java))
    }
}
