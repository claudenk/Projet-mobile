package dao;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.formationapp.MyApplication;

import entity.Type;

public class TypeDao {


    @SuppressLint("Range")
    public static Type findTypeById(int typeId) {
        SQLiteDatabase db = MyApplication.getDbHelper().getReadableDatabase();
        Cursor cursor = db.query("Type", null, "id=?", new String[]{String.valueOf(typeId)}, null, null, null);

        Type type = null;
        if (cursor.moveToFirst()) {
            @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex("id"));
            @SuppressLint("Range") String libelle = cursor.getString(cursor.getColumnIndex("Libelle"));
            type = new Type(id, libelle);
        }
        cursor.close();
        db.close();
        return type;
    }
}