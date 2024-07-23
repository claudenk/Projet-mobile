package dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.NonNull;

import com.example.formationapp.MyApplication;

import java.util.ArrayList;
import java.util.List;

import entity.Invites;

public class InvitesDao {
    // Create
    @SuppressLint("Range")
    public static void saveInvites(Invites invites) {
        SQLiteDatabase db = MyApplication.getDbHelper().getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id", invites.getId());
        // Utiliser l'id de la note de frais pour associer les invités à cette note de frais
        // values.put("noteDeFraisId", invites.getNoteDeFrais().getId());

        db.insert("Invites", null, values);
        db.close();
    }

    // Read (Single Invites)
    @SuppressLint("Range")
    public static Invites findInvitesById(int invitesId) {
        SQLiteDatabase db = MyApplication.getDbHelper().getReadableDatabase();
        Cursor cursor = db.query("Invites", null, "id=?", new String[]{String.valueOf(invitesId)}, null, null, null);

        Invites invites = null;
        if (cursor.moveToFirst()) {
            invites = new Invites();
            invites.setId(cursor.getInt(cursor.getColumnIndex("id")));
            // Charger la note de frais associée à ces invités
            // invites.setNoteDeFrais(NoteDeFraisDao.findNoteDeFraisById(cursor.getInt(cursor.getColumnIndex("noteDeFraisId"))));
        }
        cursor.close();
        db.close();
        return invites;
    }

    // Read (All Invites)
    @NonNull
    @SuppressLint("Range")
    public static List<Invites> findAllInvites() {
        List<Invites> allInvites = new ArrayList<>();
        SQLiteDatabase db = MyApplication.getDbHelper().getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Invites", null);

        if (cursor.moveToFirst()) {
            do {
                Invites invites = new Invites();
                invites.setId(cursor.getInt(cursor.getColumnIndex("id")));
                // Charger la note de frais associée à ces invités
                //invites.setNoteDeFrais(NoteDeFraisDao.findNoteDeFraisById(cursor.getInt(cursor.getColumnIndex("noteDeFraisId"))));

                allInvites.add(invites);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return allInvites;
    }}