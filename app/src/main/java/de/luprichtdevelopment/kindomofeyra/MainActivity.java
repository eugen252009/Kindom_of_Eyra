package de.luprichtdevelopment.kindomofeyra;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;


public class MainActivity extends Activity {
    private Surface surface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        surface = new Surface(this);
        if (Build.VERSION.SDK_INT < 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        setContentView(surface);
    }
}



