package com.example.dula;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "/storage/emulated/0/Android/data/Dula/Databases/DulaPeepa"; //db name
    //public static final String DATABASE_NAME = "DulaPeepa"; //db name

    public static final String TABLE_TOP100 = "TABLE_TOP100"; //table name
    public static final String TABLE_TOP1000 = "TABLE_TOP1000"; //table name
    public static final String TABLE_IRREGULAR = "TABLE_IRREGULAR"; //table name
    public static final String TABLE_ROUTINE = "TABLE_ROUTINE"; //table name
    public static final String TABLE_FAVORITE = "TABLE_FAVORITE"; //table name
    public static final String TABLE_IDIOMS = "TABLE_IDIOMS"; //table name
    public static final String TABLE_SLANG = "TABLE_SLANG"; //table name
    public static final String TABLE_CLOTHES = "TABLE_CLOTHES"; //table name
    public static final String TABLE_IT = "TABLE_IT"; //table name
    public static final String TABLE_HEALTH = "TABLE_HEALTH"; //table name
    public static final String TABLE_NATURE = "TABLE_NATURE"; //table name
    public static final String TABLE_PHRASAL = "TABLE_PHRASAL";
    public static final String TABLE_COLORS = "TABLE_COLORS"; //table name
    public static final String TABLE_HUMAN = "TABLE_HUMAN"; //table name
    public static final String TABLE_INTERMEDIATE = "TABLE_INTERMEDIATE"; //table name
    public static final String TABLE_ADJECTIVES = "TABLE_ADJECTIVES";

    public static final String KEY_ID = "_id"; //parametres of database
    public static final String KEY_EN_WORD = "en_word";
    public static final String KEY_TRANSCRIPTION = "transcription";
    public static final String KEY_RU_WORD = "ru_word";
    public static final String KEY_EXAMPLES_RU = "examples_ru";
    public static final String KEY_EXAMPLES_EN = "examples_en";
    public static final String KEY_PROGRESS = "_progress";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_TOP100 +
                "(" + KEY_ID + " integer primary key, "
                + KEY_RU_WORD + " text, "
                + KEY_EN_WORD + " text, "
                + KEY_EXAMPLES_EN + " text, "
                + KEY_EXAMPLES_RU + " text, "
                + KEY_TRANSCRIPTION + " text, "
                + KEY_PROGRESS + " integer)");

        db.execSQL("create table " + TABLE_TOP1000 +
                "(" + KEY_ID + " integer primary key, "
                + KEY_RU_WORD + " text, "
                + KEY_EN_WORD + " text, "
                + KEY_EXAMPLES_EN + " text, "
                + KEY_EXAMPLES_RU + " text, "
                + KEY_TRANSCRIPTION + " text, "
                + KEY_PROGRESS + " integer)");

        db.execSQL("create table " + TABLE_IRREGULAR +
                "(" + KEY_ID + " integer primary key, "
                + KEY_RU_WORD + " text, "
                + KEY_EN_WORD + " text, "
                + KEY_EXAMPLES_EN + " text, "
                + KEY_EXAMPLES_RU + " text, "
                + KEY_TRANSCRIPTION + " text, "
                + KEY_PROGRESS + " integer)");

        db.execSQL("create table " + TABLE_ROUTINE +
                "(" + KEY_ID + " integer primary key, "
                + KEY_RU_WORD + " text, "
                + KEY_EN_WORD + " text, "
                + KEY_EXAMPLES_EN + " text, "
                + KEY_EXAMPLES_RU + " text, "
                + KEY_TRANSCRIPTION + " text, "
                + KEY_PROGRESS + " integer)");

        db.execSQL("create table " + TABLE_FAVORITE +
                "(" + KEY_ID + " integer primary key, "
                + KEY_RU_WORD + " text, "
                + KEY_EN_WORD + " text, "
                + KEY_EXAMPLES_EN + " text, "
                + KEY_EXAMPLES_RU + " text, "
                + KEY_TRANSCRIPTION + " text, "
                + KEY_PROGRESS + " integer)");

        db.execSQL("create table " + TABLE_IDIOMS +
                "(" + KEY_ID + " integer primary key, "
                + KEY_EN_WORD + " text, "
                + KEY_RU_WORD + " text, "
                + KEY_EXAMPLES_RU + " text, "
                + KEY_EXAMPLES_EN + " text, "
                + KEY_PROGRESS + " integer)");


        db.execSQL("create table " + TABLE_SLANG +
                "(" + KEY_ID + " integer primary key, "
                + KEY_RU_WORD + " text, "
                + KEY_EN_WORD + " text, "
                + KEY_EXAMPLES_EN + " text, "
                + KEY_EXAMPLES_RU + " text, "
                + KEY_TRANSCRIPTION + " text, "
                + KEY_PROGRESS + " integer)");


        db.execSQL("create table " + TABLE_CLOTHES +
                "(" + KEY_ID + " integer primary key, "
                + KEY_RU_WORD + " text, "
                + KEY_EN_WORD + " text, "
                + KEY_EXAMPLES_EN + " text, "
                + KEY_EXAMPLES_RU + " text, "
                + KEY_TRANSCRIPTION + " text, "
                + KEY_PROGRESS + " integer)");

        db.execSQL("create table " + TABLE_IT +
                "(" + KEY_ID + " integer primary key, "
                + KEY_RU_WORD + " text, "
                + KEY_EN_WORD + " text, "
                + KEY_EXAMPLES_EN + " text, "
                + KEY_EXAMPLES_RU + " text, "
                + KEY_TRANSCRIPTION + " text, "
                + KEY_PROGRESS + " integer)");

        db.execSQL("create table " + TABLE_HEALTH +
                "(" + KEY_ID + " integer primary key, "
                + KEY_RU_WORD + " text, "
                + KEY_EN_WORD + " text, "
                + KEY_EXAMPLES_EN + " text, "
                + KEY_EXAMPLES_RU + " text, "
                + KEY_TRANSCRIPTION + " text, "
                + KEY_PROGRESS + " integer)");


        db.execSQL("create table " + TABLE_NATURE +
                "(" + KEY_ID + " integer primary key, "
                + KEY_RU_WORD + " text, "
                + KEY_EN_WORD + " text, "
                + KEY_EXAMPLES_EN + " text, "
                + KEY_EXAMPLES_RU + " text, "
                + KEY_TRANSCRIPTION + " text, "
                + KEY_PROGRESS + " integer)");


        db.execSQL("create table " + TABLE_PHRASAL +
                "(" + KEY_ID + " integer primary key, "
                + KEY_RU_WORD + " text, "
                + KEY_EN_WORD + " text, "
                + KEY_EXAMPLES_EN + " text, "
                + KEY_EXAMPLES_RU + " text, "
                + KEY_TRANSCRIPTION + " text, "
                + KEY_PROGRESS + " integer)");


        db.execSQL("create table " + TABLE_COLORS +
                "(" + KEY_ID + " integer primary key, "
                + KEY_RU_WORD + " text, "
                + KEY_EN_WORD + " text, "
                + KEY_EXAMPLES_EN + " text, "
                + KEY_EXAMPLES_RU + " text, "
                + KEY_TRANSCRIPTION + " text, "
                + KEY_PROGRESS + " integer)");


        db.execSQL("create table " + TABLE_HUMAN +
                "(" + KEY_ID + " integer primary key, "
                + KEY_RU_WORD + " text, "
                + KEY_EN_WORD + " text, "
                + KEY_EXAMPLES_EN + " text, "
                + KEY_EXAMPLES_RU + " text, "
                + KEY_TRANSCRIPTION + " text, "
                + KEY_PROGRESS + " integer)");


        db.execSQL("create table " + TABLE_INTERMEDIATE +
                "(" + KEY_ID + " integer primary key, "
                + KEY_RU_WORD + " text, "
                + KEY_EN_WORD + " text, "
                + KEY_EXAMPLES_EN + " text, "
                + KEY_EXAMPLES_RU + " text, "
                + KEY_TRANSCRIPTION + " text, "
                + KEY_PROGRESS + " integer)");


        db.execSQL("create table " + TABLE_ADJECTIVES +
                "(" + KEY_ID + " integer primary key, "
                + KEY_RU_WORD + " text, "
                + KEY_EN_WORD + " text, "
                + KEY_EXAMPLES_EN + " text, "
                + KEY_EXAMPLES_RU + " text, "
                + KEY_TRANSCRIPTION + " text, "
                + KEY_PROGRESS + " integer)");

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists " + TABLE_TOP100);

        db.execSQL("drop Table if exists " + TABLE_TOP1000);
        db.execSQL("drop Table if exists " + TABLE_IRREGULAR);
        db.execSQL("drop Table if exists " + TABLE_ROUTINE);
        db.execSQL("drop Table if exists " + TABLE_FAVORITE);
        db.execSQL("drop Table if exists " + TABLE_IDIOMS);
        db.execSQL("drop Table if exists " + TABLE_SLANG);
        db.execSQL("drop Table if exists " + TABLE_CLOTHES);
        db.execSQL("drop Table if exists " + TABLE_IT);
        db.execSQL("drop Table if exists " + TABLE_HEALTH);
        db.execSQL("drop Table if exists " + TABLE_NATURE);
        db.execSQL("drop Table if exists " + TABLE_PHRASAL);
        db.execSQL("drop Table if exists " + TABLE_COLORS);
        db.execSQL("drop Table if exists " + TABLE_HUMAN);
        onCreate(db);
    }

}


