package com.example.testeeasynvest.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class InvestmentResponse(
    @SerializedName("investmentParameter") var investmentParameter: InvestmentParameter = InvestmentParameter(),
    @SerializedName("grossAmount") var grossAmount: Double = 0.0,
    @SerializedName("taxesAmount") var taxesAmount: Double = 0.0,
    @SerializedName("netAmount") var netAmount: Double = 0.0,
    @SerializedName("grossAmountProfit") var grossAmountProfit: Double = 0.0,
    @SerializedName("netAmountProfit") val netAmountProfit: Double = 0.0,
    @SerializedName("annualGrossRateProfit") var annualGrossRateProfit: Double = 0.0,
    @SerializedName("monthlyGrossRateProfit") var monthlyGrossRateProfit: Double = 0.0,
    @SerializedName("dailyGrossRateProfit") var dailyGrossRateProfit: Double = 0.0,
    @SerializedName("taxesRate") var taxesRate: Double = 0.0,
    @SerializedName("rateProfit") var rateProfit: Double = 0.0,
    @SerializedName("annualNetRateProfit") var annualNetRateProfit: Double = 0.0
) : Serializable

data class InvestmentParameter(
    @SerializedName("investedAmount") var investedAmount: Int = 0,
    @SerializedName("yearlyInterestRate") var yearlyInterestRate: Double = 0.0,
    @SerializedName("maturityTotalDays") var maturityTotalDays: Int = 0,
    @SerializedName("maturityBusinessDays") var maturityBusinessDays: Int = 0,
    @SerializedName("maturityDate") var maturityDate: String = "",
    @SerializedName("rate") var rate: Int = 0,
    @SerializedName("isTaxFree") var isTaxFree: Boolean = false
) : Serializable