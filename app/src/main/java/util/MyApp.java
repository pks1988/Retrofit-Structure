package util;

import android.app.Application;
import android.content.Context;

/**
 * Created by prasharma on 1/16/2017.
 */

public class MyApp extends Application {
    private static MyApp instance;

    public static MyApp getInstance() {
        return instance;
    }

    public static Context getContext() {
        return instance;
    }

    @Override
    public void onCreate() {
        instance = this;
        super.onCreate();
    }
}