//package com.example.dula;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
//import androidx.annotation.Nullable;
//
//import java.sql.Connection;
//import java.sql.DatabaseMetaData;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class DBHelper extends SQLiteOpenHelper {
//    public DBHelper(Context context) {
//        super(context, "/storage/emulated/0/Userdata.db", null, 1);
//    }
//    @Override
//    public void onCreate(SQLiteDatabase DB) {
//        DB.execSQL("create Table Userdetails(" +
//                "ru_word TEXT, " +
//                "en_word TEXT, " +
//                "transcript TEXT)");
//    }
//    @Override
//    public void onUpgrade(SQLiteDatabase DB, int i, int ii) {
//        DB.execSQL("drop Table if exists Userdetails");
//    }
//
//    //private Connection connect() {
//    //    // SQLite connection string
//    //    String url = "jdbc:sqlite:/storage/emulated/0/Userdata.db";
//    //    Connection conn = null;
//    //    try {
//    //        conn = DriverManager.getConnection(url);
//    //    } catch (SQLException e) {
//    //        System.out.println(e.getMessage());
//    //    }
//    //    return conn;
//    //}
//
//    public static void createDB()
//    {
//        Connection c = null;
//        Statement stmt = null;
//        try {
//            Class.forName("org.sqlite.JDBC");
//            c = DriverManager.getConnection("jdbc:sqlite:Userdata.db");
//            System.out.println("Opened database successfully");
//            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
//
//            stmt = c.createStatement();
//            String sql = "CREATE TABLE DULAPEEPA " +
//                    "(ID INT, " +
//                    "ru_word TEXT, " +
//                    "en_word TEXT, " +
//                    "transcription TEXT)";
//            stmt.executeUpdate(sql);
//            stmt.close();
//            c.close();
//        } catch ( Exception e ) {
//            System.out.println("\n\n\n\nfffffffffff\n\n\n\n\n\n\n\n\n");
//            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
//            System.exit(0);
//        }
//        System.out.println("Table created successfully");
//    }
//
//    public Boolean insertDB(int iterator, String ru_word, String en_word, String transcript)
//    {
//        Connection c = null;
//        Statement stmt = null;
//        try {
//            Class.forName("org.sqlite.JDBC");
//            c = DriverManager.getConnection("sqlite:///storage/emulated/0/Userdata.db");
//            c.setAutoCommit(false);
//            System.out.println("Opened database successfully");
//
//            stmt = c.createStatement();
//            String sql = "INSERT INTO DULAPEEPA (ru_word,en_word,transcription) " +
//                    "VALUES (" + iterator + ", " + ru_word + ", " + en_word + ", " + transcript + ");";
//            stmt.executeUpdate(sql);
//            stmt.close();
//            c.commit();
//            c.close();
//        } catch ( Exception e ) {
//            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
//            System.exit(0);
//        }
//        System.out.println("Records created successfully");
//        return true;
//    }
//
//    public static void selectDB()
//    {
//        Connection c = null;
//        Statement stmt = null;
//        try {
//            Class.forName("org.sqlite.JDBC");
//            c = DriverManager.getConnection("jdbc:sqlite:/storage/emulated/0/Userdata.db");
//            c.setAutoCommit(false);
//            System.out.println("Opened database successfully");
//
//            stmt = c.createStatement();
//            ResultSet rs = stmt.executeQuery( "SELECT * FROM DULAPEEPA;" );
//            while ( rs.next() ) {
//                int id = rs.getInt("ID");
//                String  ru_word = rs.getString("ru_word");
//                String  en_word = rs.getString("en_word");
//                String transcription = rs.getString("transcription");
//                System.out.println( "ID : " + id );
//                System.out.println( "ru_word : " + ru_word );
//                System.out.println( "en_word : " + en_word );
//                System.out.println( "transcription : " + transcription );
//                System.out.println();
//            }
//            rs.close();
//            stmt.close();
//            c.close();
//        } catch ( Exception e ) {
//            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
//            System.exit(0);
//        }
//        System.out.println("Operation done successfully");
//    }
//
////    public static void updateDB()
////    {
////        Connection c = null;
////        Statement stmt = null;
////        try {
////            Class.forName("org.sqlite.JDBC");
////            c = DriverManager.getConnection("jdbc:sqlite:myBlog.sqlite");
////            c.setAutoCommit(false);
////            System.out.println("Opened database successfully");
////
////            stmt = c.createStatement();
////            String sql = "UPDATE DULAPEEPA set en_word = '?' where ID=1;";
////            stmt.executeUpdate(sql);
////            c.commit();
////
////            ResultSet rs = stmt.executeQuery( "SELECT * FROM web_blog;" );
////            while ( rs.next() ) {
////                int id = rs.getInt("id");
////                String  name = rs.getString("name");
////                String  message = rs.getString("message");
////                String date_added = rs.getString("date_added");
////                System.out.println( "ID : " + id );
////                System.out.println( "Name : " + name );
////                System.out.println( "Message : " + message );
////                System.out.println( "Date Added : " + date_added );
////                System.out.println();
////            }
////            rs.close();
////            stmt.close();
////            c.close();
////        } catch ( Exception e ) {
////            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
////            System.exit(0);
////        }
////        System.out.println("Operation done successfully");
////    }
//
////    public static void deleteDB()
////    {
////        Connection c = null;
////        Statement stmt = null;
////        try {
////            Class.forName("org.sqlite.JDBC");
////            c = DriverManager.getConnection("jdbc:sqlite:/storage/emulated/0/Userdata.db");
////            c.setAutoCommit(false);
////            System.out.println("Opened database successfully");
////
////            stmt = c.createStatement();
////            String sql = "DELETE from web_blog where ID=1;";
////            stmt.executeUpdate(sql);
////            c.commit();
////
////            ResultSet rs = stmt.executeQuery( "SELECT * FROM web_blog;" );
////            while ( rs.next() ) {
////                int id = rs.getInt("id");
////                String  name = rs.getString("name");
////                String  message = rs.getString("message");
////                String date_added = rs.getString("date_added");
////                System.out.println( "ID : " + id );
////                System.out.println( "Name : " + name );
////                System.out.println( "Message : " + message );
////                System.out.println( "Date Added : " + date_added );
////                System.out.println();
////            }
////            rs.close();
////            stmt.close();
////            c.close();
////        } catch ( Exception e ) {
////            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
////            System.exit(0);
////        }
////        System.out.println("Operation done successfully");
////    }
//
//
//    public Boolean insertuserdata(String ru_word, String en_word, String transcript)
//    {
//        SQLiteDatabase DB = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("ru_word", ru_word);
//        contentValues.put("en_word", en_word);
//        contentValues.put("transcript", transcript);
//        long result=DB.insert("Userdetails", null, contentValues);
//        if(result==-1){
//            return false;
//        }else{
//            return true;
//        }
//    }
////    public Boolean updateuserdata(String ru_word, String en_word, String transcript)
////    {
////        SQLiteDatabase DB = this.getWritableDatabase();
////        ContentValues contentValues = new ContentValues();
////        contentValues.put("ru_word", ru_word);
////        contentValues.put("en_word", en_word);
////        contentValues.put("transcript", transcript);
////        Cursor cursor = DB.rawQuery("Select * from Userdetails where name = ?", new String[]{ru_word});
////        if (cursor.getCount() > 0) {
////            long result = DB.update("Userdetails", contentValues, "ru_word=?", new String[]{ru_word});
////            if (result == -1) {
////                return false;
////            } else {
////                return true;
////            }
////        } else {
////            return false;
////        }
////    }
////    public Boolean deletedata (String ru_word)
////    {
////        SQLiteDatabase DB = this.getWritableDatabase();
////        Cursor cursor = DB.rawQuery("Select * from Userdetails where ru_word = ?", new String[]{ru_word});
////        if (cursor.getCount() > 0) {
////            long result = DB.delete("/storage/emulated/0/Userdetails", "ru_word=?", new String[]{ru_word});
////            if (result == -1) {
////                return false;
////            } else {
////                return true;
////            }
////        } else {
////            return false;
////        }
////    }
//
//    public Cursor getdata ()
//    {
//        SQLiteDatabase DB = this.getWritableDatabase();
//        Cursor cursor = DB.rawQuery("Select * from Userdetails", null);
//        return cursor;
//    }
//}
