package apprtc.pn.carbuddythailand;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class DetailActivity extends AppCompatActivity {

    // Explicit
    public String TAG = "Carbuddy";
    private  String selecString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Receive Value From Intent
        selecString = getIntent().getStringExtra("Select");
        Log.d(TAG,"Select="+selecString);

    } // Main Method

}// Main Class
