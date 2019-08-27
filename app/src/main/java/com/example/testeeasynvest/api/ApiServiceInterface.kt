package com.example.testeeasynvest.api

import com.example.testeeasynvest.models.InvestmentResponse
import com.example.testeeasynvest.util.Constants
import io.reactivex.Observable
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServiceInterface {

    //todo - adicionar parametros separados no metodo calculateFutureValues()

    /*
    investedAmount = 32323.0                 // Valor a investir em reais
    index = "CDI"                            // Índice, por enquanto só CDI disponível
    rate = 123                               // Percentual do papel
    isTaxFree = false                        // Isento de IR, por enquanto só falso
    maturityDate = "2023-03-03"              // Data do vencimento, no formato ano-mes-dia
    */

    @GET("calculator/simulate")
    fun calculateFutureValues(
        @Path("investedAmount") investedAmount: Double,
        @Path("index") index: String,
        @Path("rate") rate: Int,
        @Path("isTaxFree") isTaxFree: Boolean,
        @Path("maturityDate") maturityDate: String
    ): Observable<InvestmentResponse>

    companion object Factory {
        fun create(): ApiServiceInterface {
            val retrofit = retrofit2.Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .build()

            return retrofit.create(ApiServiceInterface::class.java)
        }
    }
}