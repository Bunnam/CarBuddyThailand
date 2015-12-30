package apprtc.pn.carbuddythailand;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    //Explict
    private ManaggeTABLE objManageTABLE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setup Constructor
        objManageTABLE = new ManaggeTABLE(this);

    }   //Main Method

} //Main Call
