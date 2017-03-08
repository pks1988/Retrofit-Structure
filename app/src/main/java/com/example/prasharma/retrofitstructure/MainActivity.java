package com.example.prasharma.retrofitstructure;

import android.accounts.NetworkErrorException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.LinkedHashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import rest.RetrofitManager;
import rest.RequestListener;
import retrofit2.Response;
import util.Constants;

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

        retrofitManager.apiCaller(this, MainActivity.this, Constants.API_TYPE.MOVIE_DETAILS);

    }


    @Override
    public void onSuccess(Response<ResponseBody> response, Constants.API_TYPE apiType) {

        if(apiType== Constants.API_TYPE.MOVIE_DETAILS){
//            txtTest.setText(new Gson().toJson(response));
            txtTest.setText(apiType.toString());

        }else{
            txtTest.setText("not the api type");
        }


    }

    @Override
    public void onFailure(Throwable t, Constants.API_TYPE apiType) {
        if(t instanceof NetworkErrorException){
            txtTest.setText("Network exception");
        }else{
            txtTest.setText(t.getClass().getName());
        }
    }
}
