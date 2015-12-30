package apprtc.pn.carbuddythailand;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

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

        //ListView Controller
        ListViewController();


    } // Main Method

    private void ListViewController() {

        //Get Data From Database
        SQLiteDatabase objSqLiteDatabase = openOrCreateDatabase(MyOpenHelper.DATABASE_NAME,
                MODE_PRIVATE, null);
        Cursor objCursor = objSqLiteDatabase.rawQuery("SELECT * FROM phoneTABLE WHERE Category = " + "'" + selecString + "'" , null);

        objCursor.moveToFirst();
        final String[] nameStrings = new String[objCursor.getCount()];
        final String[] phoneStrings = new String[objCursor.getCount()];

        for (int i = 0; i < objCursor.getCount(); i++) {
            nameStrings[i] = objCursor.getString(objCursor.getColumnIndex(ManaggeTABLE.COLUMN_NAME));
            phoneStrings[i] = objCursor.getString(objCursor.getColumnIndex(ManaggeTABLE.COLUMN_PHONE));
            objCursor.moveToNext();
        }   //for
        objCursor.close();

        //Create ListView
        MyAdapter objMyAdapter = new MyAdapter(DetailActivity.this, phoneStrings, nameStrings);
        ListView nameListView = (ListView) findViewById(R.id.listView);
        nameListView.setAdapter(objMyAdapter);

        //Active When Click
        nameListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                confirmCall(nameStrings[i], phoneStrings[i]);

            }   //event
        });


    }   //ListViewConttorller

    private void confirmCall(String nameString, final String phoneString) {

        AlertDialog.Builder objBuilder = new AlertDialog.Builder(this);
        objBuilder.setIcon(R.drawable.icon_phone);
        objBuilder.setTitle(nameString);
        objBuilder.setMessage("คุณต้องการโทรไปที่ " + phoneString + "จริงๆ หรือ?");
        objBuilder.setCancelable(false);
        objBuilder.setPositiveButton("โทร", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                myPhone(phoneString);
                dialogInterface.dismiss();

            }
        });
        objBuilder.setNegativeButton("ยกเลิก", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        objBuilder.show();

    }   //confirmCall

    private void myPhone(String phoneString) {

    }

}// Main Class
