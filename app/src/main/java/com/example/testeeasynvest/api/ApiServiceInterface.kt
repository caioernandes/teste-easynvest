package com.example.testeeasynvest.api

import com.example.testeeasynvest.models.InvestmentResponse
import com.example.testeeasynvest.util.Constants
import io.reactivex.Observable
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServiceInterface {

    @GET("calculator/simulate")
    fun calculateFutureValues(
        @Query("investedAmount") investedAmount: Double,
        @Query("index") index: String,
        @Query("rate") rate: Int,
        @Query("isTaxFree") isTaxFree: Boolean,
        @Query("maturityDate") maturityDate: String
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