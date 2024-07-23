package dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.formationapp.MyApplication;

import entity.Role;

public class RoleDao {
    //Create

    @SuppressLint("Range")
    public static void saveRole(Role role){
        SQLiteDatabase db=
                MyApplication.getDbHelper().getWritableDatabase();
        ContentValues values= new ContentValues();
         values.put("roleName", role.getroleName());
         db.insert("Role", null, values);
         db.close();
    }
    //Read
    @SuppressLint("Range")
    public static Role findRoleById( int roleId) {
        Log.i("find", String.valueOf(roleId)) ;
        SQLiteDatabase db = MyApplication.getDbHelper().getReadableDatabase();
        Cursor cursor = db.query("Role", new String[]{"id", "roleName"}, "id=?", new String[]{String.valueOf(roleId)}, null, null, null);

        Role role = null;
        if (cursor != null && cursor.moveToFirst()) {
            role = new Role();
            role.setId(cursor.getInt(cursor.getColumnIndex("id")));
            role.setroleName(cursor.getString(cursor.getColumnIndex("RoleName")));
        }

        if (cursor != null) {
            cursor.close();
        }
        db.close();

        return role;
    }


    //Update
    @SuppressLint("Range")
    protected static int updateRole(Role role){
        SQLiteDatabase db= MyApplication.getDbHelper().getReadableDatabase();
        ContentValues values= new ContentValues();
        values.put("roleName", role.getroleName());
        int rowsAffected= db.update("Role", values,"id=?", new String[]{String.valueOf(role.getId())});
        db.close();
        return rowsAffected;
    }
    // Delete
    @SuppressLint("Range")
    public static void deleteRole( int roleId) {
        SQLiteDatabase db = MyApplication.getDbHelper().getWritableDatabase();
        db.delete("Role", "id=?", new String[]{String.valueOf((roleId))});
        db.close();

    }
}
