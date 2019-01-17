package com.myownprojects.manikandans.airlinestask.ui.api;

import com.myownprojects.manikandans.airlinestask.ui.model.FlightListResponse;
import com.myownprojects.manikandans.airlinestask.ui.model.LoginRequestModel;
import com.myownprojects.manikandans.airlinestask.ui.model.LoginResponseModel;
import com.myownprojects.manikandans.airlinestask.ui.model.TopListResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by manikandans on 12/01/19.
 */

public interface APIInterface {

    @POST("5c3969422f00002b00b5db4b/")
    Call<LoginResponseModel> login();

    @POST("5c396b322f00007c00b5db4d/")
    Call<TopListResponse>getFlightList();


}
