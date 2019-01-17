package com.myownprojects.manikandans.airlinestask.ui.api;

import android.content.Context;
import android.util.Log;

import com.myownprojects.manikandans.airlinestask.base.AppController;
import com.myownprojects.manikandans.airlinestask.ui.HomeActivity;

import java.util.HashMap;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by manikandans on 13/01/19.
 */

public class APIClient<T> implements Callback<T>{

    private Context context;
    private HomeActivity baseActivity;
    private APIInterface apiService;
    private HashMap<String, String> mUrlValues;
    private RequestBody requestBody;
    private Call<T> call = null;
    private ConstantType constantType;
    APIResult apiResult;
    private String url = "http://www.mocky.io/v2/";


    public APIClient(Context context, APIResult apiResult, HashMap<String, String> mUrlValues, ConstantType constantType, RequestBody requestBody){ //need to create some more params

        this.context = context;
        this.baseActivity = (HomeActivity) context;
        this.apiResult = apiResult;
        this.mUrlValues = mUrlValues;
        this.constantType = constantType;
        this.requestBody = requestBody;

        serviceCall(constantType);

    }

    private void serviceCall(ConstantType constantType){
        apiService = ((AppController) context.getApplicationContext()).getClient(url).create(APIInterface.class);
        responseType(constantType);
    }

    private void responseType(ConstantType type){
        switch (type){
            case CUSTOMER_LOGIN:
                call = (Call<T>) apiService.login();
                break;
            case FLIGHT_LIST:
                call = (Call<T>) apiService.getFlightList();
                break;



        }
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        Log.e("Response", ">>"+response.toString());
        apiResult.serviceResult(constantType, response);

    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        Log.e("Error Reponse", ">>"+t.toString());
        apiResult.serviceError(call, t);
    }

    public void cancelRequest(){
        call.cancel();
    }
}
