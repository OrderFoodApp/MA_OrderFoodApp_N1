package com.example.ma_orderfoodapp_n1;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;


public interface ApiService {
    @POST("/auth/taotaikhoan")
    Call<ResponseClass> addUser(@Body ResponseRegisterClass responseRegisterClass);

    @POST("/auth/dangnhap")
    Call<ResponseClass> getUser(@Body ResponseRegisterClass responseRegisterClass);

    @GET("/auth/foods")
    Call<List<ResponseFoodClass>> getAllFoods();

    @GET("/auth/foodtype")
    Call<List<ResFoodTypeClass>> getAllFoodType();
}
