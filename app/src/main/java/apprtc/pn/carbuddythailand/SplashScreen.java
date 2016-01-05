package apprtc.pn.carbuddythailand;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by com on 3/1/2559.
 */
public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_splash_screen);

        Handler objHandler = new Handler();
        objHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent obIntent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(obIntent);
                finish();

            }
        }, 5000);
        //MediaPlayer intrMediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.intro_tata);

    }//Main Method
} //Main Class