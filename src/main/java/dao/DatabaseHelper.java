package dao;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper{
// Nom de la base de données
    private static final String DATABASE_NAME="user.roles.db";

    // Version de la base de données
    private static final int DATABASE_VERSION=1;

// Commandes SQL pour créer les tables User et Role
    private static final String CREATE_TABLE_USER=
    "CREATE TABLE USER("+
    "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
    "nom TEXT NOT NULL,"+
    "prenom TEXT NOT NULL,"+
    "email TEXT UNIQUE NOT NULL,"+
    "password TEXT NOT NULL,"+
    "roleId INTEGER,"+
    "FOREIGN KEY (roleId) REFERENCES Role(id))";

    private static final String CREATE_TABLE_ROLE=
            "CREATE TABLE Role("+
                    "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    "roleName TEXT NOT NULL)";
    private static final String CREATE_TABLE_NOTEDEFRAIS="CREATE TABLE NoteDeFrais(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "date TEXT NOT NULL," +
            "montant TEXT NOT NULL," +
            "details TEXT NOT NULL," +
            "Listinvites TEXT,"+
            "nomSociete TEXT,"+
            "distance TEXT,"+
            "villeDepart TEXT,"+
            "villeArrivee TEXT,"+
            "nomClien TEXT,"+
            "type_id TEXT NOT NULL," +
            "NotesDeFrais_id INTEGER," +
            "FOREIGN KEY (type_id) REFERENCES type(id))";;
    private static final String CREATE_TABLE_TYPE="CREATE TABLE Type("+
            "           id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "            type TEXT NOT NULL)";

    private static final String CREATE_TABLE_INVITES ="CREATE TABLE Invites("+
            "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
            "Listinvites TEXT NOT NULL,"+
            "FOREIGN KEY (NoteDeFrais_id) REFERENCES NoteDeFrais(id))";


    // Constructeur
public DatabaseHelper(Context context) {
    super(context, DATABASE_NAME,null,DATABASE_VERSION);

}


   @Override
    public void onCreate(SQLiteDatabase db) {
    // Création des tables User et Role
       db.execSQL(CREATE_TABLE_ROLE);
       db.execSQL(CREATE_TABLE_USER);
       db.execSQL(CREATE_TABLE_TYPE);
       db.execSQL(CREATE_TABLE_NOTEDEFRAIS);
       db.execSQL(CREATE_TABLE_INVITES);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    // Ici vous pourrez gérer les mises à jour de votre schéma de base de données pour les nouvelles version
      if ( oldVersion < 2){
          db.execSQL(CREATE_TABLE_TYPE);
          db.execSQL(CREATE_TABLE_INVITES);
          db.execSQL(CREATE_TABLE_NOTEDEFRAIS);
          db.execSQL("INSERT INTO Type (type) VALUES ('Dejeuner');");
          db.execSQL("INSERT INTO Type (type) VALUES ('Hebergement');");
          db.execSQL("INSERT INTO Type (type) VALUES ('NoteTaxi');");
          db.execSQL("INSERT INTO Type (type) VALUES ('FraisKilometrique');");



          db.setVersion(2);
      }
    }

}
