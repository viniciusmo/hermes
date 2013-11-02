package com.hermes.model.dao;

import android.database.sqlite.SQLiteDatabase;

import com.hermes.tools.ApplicationContext;

public class Database {

	public static final String NAME_OF_DB = "hermestcc10";

	public static DaoSession session() {
		SQLiteDatabase db = new DaoMaster.DevOpenHelper(
				ApplicationContext.context(), NAME_OF_DB, null)
				.getWritableDatabase();
		DaoMaster daoMaster = new DaoMaster(db);
		DaoSession daoSession = daoMaster.newSession();
		return daoSession;
	}

}
