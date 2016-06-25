package com.jious.jious.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.jious.jious.objects.User;

/**
 * DatabaseUser saves user data upon registration.
 */
public class DatabaseUser extends SQLiteOpenHelper {
    public static final String TABLE_USERS = "users";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PASSWORD = "password";
//    public static final String COLUMN_BLOCK = "block";
//    public static final String COLUMN_UNIT = "unit";
//    public static final String COLUMN_STREET = "street";
    public static final String COLUMN_POSTCODE = "postcode";

    private static final String DATABASE_NAME = "customers.db";
    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    private static final String DATABASE_CREATE = "create table " + TABLE_USERS
            + "(" + COLUMN_USERNAME + " text not null, "
            + COLUMN_EMAIL + " text not null, "
            + COLUMN_PASSWORD + " text not null, "
//            + COLUMN_BLOCK + " text not null, "
//            + COLUMN_UNIT + " text not null, "
//            + COLUMN_STREET + " text not null, "
            + COLUMN_POSTCODE + " text not null)";

    public DatabaseUser(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DatabaseUser.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }

    public void createUser(User user) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME, user.getUsername());
        values.put(COLUMN_EMAIL, user.getEmail());
        values.put(COLUMN_PASSWORD, user.getPassword());
//        values.put(COLUMN_BLOCK, user.getBlock());
//        values.put(COLUMN_UNIT, user.getUnit());
//        values.put(COLUMN_STREET, user.getStreet());
        values.put(COLUMN_POSTCODE, user.getPostal());

        db.insert(TABLE_USERS, null, values);
        db.close();
    }

    public User readUser(String userName) {
        SQLiteDatabase db = this.getReadableDatabase();
        User user = null;
        Cursor cursor = db.query(TABLE_USERS, new String[] {COLUMN_USERNAME, COLUMN_EMAIL,
            COLUMN_PASSWORD, COLUMN_POSTCODE}, COLUMN_USERNAME + "=?",
                new String[] { userName }, null, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            user = new User(cursor.getString(0), cursor.getString(1), cursor.getString(2),
                    cursor.getString(3));
            cursor.close();
        }

        return user;
    }
}
