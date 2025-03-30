package com.example.prog_mobile_tp3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.prog_mobile_tp3.exceptions.LoginRulesException;
import com.example.prog_mobile_tp3.exceptions.PasswordRulesException;
import com.example.prog_mobile_tp3.exceptions.UserAlreadyExistsException;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "user_info.db";
    private static final int DATABASE_VERSION = 2;

    private static final String TABLE_NAME = "users";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_LOGIN = "login";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_LASTNAME = "lastname";
    private static final String COLUMN_FIRSTNAME = "firstname";
    private static final String COLUMN_BIRTHDATE = "birthdate";
    private static final String COLUMN_PHONE = "phone";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_INTERESTS = "interests";
    private static final String COLUMN_PLANNING_8_10 = "planning_8_10";
    private static final String COLUMN_PLANNING_10_12 = "planning_10_12";
    private static final String COLUMN_PLANNING_14_16 = "planning_14_16";
    private static final String COLUMN_PLANNING_16_18 = "planning_16_18";
    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_LOGIN + " TEXT, " +
                    COLUMN_PASSWORD + " TEXT, " +
                    COLUMN_LASTNAME + " TEXT, " +
                    COLUMN_FIRSTNAME + " TEXT, " +
                    COLUMN_BIRTHDATE + " TEXT, " +
                    COLUMN_PHONE + " TEXT, " +
                    COLUMN_EMAIL + " TEXT, " +
                    COLUMN_INTERESTS + " TEXT, " +
                    COLUMN_PLANNING_8_10 + " TEXT, " +
                    COLUMN_PLANNING_10_12 + " TEXT, " +
                    COLUMN_PLANNING_14_16 + " TEXT, " +
                    COLUMN_PLANNING_16_18 + " TEXT" +
                    ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    private boolean loginCheck(String login) {
        return ((login.charAt(0) >= 'a' && login.charAt(0) <= 'z') || (login.charAt(0) >= 'A' && login.charAt(0) <= 'Z')) && login.length() <= 10;
    }

    private boolean passwordCheck(String password) {
        return password.length() >= 6;
    }

    public void insertUser(String login, String password, String lastname, String firstname, String birthdate, String phone, String email, String interests) throws UserAlreadyExistsException, LoginRulesException, PasswordRulesException {
        if (!loginCheck(login)) {
            throw new LoginRulesException();
        }
        if (!passwordCheck(password)) {
            throw new PasswordRulesException();
        }
        SQLiteDatabase db = this.getWritableDatabase();
        if (getUser(login, password) != null) {
            throw new UserAlreadyExistsException();
        }
        ContentValues values = new ContentValues();
        values.put(COLUMN_LOGIN, login);
        values.put(COLUMN_PASSWORD, password);
        values.put(COLUMN_LASTNAME, lastname);
        values.put(COLUMN_FIRSTNAME, firstname);
        values.put(COLUMN_BIRTHDATE, birthdate);
        values.put(COLUMN_PHONE, phone);
        values.put(COLUMN_EMAIL, email);
        values.put(COLUMN_INTERESTS, interests);
        values.put(COLUMN_PLANNING_8_10, "");
        values.put(COLUMN_PLANNING_10_12, "");
        values.put(COLUMN_PLANNING_14_16, "");
        values.put(COLUMN_PLANNING_16_18, "");
        db.insert(TABLE_NAME, null, values);
        db.close();
    }


    User getUser(String login, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[]{
                COLUMN_ID, COLUMN_LOGIN, COLUMN_PASSWORD, COLUMN_LASTNAME, COLUMN_FIRSTNAME, COLUMN_BIRTHDATE, COLUMN_PHONE, COLUMN_EMAIL, COLUMN_INTERESTS, COLUMN_PLANNING_8_10, COLUMN_PLANNING_10_12, COLUMN_PLANNING_14_16, COLUMN_PLANNING_16_18
        }, COLUMN_LOGIN + "=? AND " + COLUMN_PASSWORD + "=?", new String[]{login, password}, null, null, null, null);

        if (cursor.moveToFirst()) {
            User user = new User(
                    cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_LOGIN)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PASSWORD)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_LASTNAME)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_FIRSTNAME)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_BIRTHDATE)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PHONE)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_EMAIL)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_INTERESTS)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PLANNING_8_10)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PLANNING_10_12)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PLANNING_14_16)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PLANNING_16_18))
            );
            cursor.close();
            return user;
        }
        cursor.close();
        return null;
    }

    int logIn(String login, String password) throws LoginRulesException, PasswordRulesException {
        if (!loginCheck(login)) {
            throw new LoginRulesException();
        }
        if (!passwordCheck(password)) {
            throw new PasswordRulesException();
        }
        User user = getUser(login, password);
        if (user != null) {
            return user.getId();
        }
        return -1;
    }

    User getUser(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[]{
                COLUMN_ID, COLUMN_LOGIN, COLUMN_PASSWORD, COLUMN_LASTNAME, COLUMN_FIRSTNAME, COLUMN_BIRTHDATE, COLUMN_PHONE, COLUMN_EMAIL, COLUMN_INTERESTS, COLUMN_PLANNING_8_10, COLUMN_PLANNING_10_12, COLUMN_PLANNING_14_16, COLUMN_PLANNING_16_18
        }, COLUMN_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor.moveToFirst()) {
            User user = new User(
                    cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_LOGIN)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PASSWORD)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_LASTNAME)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_FIRSTNAME)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_BIRTHDATE)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PHONE)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_EMAIL)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_INTERESTS)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PLANNING_8_10)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PLANNING_10_12)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PLANNING_14_16)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PLANNING_16_18))
            );
            cursor.close();
            return user;
        }
        cursor.close();
        return null;
    }
}