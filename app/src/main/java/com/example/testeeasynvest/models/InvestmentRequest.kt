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

/*
    investedAmount = 32323.0                 // Valor a investir em reais
    index = "CDI"                            // Índice, por enquanto só CDI disponível
    rate = 123                               // Percentual do papel
    isTaxFree = false                        // Isento de IR, por enquanto só falso
    maturityDate = "2023-03-03"              // Data do vencimento, no formato ano-mes-dia
* */