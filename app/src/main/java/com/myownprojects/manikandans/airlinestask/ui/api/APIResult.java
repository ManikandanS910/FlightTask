package com.myownprojects.manikandans.airlinestask.ui.api;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by manikandans on 12/01/19.
 */

public interface APIResult<T> {

    void serviceResult(ConstantType constantType, Response response);

    void serviceError(Call<T> call, Throwable throwable);
}
