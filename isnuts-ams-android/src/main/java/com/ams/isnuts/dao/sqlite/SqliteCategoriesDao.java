package com.ams.isnuts.dao.sqlite;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ams.isnuts.dao.CategoriesDao;
import com.ams.isnuts.model.Category;

public class SqliteCategoriesDao extends BaseSqliteDao implements CategoriesDao {

	private static final String CATEGORIES_TABLE = "categories";
	private static final String CATEGORY_ID_COLUMN = "category_id";
	private static final String CATEGORY_NAME_COLUMN = "name";

	public SqliteCategoriesDao(Context context) {
		super(context);
	}

	public void insertCategory(Category category) {
		ContentValues content = new ContentValues();
		content.put(CATEGORY_ID_COLUMN, category.getId());
		content.put(CATEGORY_NAME_COLUMN, category.getName());
		SQLiteDatabase database = getWritableDatabase();
		database.insert(CATEGORIES_TABLE, null, content);
		database.close();
	}

	public List<Category> getAllCategories() {
		Cursor cursor = getReadableDatabase().rawQuery("SELECT * FROM categories ORDER BY category_id", null);
		cursor.moveToFirst();
		List<Category> categories = new ArrayList<Category>();
		while(!cursor.isAfterLast()){
			Category category = new Category();
			category.setId(cursor.getInt(cursor.getColumnIndex(CATEGORY_ID_COLUMN)));
			category.setName(cursor.getString(cursor.getColumnIndex(CATEGORY_NAME_COLUMN)));
			categories.add(category);
			cursor.moveToNext();
		}
		cursor.close();
		return categories;
	}

	public Category getCategory(int id) {
		Cursor cursor = getReadableDatabase().rawQuery("SELECT * FROM categories WHERE category_id=?",new String[] {Integer.toString(id)});
		cursor.moveToFirst();
		Category category = new Category();
		while(!cursor.isAfterLast()) {
			category.setId(cursor.getInt(cursor.getColumnIndex(CATEGORY_ID_COLUMN)));
			category.setName(cursor.getString(cursor.getColumnIndex(CATEGORY_NAME_COLUMN)));
			cursor.moveToNext();
		}
		cursor.close();
		return category;
	}

}
