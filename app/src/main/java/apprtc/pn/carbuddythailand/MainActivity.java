package apprtc.pn.carbuddythailand;

import android.database.sqlite.SQLiteDatabase;
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

        //Test Add Value
        //objManageTABLE.addNewValue("testCat", "testName","testPhone" );

        //Delete All Data
        deleteAllData();

        //Add Data to my SQLite
        addDataToSQLite();

    }   //Main Method

    private void addDataToSQLite() {

        //Get data
        String[] categoryStrings = MyData.CategorySTRINGS;
        String[] nameStrings = MyData.nameSTRINGS;
        String[] phoneStrings = MyData.phonSTRINGS;

        for (int i=0;i<categoryStrings.length;i++){
            objManageTABLE.addNewValue(categoryStrings[i], nameStrings[i], phoneStrings[i]);
        } //for

    }   //addDataToSQLite

    private void deleteAllData() {
        SQLiteDatabase objSqLiteDatabase = openOrCreateDatabase(MyOpenHelper.DATABASE_NAME, MODE_PRIVATE, null);
        objSqLiteDatabase.delete(ManaggeTABLE.TABLE_PHONE, null,null);
    }

} //Main Call
