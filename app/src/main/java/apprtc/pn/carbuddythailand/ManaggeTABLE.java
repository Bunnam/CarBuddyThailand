package apprtc.pn.carbuddythailand;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by com on 30/12/2558.
 */
public class ManaggeTABLE {
    //Expilcit
    private MyOpenHelper objMyOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase, readSqLiteDatabase;

    public static final String TABLE_PHONE = "phoneTABLE";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_CATEGORY = "Category";
    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_PHONE = "Phone";

    public ManaggeTABLE(Context context) {

        //Create & Connected Database
        objMyOpenHelper = new MyOpenHelper(context);
        writeSqLiteDatabase = objMyOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMyOpenHelper.getReadableDatabase();

    }   //Constructor

    public String[] searchName(String StrName) {

        try {

            String[] resultStrings = null;
            Cursor objCursor = readSqLiteDatabase.query(TABLE_PHONE,
                    new String[]{COLUMN_ID, COLUMN_CATEGORY, COLUMN_NAME, COLUMN_PHONE},
                    COLUMN_NAME + "=?",
                    new String[]{String.valueOf(StrName)},
                    null, null, null, null);

            if (objCursor != null) {
                if (objCursor.moveToFirst()) {

                    resultStrings = new String[4];
                    resultStrings[0] = objCursor.getString(0);
                    resultStrings[1] = objCursor.getString(1);
                    resultStrings[2] = objCursor.getString(2);
                    resultStrings[3] = objCursor.getString(3);


                }//if
            }   //if
            objCursor.close();
            return resultStrings;

        } catch (Exception e) {
            return null;

        }

        //return new String[0];
    }

    //Add New Value to SQLite
    public Long addNewValue(String StrCategory, String StrName, String strPhone) {

        ContentValues objContentValues = new ContentValues();
        objContentValues.put(COLUMN_CATEGORY, StrCategory);
        objContentValues.put(COLUMN_NAME, StrName);
        objContentValues.put(COLUMN_PHONE, strPhone);
        return writeSqLiteDatabase.insert(TABLE_PHONE, null, objContentValues);
    }


}   //Main Clss
