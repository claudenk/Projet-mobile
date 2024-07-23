package com.example.formationapp;

import android.app.Application;


import dao.DatabaseHelper;

    public class MyApplication extends Application {
        private static DatabaseHelper dbHelper;
        @Override
        public void onCreate(){
            super.onCreate();
// Initialiser votre base de Données ici
            dbHelper= new DatabaseHelper(getApplicationContext());
/*Role role1 = new Role();
role1.setroleName("ROLE_USER");
Role role2 = new Role() ;
role2.setroleName("ROLE_ADMIN");
        RoleDao.saveRole(role1);
        RoleDao.saveRole(role2);*/
            dbHelper.getWritableDatabase();
        }

        public static DatabaseHelper getDbHelper(){
            return dbHelper;
        }

        public static void setDbHelper(DatabaseHelper dbHelper){
MyApplication.dbHelper=dbHelper;
}
}