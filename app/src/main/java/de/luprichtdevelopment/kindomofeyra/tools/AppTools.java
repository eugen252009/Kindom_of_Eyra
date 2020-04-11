package de.luprichtdevelopment.kindomofeyra.tools;

import android.app.Application;
import android.content.Context;

public class AppTools extends Application {
    private static Context context;

    public static Context getAppContext() {
        return AppTools.context;
    }

    public void onCreate() {
        super.onCreate();
        AppTools.context = getApplicationContext();
    }
    
    
}
