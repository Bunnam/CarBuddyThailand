package apprtc.pn.carbuddythailand;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by com on 30/12/2558.
 */
public class ManaggeTABLE {
    //Expilcit
    private  MyOpenHelper objMyOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase, readSqLiteDatabase;

    public static final String TABLE_PHONE ="phoneTABLE";
    public static final String COLUMN_ID ="_id";
    public static final String COLUMN_CATEGORY = "Category";
    public static final String COLUMN_NAME ="Name";
    public static final String COLUMN_PHONE ="Phone";

    public ManaggeTABLE(Context context) {

        //Create & Connected Database
        objMyOpenHelper = new MyOpenHelper(context);
        writeSqLiteDatabase = objMyOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMyOpenHelper.getReadableDatabase();

    }   //Constructor

    //Add New Value to SQLite
    public Long addNewValue(String StrCategory, String StrName, String strPhone) {

        ContentValues objContentValues = new ContentValues();
        objContentValues.put(COLUMN_CATEGORY, StrCategory);
        objContentValues.put(COLUMN_NAME, StrName);
        objContentValues.put(COLUMN_PHONE, strPhone);
        return writeSqLiteDatabase.insert(TABLE_PHONE, null,objContentValues);
    }


}   //Main Clss
