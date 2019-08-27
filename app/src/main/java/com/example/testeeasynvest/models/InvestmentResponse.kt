package com.example.testeeasynvest.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class InvestmentResponse(
    @SerializedName("investmentParameter") val investmentParameter: InvestmentParameter,
    @SerializedName("grossAmount") val grossAmount: Double,
    @SerializedName("taxesAmount") val taxesAmount: Double,
    @SerializedName("netAmount") val netAmount: Double,
    @SerializedName("grossAmountProfit") val grossAmountProfit: Double,
    @SerializedName("netAmountProfit") val netAmountProfit: Double,
    @SerializedName("annualGrossRateProfit") val annualGrossRateProfit: Double,
    @SerializedName("monthlyGrossRateProfit") val monthlyGrossRateProfit: Double,
    @SerializedName("dailyGrossRateProfit") val dailyGrossRateProfit: Double,
    @SerializedName("taxesRate") val taxesRate: Int,
    @SerializedName("rateProfit") val rateProfit: Double,
    @SerializedName("annualNetRateProfit") val annualNetRateProfit: Double
) : Serializable

data class InvestmentParameter(
    @SerializedName("investedAmount") val investedAmount: Int,
    @SerializedName("yearlyInterestRate") val yearlyInterestRate: Double,
    @SerializedName("maturityTotalDays") val maturityTotalDays: Int,
    @SerializedName("maturityBusinessDays") val maturityBusinessDays: Int,
    @SerializedName("maturityDate") val maturityDate: String,
    @SerializedName("rate") val rate: Int,
    @SerializedName("isTaxFree") val isTaxFree: Boolean
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