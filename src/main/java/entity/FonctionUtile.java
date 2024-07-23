package entity;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class FonctionUtile {

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalDate convertStringToDate(String dateString){
        DateTimeFormatter formatter = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        }

        LocalDate date = null;
        try {
            // Conversion de la chaîne en LocalDate
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                date = LocalDate.parse(dateString, formatter);
            }
            System.out.println("Date convertie : " + date);
        } catch (DateTimeParseException e) {
            System.out.println("Erreur de conversion : " + e.getMessage());
            // Gérer l'exception selon vos besoins
        } return date;
    }
}


