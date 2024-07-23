package dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.formationapp.MyApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import entity.NoteTaxi;
import entity.Type;

public class NoteTaxiDao {
    // Create
    @SuppressLint("Range")
    public static void saveNoteTaxis(NoteTaxi noteTaxi) {
        SQLiteDatabase db = MyApplication.getDbHelper().getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("date", String.valueOf(noteTaxi.getDate()));
        values.put("montant", noteTaxi.getMontant());
        values.put("villeDepart", noteTaxi.getVilleDepart());
        values.put("villeArrivee", noteTaxi.getVilleArrivee());
        values.put("type", noteTaxi.getType().toString());
        // Utiliser l'id de l'utilisateur pour associer l'utilisateur à cette note de frais


        db.insert("NoteDeTaxi", null, values);
        db.close();
    }

    // Read (Single NoteTaxi)
    @RequiresApi(api = Build.VERSION_CODES.O)
    @SuppressLint("Range")
    public NoteTaxi findNoteTaxiById(int noteTaxiId) {
        SQLiteDatabase db = MyApplication.getDbHelper().getReadableDatabase();
        Cursor cursor = db.query("NoteDeTaxi", null, "id=?", new String[]{String.valueOf(noteTaxiId)}, null, null, null);

        NoteTaxi noteTaxi = null;
        if (cursor.moveToFirst()) {
            noteTaxi = new NoteTaxi();
            noteTaxi.setId(cursor.getInt(cursor.getColumnIndex("id")));
            noteTaxi.setDate(LocalDate.parse(cursor.getString(cursor.getColumnIndex("date"))));
            noteTaxi.setMontant(cursor.getDouble(cursor.getColumnIndex("montant")));
            noteTaxi.setVilleDepart(cursor.getString(cursor.getColumnIndex("villeDepart")));
            noteTaxi.setVilleArrivee(cursor.getString(cursor.getColumnIndex("villeArrivee")));
            noteTaxi.setType(Type.valueOf(cursor.getString(cursor.getColumnIndex("type"))));
            // Charger l'utilisateur associé à cette note de frais
            // noteTaxi.setUser(UserDao.findUserById(cursor.getInt(cursor.getColumnIndex("userId"))));
        }
        cursor.close();
        db.close();
        return noteTaxi;
    }

    // Read (All NoteTaxis)
    @RequiresApi(api = Build.VERSION_CODES.O)

    @SuppressLint("Range")
    public  List<NoteTaxi> findAllNoteTaxi() {
        List<NoteTaxi> allNoteTaxis = new ArrayList<>();
        SQLiteDatabase db = MyApplication.getDbHelper().getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM NoteDeTaxi", null);

        if (cursor.moveToFirst()) {
            do {
                NoteTaxi noteTaxi = new NoteTaxi();
                noteTaxi.setId(cursor.getInt(cursor.getColumnIndex("id")));

                    noteTaxi.setDate(LocalDate.parse(cursor.getString(cursor.getColumnIndex("date"))));

                noteTaxi.setMontant(cursor.getDouble(cursor.getColumnIndex("montant")));
                noteTaxi.setVilleDepart(cursor.getString(cursor.getColumnIndex("villeDepart")));
                noteTaxi.setVilleArrivee(cursor.getString(cursor.getColumnIndex("villeArrivee")));
                noteTaxi.setType(Type.valueOf(cursor.getString(cursor.getColumnIndex("type"))));
                // Charger l'utilisateur associé à cette note de frais
                // noteTaxi.setUser(UserDao.findUserById(cursor.getInt(cursor.getColumnIndex("userId"))));

                allNoteTaxis.add(noteTaxi);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return allNoteTaxis;
    }


    public static int updateNoteTaxi(NoteTaxi noteTaxi) {
        SQLiteDatabase db = MyApplication.getDbHelper().getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("date", String.valueOf(noteTaxi.getDate()));
        values.put("montant", noteTaxi.getMontant());
        values.put("villeDepart", noteTaxi.getVilleDepart());
        values.put("villeArrivee", noteTaxi.getVilleArrivee());
        values.put("type", noteTaxi.getType().toString());
        int rowsAffected = db.update("NoteTaxi", values, "id=?", new String[]{String.valueOf(noteTaxi.getId())});
        db.close();
        return rowsAffected;
    }

    // Delete
    public static void deleteNoteTaxi(int noteTaxiId) {
        SQLiteDatabase db = MyApplication.getDbHelper().getWritableDatabase();
        db.delete("NoteTaxi", "id=?", new String[]{String.valueOf(noteTaxiId)});
        db.close();
    }
}