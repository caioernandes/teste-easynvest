package com.example.testeeasynvest.api

import com.example.testeeasynvest.models.InvestmentRequest
import com.example.testeeasynvest.models.InvestmentResponse
import com.example.testeeasynvest.util.Constants
import io.reactivex.Observable
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiServiceInterface {

    //todo - adicionar parametros separados no metodo calculateFutureValues()

    @GET("calculator/simulate")
    fun calculateFutureValues(request: InvestmentRequest): Observable<InvestmentResponse>

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