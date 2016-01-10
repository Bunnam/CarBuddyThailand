package apprtc.pn.carbuddythailand;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Explicit
    private ManaggeTABLE objManageTABLE;
    private ImageView imageView0, imageView1, imageView2, imageView3,
            imageView4, imageView5, imageView6, imageView7, imageView8,
            imageView9, imageView10,imageView11,imageView12,imageView13,imageView14,imageView15;
    private EditText searchEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind Widget
        bindWidget();

        //Setup Constructor
        objManageTABLE = new ManaggeTABLE(this);

        //Test Add Value
        //objManageTABLE.addNewValue("testCat", "testName", "testPhone");

        //Delete All Data
        deleteAllData();

        //Add Data to my SQLite
        addDataToSQLite();

        //ImageView Controller
        imageViewController();

    }   // Main Method

    public void clickSearch(View view) {

        String strSearch = searchEditText.getText().toString().trim();

        if (strSearch.equals("")) {
            Toast.makeText(MainActivity.this, "กรุณาพิมพ์คำที่ต้องการค้นหา", Toast.LENGTH_SHORT).show();
        } else {

            searchName(strSearch);

        }

    }   // clickSearch

    private void searchName(String strSearch) {

        try {

            String[] resultStrings = objManageTABLE.searchName(strSearch);

            confirmCall(strSearch, resultStrings[3]);

        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "ไม่มี " + strSearch + " ในฐานข้อมูล", Toast.LENGTH_SHORT).show();
        }

    }   // searchName

    private void confirmCall(String strName, final String resultString) {
        AlertDialog.Builder objBuilder = new AlertDialog.Builder(this);
        objBuilder.setIcon(R.drawable.icon_phone);
        objBuilder.setTitle(strName);
        objBuilder.setMessage("คุณต้องการโทรไปที่ " + resultString);
        objBuilder.setPositiveButton("โทร", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                intentToCall(resultString);
                dialogInterface.dismiss();
            }
        });
        objBuilder.setNegativeButton("ไม่โทร", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        objBuilder.show();

    }

    private void intentToCall(String resultString) {
        Intent objIntent = new Intent(Intent.ACTION_DIAL);
        objIntent.setData(Uri.parse("tel:" + resultString));
        startActivity(objIntent);
    }

    private void imageViewController() {

        imageView0.setOnClickListener(this);
        imageView1.setOnClickListener(this);
        imageView2.setOnClickListener(this);
        imageView3.setOnClickListener(this);
        imageView4.setOnClickListener(this);
        imageView5.setOnClickListener(this);
        imageView6.setOnClickListener(this);
        imageView7.setOnClickListener(this);
        imageView8.setOnClickListener(this);
        imageView9.setOnClickListener(this);
        imageView10.setOnClickListener(this);
        imageView11.setOnClickListener(this);
        imageView12.setOnClickListener(this);
        imageView13.setOnClickListener(this);
        imageView14.setOnClickListener(this);
        imageView15.setOnClickListener(this);


    }   // imageViewController

    private void bindWidget() {

        imageView0 = (ImageView) findViewById(R.id.imageView);
        imageView1 = (ImageView) findViewById(R.id.imageView2);
        imageView2 = (ImageView) findViewById(R.id.imageView3);
        imageView3 = (ImageView) findViewById(R.id.imageView4);
        imageView4 = (ImageView) findViewById(R.id.imageView5);
        imageView5 = (ImageView) findViewById(R.id.imageView6);
        imageView6 = (ImageView) findViewById(R.id.imageView7);
        imageView7 = (ImageView) findViewById(R.id.imageView8);
        imageView8 = (ImageView) findViewById(R.id.imageView9);
        imageView9 = (ImageView) findViewById(R.id.imageView10);
        imageView10 = (ImageView) findViewById(R.id.imageView11);
        imageView11 = (ImageView) findViewById(R.id.imageView12);
        imageView12 = (ImageView) findViewById(R.id.imageView13);
        imageView13 = (ImageView) findViewById(R.id.imageView14);
        imageView14 = (ImageView) findViewById(R.id.imageView15);
        imageView15 = (ImageView) findViewById(R.id.imageView16);

        searchEditText = (EditText) findViewById(R.id.editText);

    }   // bindWidget

    private void addDataToSQLite() {

        //Get data
        String[] categoryStrings = MyData.CategorySTRINGS;
        String[] nameStrings = MyData.nameSTRINGS;
        String[] phoneStrings = MyData.phonSTRINGS;

        for (int i = 0; i < categoryStrings.length; i++) {
            objManageTABLE.addNewValue(categoryStrings[i], nameStrings[i], phoneStrings[i]);
        }   //for

    }   // addDataToSQLite

    private void deleteAllData() {
        SQLiteDatabase objSqLiteDatabase = openOrCreateDatabase(MyOpenHelper.DATABASE_NAME, MODE_PRIVATE, null);
        objSqLiteDatabase.delete(ManaggeTABLE.TABLE_PHONE, null, null);
    }

    @Override
    public void onClick(View view) {

        String[] strSelect = MyData.mainCat;

        switch (view.getId()) {

            case R.id.imageView:
                myIntent(strSelect[0]);
                break;
            case R.id.imageView2:
                myIntent(strSelect[1]);
                break;
            case R.id.imageView3:
                myIntent(strSelect[2]);
                break;
            case R.id.imageView4:
                myIntent(strSelect[3]);
                break;
            case R.id.imageView5:
                myIntent(strSelect[4]);
                break;
            case R.id.imageView6:
                myIntent(strSelect[5]);
                break;
            case R.id.imageView7:
                myIntent(strSelect[6]);
                break;
            case R.id.imageView8:
                myIntent(strSelect[7]);
                break;
            case R.id.imageView9:
                myIntent(strSelect[8]);
                break;
            case R.id.imageView10:
                myIntent(strSelect[9]);
                break;
            case R.id.imageView11:
                myIntent(strSelect[10]);
                break;
            case R.id.imageView12:
                myIntent(strSelect[11]);
                break;
            case R.id.imageView13:
                myIntent(strSelect[12]);
                break;
            case R.id.imageView14:
                myIntent(strSelect[13]);
                break;
            case R.id.imageView15:
                myIntent(strSelect[14]);
                break;
            case R.id.imageView16:
                myIntent(strSelect[15]);
                break;

        }   //switch

    }   // onClick

    private void myIntent(String strSelect) {
        Intent objIntent = new Intent(MainActivity.this, DetailActivity.class);
        objIntent.putExtra("Select", strSelect);
        startActivity(objIntent);
    }

}   // Main Class