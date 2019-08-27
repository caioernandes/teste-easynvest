package com.example.testeeasynvest.ui.result_investment

import android.content.Intent
import android.os.Bundle
import com.example.testeeasynvest.R
import com.example.testeeasynvest.models.InvestmentResponse
import com.example.testeeasynvest.ui.base.BaseAppCompatActivity
import com.example.testeeasynvest.ui.investment_form.InvestmentFormActivity
import com.example.testeeasynvest.util.Constants
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
            //todo: preencher textos da view a partir do response
        }

        btn_simulator.setOnClickListener {
            val intent = Intent(this, InvestmentFormActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
