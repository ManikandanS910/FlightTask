package com.myownprojects.manikandans.airlinestask.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.Gson;
import com.myownprojects.manikandans.airlinestask.R;
import com.myownprojects.manikandans.airlinestask.ui.fragment.LoginFragment;

public class HomeActivity extends AppCompatActivity {

//    private FragmentTransaction fragmentTransaction;

    public Gson mGson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mGson = new Gson();

        openFragment(new LoginFragment(), false);

    }

    public void openFragment(Fragment fragment, boolean isAddToBackstack){

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.replace(R.id.content_frame, fragment, fragment.getClass().toString());
        if(isAddToBackstack)fragmentTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransaction.commit();

    }

    private ProgressDialog mProgressDialog;
    public void showProgressDialog(Context context, String title, String message){
        mProgressDialog = new ProgressDialog(context);
        mProgressDialog.setTitle(title);
        mProgressDialog.setMessage(message);
        mProgressDialog.setCancelable(false);
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mProgressDialog.show();
    }

    public void hideProgress(){
        if(mProgressDialog != null)mProgressDialog.hide();
    }

}
