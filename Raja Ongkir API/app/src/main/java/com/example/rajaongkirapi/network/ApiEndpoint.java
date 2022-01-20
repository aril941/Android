package com.example.rajaongkirapi.network;

import com.example.rajaongkirapi.data.city.ResponseCity;
import com.example.rajaongkirapi.data.cost.ResponseCost;


import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiEndpoint {
    @GET("city")
    Single<ResponseCity> getCity();
    @FormUrlEncoded
    @POST("cost")
    Single<ResponseCost>postCost(
            @Field("origin") String origin,
            @Field("destination") String destination,
            @Field("weight") int weight,
            @Field("courier") String courier);
}
