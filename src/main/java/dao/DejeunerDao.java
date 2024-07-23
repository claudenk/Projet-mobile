package dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.NonNull;

import com.example.formationapp.MyApplication;

import java.util.ArrayList;
import java.util.List;

import entity.Dejeuner;

public class DejeunerDao {

    // Create
    public static void saveDejeuner(Dejeuner dejeuner) {
        SQLiteDatabase db = MyApplication.getDbHelper().getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("type", dejeuner.getType().toString());
        values.put("nomSociete", dejeuner.getNomSociete());

        values.put("invites", convertListInvitesToString(dejeuner.getInvites()));

        db.insert("Dejeuner", null, values);
        db.close();
    }

    private static String convertListInvitesToString(String invites) {
        return null;
    }

    // Read (Single Dejeuner)
    @SuppressLint("Range")
    public Dejeuner findDejeunerById(int dejeunerId) {
        SQLiteDatabase db = MyApplication.getDbHelper().getReadableDatabase();
        Cursor cursor = db.query("Dejeuner", null, "id=?", new String[]{String.valueOf(dejeunerId)}, null, null, null);

        Dejeuner dejeuner = null;
        if (cursor.moveToFirst()) {
            dejeuner = new Dejeuner();
            dejeuner.setId(cursor.getInt(cursor.getColumnIndex("id")));
            dejeuner.setType(cursor.getString(cursor.getColumnIndex("type")));
            dejeuner.setNomSociete(cursor.getString(cursor.getColumnIndex("nomSociete")));
            // Conversion de la chaîne JSON ou autre format stocké dans la base de données
            // en une liste d'invités appropriée
            dejeuner.setInvites(convertStringToListInvites(cursor.getString(cursor.getColumnIndex("invites"))));
        }
        cursor.close();
        db.close();
        return dejeuner;
    }

    // Read (All Dejeuners)
    @NonNull
    @SuppressLint("Range")
    public static List<Dejeuner> findAllDejeuners() {
        List<Dejeuner> dejeuners = new ArrayList<>();
        SQLiteDatabase db = MyApplication.getDbHelper().getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Dejeuner", null);

        if (cursor.moveToFirst()) {
            do {
                Dejeuner dejeuner = new Dejeuner();
                dejeuner.setId(cursor.getInt(cursor.getColumnIndex("id")));
                dejeuner.setType(cursor.getString(cursor.getColumnIndex("type")));
                dejeuner.setNomSociete(cursor.getString(cursor.getColumnIndex("nomSociete")));

                dejeuner.setInvites(convertStringToListInvites(cursor.getString(cursor.getColumnIndex("invites"))));

                dejeuners.add(dejeuner);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return dejeuners;
    }

    private static String convertStringToListInvites(String invites) {
        return invites;
    }

    // Update
    public static int updateDejeuner(Dejeuner dejeuner) {
        SQLiteDatabase db = MyApplication.getDbHelper().getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("type", dejeuner.getType().toString());
        values.put("nomSociete", dejeuner.getNomSociete());
        values.put("invites", convertListInvitesToString(dejeuner.getInvites()));

        int rowsAffected = db.update("Dejeuner", values, "id=?", new String[]{String.valueOf(dejeuner.getId())});
        db.close();
        return rowsAffected;
    }

    // Delete
    public static void deleteDejeuner(int dejeunerId) {
        SQLiteDatabase db = MyApplication.getDbHelper().getWritableDatabase();
        db.delete("Dejeuner", "id=?", new String[]{String.valueOf(dejeunerId)});
        db.close();
    }

}