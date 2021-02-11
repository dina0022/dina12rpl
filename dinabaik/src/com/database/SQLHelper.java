package com.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import com.model.Users;

public class SQLHelper extends SQLiteOpenHelper {

	Context context;
	String dbname;
	
	public SQLHelper(Context context, String name, CursorFactory factory, int version,
			DatabaseErrorHandler errorHandler) {
		super(context, name, factory, version, errorHandler); 
		this.context = context;
		this.dbname = name;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
	}
	
	public boolean insertContact (String name, String password, String email) {
	      SQLiteDatabase db = this.getWritableDatabase();
	      ContentValues contentValues = new ContentValues();
	      
	      contentValues.put(new Users().COLUMN_USERNAME_USER, name);
	      contentValues.put(new Users().COLUMN_PASSWORD_USER, password);
	      contentValues.put(new Users().COLUMN_TYPE_USER, email);	
	      
	      db.insert(new Users().TABLE_NAME, null, contentValues);
	      return true;
	   }
}