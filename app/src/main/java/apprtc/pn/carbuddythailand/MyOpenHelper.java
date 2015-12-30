package apprtc.pn.carbuddythailand;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by com on 30/12/2558.
 */
public class MyOpenHelper extends SQLiteOpenHelper{

    //Exolicit
    public static final String DATABASE_NAME = "carbuddy.db";
    private static  final  int DATABASE_VERION = 1;
    private  static final  String CREATE_PHONE_TABLE ="create table phoneTABLE (" +
            "_id integer primary key, " +
            "Category text, " +
            "Name text, " +
            "Phone text);";

    public MyOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERION);
    } //Constructor

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_PHONE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
} //Main Class
