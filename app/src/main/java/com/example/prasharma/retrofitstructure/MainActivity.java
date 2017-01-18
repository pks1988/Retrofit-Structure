package com.example.prasharma.retrofitstructure;

import android.accounts.NetworkErrorException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.LinkedHashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import rest.RetrofitManager;
import rest.retro.service.RequestListener;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements RequestListener {

    LinkedHashMap<String, String> alMovieParams = new LinkedHashMap<>();
    RetrofitManager retrofitManager = null;
    @BindView(R.id.txtTest)
    TextView txtTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //register the retrofit for network call
        retrofitManager = RetrofitManager.getInstance();

        alMovieParams.put("t", "dangal");
        alMovieParams.put("y", "2016");
        alMovieParams.put("plot", "full");
        alMovieParams.put("r", "json");

        initApiCall();
    }

    private void initApiCall() {

        retrofitManager.apiCaller(this, MainActivity.this);

    }

    @Override
    public void onSuccess(Response response) {
        if (response.isSuccessful()) {
            txtTest.setText(new Gson().toJson(response));
        }
    }


    @Override
    public void onFailure(Throwable t) {

        if(t instanceof NetworkErrorException){
            txtTest.setText("Network exception");
        }else{
            txtTest.setText(t.getClass().getName());
        }

    }
}
