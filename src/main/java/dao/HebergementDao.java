package dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;

import androidx.annotation.NonNull;

import com.example.formationapp.MyApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import entity.Hebergement;
import entity.Type;

public class HebergementDao {
private static UserDao userDao;
private static Hebergement hebergement;
    public HebergementDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public static void saveHebergement(Hebergement hebergement) {
        SQLiteDatabase db = MyApplication.getDbHelper().getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("date", String.valueOf(hebergement.getDate()));
        values.put("montant", hebergement.getMontant());
        values.put("distance", hebergement.getDistance());
        values.put("type", hebergement.getType().toString());
        // Utiliser l'id de l'utilisateur pour associer l'utilisateur à cette note de frais


        db.insert("Hebergement", null, values);
        db.close();
    }

    // Read (Single Hebergement)
    @SuppressLint("Range")
    public Hebergement findHebergementById(int hebergementId) {
        SQLiteDatabase db = MyApplication.getDbHelper().getReadableDatabase();
        Cursor cursor = db.query("Hebergement", null, "id=?", new String[]{String.valueOf(hebergementId)}, null, null, null);

        Hebergement hebergement = null;
        if (cursor.moveToFirst()) {
            hebergement = new Hebergement();
            hebergement.setId(cursor.getInt(cursor.getColumnIndex("id")));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                hebergement.setDate(LocalDate.parse(cursor.getString(cursor.getColumnIndex("date"))));
            }
            hebergement.setMontant(cursor.getDouble(cursor.getColumnIndex("montant")));
            hebergement.setDistance(cursor.getInt(cursor.getColumnIndex("distance")));
            hebergement.setType(Type.valueOf(cursor.getString(cursor.getColumnIndex("type"))));
            // Charger l'utilisateur associé à cette note de frais
        }
        cursor.close();
        db.close();
        return hebergement;
    }

    // Read (All Hebergements)
    @NonNull
    @SuppressLint("Range")
    public static List<Hebergement> findAllHebergements() {
        List<Hebergement> hebergements = new ArrayList<>();
        SQLiteDatabase db = MyApplication.getDbHelper().getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Hebergement", null);

        if (cursor.moveToFirst()) {
            do {
                Hebergement hebergement = new Hebergement();
                hebergement.setId(cursor.getInt(cursor.getColumnIndex("id")));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    hebergement.setDate(LocalDate.parse(cursor.getString(cursor.getColumnIndex("date"))));
                }
                hebergement.setMontant(cursor.getDouble(cursor.getColumnIndex("montant")));
                hebergement.setDistance(cursor.getInt(cursor.getColumnIndex("distance")));
                hebergement.setType(Type.valueOf(cursor.getString(cursor.getColumnIndex("type"))));
                // Charger l'utilisateur associé à cette note de frais

                hebergements.add(hebergement);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return hebergements;
    }

    // Update
    @SuppressLint("Range")

    public static int updateHebergement(Hebergement hebergement) {
        SQLiteDatabase db = MyApplication.getDbHelper().getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("date", String.valueOf(hebergement.getDate()));
        values.put("montant", hebergement.getMontant());
        values.put("distance", hebergement.getDistance());
        values.put("type", hebergement.getType().toString());

        int rowsAffected = db.update("Hebergement", values, "id=?", new String[]{String.valueOf(hebergement.getId())});
        db.close();
        return rowsAffected;
    }

    // Delete
    @SuppressLint("Range")
    public static void deleteHebergement(int hebergementId) {
        SQLiteDatabase db = MyApplication.getDbHelper().getWritableDatabase();
        db.delete("Hebergement", "id=?", new String[]{String.valueOf(hebergementId)});
        db.close();
    }
}
