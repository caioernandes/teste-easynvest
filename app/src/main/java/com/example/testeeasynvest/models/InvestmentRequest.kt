package com.example.testeeasynvest.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class InvestmentRequest(
    @SerializedName("investedAmount") var investedAmount: Double,
    @SerializedName("index") var index: String,
    @SerializedName("rate") var rate: Int,
    @SerializedName("isTaxFree") var isTaxFree: Boolean,
    @SerializedName("maturityDate") var maturityDate: String
): Serializable