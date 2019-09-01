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

/*
{
    "investmentParameter": {
        "investedAmount": 32323.0,                      // O valor a ser investido
        "yearlyInterestRate": 9.5512,                   // Rentabilidade anual
        "maturityTotalDays": 1981,                      // Dias corridos
        "maturityBusinessDays": 1409,                   // Dias úteis
        "maturityDate": "2023-03-03T00:00:00",          // Data de vencimento
        "rate": 123.0,                                  // Percentual do papel
        "isTaxFree": false                              // Isento de IR
    },
    "grossAmount": 60528.20,                            // Valor bruto do investimento
    "taxesAmount": 4230.78,                             // Valor do IR
    "netAmount": 56297.42,                              // Valor líquido
    "grossAmountProfit": 28205.20,                      // Rentabilidade bruta
    "netAmountProfit": 23974.42,                        // Rentabilidade líquida
    "annualGrossRateProfit": 87.26,                     // Rentabilidade bruta anual
    "monthlyGrossRateProfit": 0.76,                     // Rentabilidade bruta mensal
    "dailyGrossRateProfit": 0.000445330025305748,       // Rentabilidade bruta diária
    "taxesRate": 15.0,                                  // Faixa do IR (%)
    "rateProfit": 9.5512,                               // Rentabilidade no período
    "annualNetRateProfit": 74.17                        // Rentabilidade líquida anual
}
* */