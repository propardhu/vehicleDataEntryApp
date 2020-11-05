package com.example.dbms2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbManager extends SQLiteOpenHelper
{
    private static final String dbname="studentDesc.db";

    public DbManager( Context context )
    {
        super(context, dbname,null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String qry="create table tb1_student (id integer primary key autoincrement, name text,email text,course text)";
        db.execSQL(qry);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS tb1_student");
        onCreate(db);
    }
    public int addRecord(String p1, String p2, String p3)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("name",p1);
        cv.put("email",p2);
        cv.put("course",p3);
        long res=db.insert("tb1_student",null,cv);
        if (res==-1)
            return -1;
        else
            return 1;
    }
}
