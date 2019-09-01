package com.example.testeeasynvest.ui.investment_form

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.InputFilter
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.core.content.ContextCompat.getDrawable
import com.example.testeeasynvest.R
import com.example.testeeasynvest.di.component.DaggerActivityComponent
import com.example.testeeasynvest.di.module.ActivityModule
import com.example.testeeasynvest.models.InvestmentRequest
import com.example.testeeasynvest.models.InvestmentResponse
import com.example.testeeasynvest.ui.base.BaseAppCompatActivity
import com.example.testeeasynvest.ui.result_investment.ResultInvestmentActivity
import com.example.testeeasynvest.util.*
import com.example.testeeasynvest.util.Helpers.Companion.validateNotNull
import kotlinx.android.synthetic.main.activity_investment_form.*
import javax.inject.Inject

class InvestmentFormActivity : BaseAppCompatActivity(), InvestmentFormContract.View,
    View.OnClickListener, TextWatcher {

    private lateinit var edtValueInvestment: EditText
    private lateinit var edtDueDate: EditText
    private lateinit var investmentPercentage: EditText
    private lateinit var btnSimulator: Button

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
        edtValueInvestment.addTextChangedListener(this)
        edtDueDate.addTextChangedListener(this)
        investmentPercentage.addTextChangedListener(this)
        investmentPercentage.filters = arrayOf<InputFilter>(InputFilterMinMax(0, 999))

        edtValueInvestment.addTextChangedListener(Mask.monetary(edtValueInvestment))
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

        if (Helpers.verifyAvailableNetwork(this)) {
            if (valid(true)) {
                val request = InvestmentRequest(
                    edtValueInvestment.text.toString().replace(",", "")
                        .toDouble(),
                    "CDI",
                    investmentPercentage.text.toString().toInt(),
                    false,
                    Helpers.formatDateReverse(edtDueDate.text.toString())
                )
                presenter.presentSendDataInvestment(request)
            }
        } else {
            Helpers.alertDialog(
                getString(R.string.no_connection),
                getString(R.string.verify_no_connection),
                this
            )
        }
    }

    override fun showProgress(enable: Boolean) {
        if (enable)
            progressBar.visibility = View.VISIBLE
        else
            progressBar.visibility = View.GONE
    }

    override fun showErrorMessage(error: String) {
        Log.e("Error", error)
        Helpers.alertDialog(getString(R.string.error_occurred), error, this)
    }

    private fun validateButtonSimulator() {
        if (valid(false)) {
            btnSimulator.background = getDrawable(this, R.drawable.buttonshape_enabled)
        } else {
            btnSimulator.background = getDrawable(this, R.drawable.buttonshape)
        }
    }

    private fun valid(showError: Boolean): Boolean {
        if (!validateNotNull(
                edtValueInvestment,
                getString(R.string.validate_value_investment),
                showError
            )
        ) {
            return false
        }
        if (!validateNotNull(
                edtDueDate,
                getString(R.string.validate_edtdueDate),
                showError
            )
        ) {
            return false
        }
        if (!validateNotNull(
                investmentPercentage,
                getString(R.string.validate_investment_percentage),
                showError
            )
        ) {
            return false
        }

        return true
    }

    override fun afterTextChanged(s: Editable?) {
        validateButtonSimulator()
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

    }


}
