package com.myownprojects.manikandans.airlinestask.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.myownprojects.manikandans.airlinestask.R;
import com.myownprojects.manikandans.airlinestask.ui.HomeActivity;
import com.myownprojects.manikandans.airlinestask.ui.api.APIClient;
import com.myownprojects.manikandans.airlinestask.ui.api.APIResult;
import com.myownprojects.manikandans.airlinestask.ui.api.ConstantType;
import com.myownprojects.manikandans.airlinestask.ui.model.LoginRequestModel;
import com.myownprojects.manikandans.airlinestask.ui.model.LoginResponseModel;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by manikandans on 12/01/19.
 */

public class LoginFragment extends Fragment implements View.OnClickListener, APIResult{

    HomeActivity homeActivity;
    Context context;

    private EditText userName;
    private EditText password;
    private TextView signIn;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        homeActivity = (HomeActivity) context;
        this.context = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_fragment, container, false);

        userName = view.findViewById(R.id.username);
        password = view.findViewById(R.id.password);
        signIn = view.findViewById(R.id.signIn);

        signIn.setOnClickListener(this);

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void afterTextChanged(Editable s) {

                if(s.length() > 0){
                    if(userName != null && userName.getText().toString().trim().length() > 0){
                        signIn.setEnabled(true);
                        signIn.setBackground(getResources().getDrawable(R.drawable.button_shape));
                    }
                }
            }
        });

        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.signIn:
                homeActivity.showProgressDialog(context, "Signing In..", "Please Wait");
                new APIClient(context, this, null, ConstantType.CUSTOMER_LOGIN, null);
//                homeActivity.openFragment(new FlightListFragment(), true);
                break;
        }

    }

    @Override
    public void serviceResult(ConstantType constantType, Response response) {

        switch (constantType){
            case CUSTOMER_LOGIN:
                homeActivity.hideProgress();
                LoginResponseModel loginResponseModel = (LoginResponseModel) response.body();
                Log.e("Message>>",""+loginResponseModel.getSuccessMessage());

                if(userName.getText().toString().trim().equals(loginResponseModel.getData().getUserId())) {

                    homeActivity.openFragment(new FlightListFragment(), true);
                } else {
                    Snackbar snackbar = Snackbar.make(signIn, "Enter valid User ID", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }

                break;
        }

    }

    @Override
    public void serviceError(Call call, Throwable throwable) {
        homeActivity.hideProgress();
    }
}
