package eu.bucior.babyneeds.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import eu.bucior.babyneeds.util.Constants;

public class DatabaseHandler extends SQLiteOpenHelper {

    private final Context context;

    public DatabaseHandler(@Nullable Context context) {
        super(context, Constants.DB_NAME, null, Constants.DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_BABY_TABLE = "CREATE TABLE " + Constants.TABLE_NAME + "("
                + Constants.KEY_ID + " INTEGER PRIMARY KEY,"
                + Constants.KEY_ITEM + " TEXT,"
                + Constants.KEY_COLOR + " TEXT, "
                + Constants.KEY_QUANTITY + " INTEGER,"
                + Constants.KEY_SIZE + " INTEGER,"
                + Constants.KEY_DATE_ADDED + " LONG);";

        db.execSQL(CREATE_BABY_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_NAME);
        onCreate(db);
    }
}
