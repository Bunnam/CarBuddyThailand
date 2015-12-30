package apprtc.pn.carbuddythailand;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by com on 30/12/2558.
 */
public class ManaggeTABLE {
    //Expilcit
    private  MyOpenHelper objMyOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase, readSqLiteDatabase;

    public ManaggeTABLE(Context context) {

        //Create & Connected Database
        objMyOpenHelper = new MyOpenHelper(context);
        writeSqLiteDatabase = objMyOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMyOpenHelper.getReadableDatabase();

    }   //Constructor

}   //Main Clss
