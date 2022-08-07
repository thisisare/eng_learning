package com.example.dula;

import android.Manifest;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {
    private Button button;
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private EditText newcontactpopup_textview;
    private Button newcontactpopup_send, newcontactpopup_cancel;
    DBHelper dbHelper;


    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    public static ContentValues contentValues = new ContentValues();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        getSupportActionBar().hide();
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        Toolbar toolbar4 = findViewById(R.id.toolbar4);
        toolbar4.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);

        toolbar4.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity3.this.onBackPressed();
            }
        });

        ArrayList<String> Words = new ArrayList();
        ArrayList<String> WordsEn = new ArrayList();
        ArrayList<String> Transcriptions = new ArrayList();
        ArrayList<String> ExampleRu = new ArrayList();
        ArrayList<String> ExampleEn = new ArrayList();
        dbHelper = new DBHelper(this);

        //ArrayList<String> TABLE_NAMES = new ArrayList();
//
        //TABLE_NAMES.add("TOP100");          TABLE_NAMES.add("TOP1000");
        //TABLE_NAMES.add("ADJECTIVE");       TABLE_NAMES.add("WRONGVERBS");      TABLE_NAMES.add("PHRASALVERBS");            TABLE_NAMES.add("ROUTINE");
        //TABLE_NAMES.add("TOP3000");         TABLE_NAMES.add("IDIOMS");          TABLE_NAMES.add("SLANG");                   TABLE_NAMES.add("CLOTHES");
        //TABLE_NAMES.add("IT");              TABLE_NAMES.add("HEALTH");          TABLE_NAMES.add("NATURE");                  TABLE_NAMES.add("TAYLORSWIFT");
        //TABLE_NAMES.add("KATYPERRY");       TABLE_NAMES.add("LANADELREY");      TABLE_NAMES.add("EMINEM");                  TABLE_NAMES.add("EUPHORIA");
        //TABLE_NAMES.add("SHERLOCK");        TABLE_NAMES.add("FRIENDS");         TABLE_NAMES.add("SHREK");                   TABLE_NAMES.add("MADAGASCAR");
        //TABLE_NAMES.add("COLORS");          TABLE_NAMES.add("HUMAN");           TABLE_NAMES.add("PREINTERMEDIATE");         TABLE_NAMES.add("INTERMEDIATE");
        //TABLE_NAMES.add("FAVORITE");

        SQLiteDatabase database = dbHelper.getWritableDatabase();

        //ЗАПИСЬ И СОЗДАНИЕ НОВОЙ БД
        //Button bhelp3 = findViewById(R.id.bhelp3);
        //bhelp3.setOnClickListener(v22 -> {
        //    int permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE );
        //    File file1 = new File("/storage/emulated/0/ENGLISH.txt");
        //    File file2 = new File("/storage/emulated/0/RUSSIAN.txt");
        //    File file3 = new File("/storage/emulated/0/TRANSCRIPTION.txt");
        //    if (permission != PackageManager.PERMISSION_GRANTED) {
        //        // We don't have permission so prompt the user
        //        ActivityCompat.requestPermissions(
        //                this,
        //                PERMISSIONS_STORAGE,
        //                REQUEST_EXTERNAL_STORAGE
        //        );
        //    }
        //    try {
        //        FileReader fr1 = new FileReader(file1);
        //        FileReader fr2 = new FileReader(file2);
        //        FileReader fr3 = new FileReader(file3);
//
        //        BufferedReader reader1 = new BufferedReader(fr1);
        //        BufferedReader reader2 = new BufferedReader(fr2);
        //        BufferedReader reader3 = new BufferedReader(fr3);
//
        //        String line1 = reader1.readLine();
        //        String line2 = reader2.readLine();
        //        String line3 = reader3.readLine();
        //
        //        while (line1 != null) {
        //            System.out.println("РАБОТАЕТ");
        //            contentValues.put(DBHelper.KEY_EN_WORD, line1);
        //            contentValues.put(DBHelper.KEY_TRANSCRIPTION, line2);
        //            contentValues.put(DBHelper.KEY_RU_WORD, line3);
        //            contentValues.put(DBHelper.KEY_PROGRESS, 0);
        //            database.insert(DBHelper.TABLE_AllWORDS, null, contentValues);
//
        //            line1 = reader1.readLine();
        //            line2 = reader2.readLine();
        //            line3 = reader3.readLine();
        //        }
        //    } catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
        Button bhelp3 = findViewById(R.id.bhelp3);
        bhelp3.setOnClickListener(v22 -> {
            File f = new File(getCacheDir(), File.separator + "DulaPeepa/");
            f.mkdirs();
            ArrayList<String> Categories = new ArrayList();
            Categories.add("ADJECTIVES.txt");
            Categories.add("CLOTHES.txt");
            Categories.add("COLORS.txt");
            Categories.add("HEALTH.txt");
            Categories.add("HUMAN.txt");
            Categories.add("INTERMEDIATE.txt");
            Categories.add("IT.txt");
            Categories.add("NATURE.txt");
            Categories.add("ROUTINE.txt");
            Categories.add("TOP100.txt");
            Categories.add("TOP1000.txt");
            Categories.add("PHRASAL.txt ");
            Categories.add("WRONG.txt");
            Categories.add("SLANG.txt");

            String AnotherOne = "IDIOM.txt";
/*
            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            int permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
            File file1 = new File("/storage/emulated/0/Android/data/Dula/rusWORDS/TOP100.txt");
            File file2 = new File("/storage/emulated/0/Android/data/Dula/engWORDS/TOP100.txt");
            File file3 = new File("/storage/emulated/0/Android/data/Dula/ExEn/TOP100.txt");
            File file4 = new File("/storage/emulated/0/Android/data/Dula/ExRu/TOP100.txt");
            File file5 = new File("/storage/emulated/0/Android/data/Dula/Tr/TOP100.txt");

            if (permission != PackageManager.PERMISSION_GRANTED) {
                // We don't have permission so prompt the user
                ActivityCompat.requestPermissions(
                        this,
                        PERMISSIONS_STORAGE,
                        REQUEST_EXTERNAL_STORAGE
                );
            }
            try {
                FileReader fr1 = new FileReader(file1);
                FileReader fr2 = new FileReader(file2);
                FileReader fr3 = new FileReader(file3);
                FileReader fr4 = new FileReader(file4);
                FileReader fr5 = new FileReader(file5);

                BufferedReader reader1 = new BufferedReader(fr1);
                BufferedReader reader2 = new BufferedReader(fr2);
                BufferedReader reader3 = new BufferedReader(fr3);
                BufferedReader reader4 = new BufferedReader(fr4);
                BufferedReader reader5 = new BufferedReader(fr5);

                String line1 = reader1.readLine();
                String line2 = reader2.readLine();
                String line3 = reader3.readLine();
                String line4 = reader4.readLine();
                String line5 = reader5.readLine();

                while (line1 != null) {
                    contentValues.put(DBHelper.KEY_RU_WORD, line1);
                    contentValues.put(DBHelper.KEY_EN_WORD, line2);
                    contentValues.put(DBHelper.KEY_EXAMPLES_EN, line3);
                    contentValues.put(DBHelper.KEY_EXAMPLES_RU, line4);
                    contentValues.put(DBHelper.KEY_TRANSCRIPTION, line5);
                    contentValues.put(DBHelper.KEY_PROGRESS, 0);
                    System.out.println(line1 + " - " + line2 + " - " + line3 + " - " + line4 + " - " + line5);
                    database.insert(DBHelper.TABLE_TOP100, null, contentValues);

                    line1 = reader1.readLine();
                    line2 = reader2.readLine();
                    line3 = reader3.readLine();
                    line4 = reader4.readLine();
                    line5 = reader5.readLine();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
            file1 = new File("/storage/emulated/0/Android/data/Dula/rusWORDS/TOP1000.txt");
            file2 = new File("/storage/emulated/0/Android/data/Dula/engWORDS/TOP1000.txt");
            file3 = new File("/storage/emulated/0/Android/data/Dula/ExEn/TOP1000.txt");
            file4 = new File("/storage/emulated/0/Android/data/Dula/ExRu/TOP1000.txt");
            file5 = new File("/storage/emulated/0/Android/data/Dula/Tr/TOP1000.txt");

            if (permission != PackageManager.PERMISSION_GRANTED) {
                // We don't have permission so prompt the user
                ActivityCompat.requestPermissions(
                        this,
                        PERMISSIONS_STORAGE,
                        REQUEST_EXTERNAL_STORAGE
                );
            }
            try {
                FileReader fr1 = new FileReader(file1);
                FileReader fr2 = new FileReader(file2);
                FileReader fr3 = new FileReader(file3);
                FileReader fr4 = new FileReader(file4);
                FileReader fr5 = new FileReader(file5);

                BufferedReader reader1 = new BufferedReader(fr1);
                BufferedReader reader2 = new BufferedReader(fr2);
                BufferedReader reader3 = new BufferedReader(fr3);
                BufferedReader reader4 = new BufferedReader(fr4);
                BufferedReader reader5 = new BufferedReader(fr5);

                String line1 = reader1.readLine();
                String line2 = reader2.readLine();
                String line3 = reader3.readLine();
                String line4 = reader4.readLine();
                String line5 = reader5.readLine();

                while (line1 != null) {
                    contentValues.put(DBHelper.KEY_RU_WORD, line1);
                    contentValues.put(DBHelper.KEY_EN_WORD, line2);
                    contentValues.put(DBHelper.KEY_EXAMPLES_EN, line3);
                    contentValues.put(DBHelper.KEY_EXAMPLES_RU, line4);
                    contentValues.put(DBHelper.KEY_TRANSCRIPTION, line5);
                    contentValues.put(DBHelper.KEY_PROGRESS, 0);
                    database.insert(DBHelper.TABLE_TOP1000, null, contentValues);

                    line1 = reader1.readLine();
                    line2 = reader2.readLine();
                    line3 = reader3.readLine();
                    line4 = reader4.readLine();
                    line5 = reader5.readLine();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
            file1 = new File("/storage/emulated/0/Android/data/Dula/rusWORDS/ADJECTIVES.txt");
            file2 = new File("/storage/emulated/0/Android/data/Dula/engWORDS/ADJECTIVES.txt");
            file3 = new File("/storage/emulated/0/Android/data/Dula/ExEn/ADJECTIVES.txt");
            file4 = new File("/storage/emulated/0/Android/data/Dula/ExRu/ADJECTIVES.txt");
            file5 = new File("/storage/emulated/0/Android/data/Dula/Tr/ADJECTIVES.txt");

            if (permission != PackageManager.PERMISSION_GRANTED) {
                // We don't have permission so prompt the user
                ActivityCompat.requestPermissions(
                        this,
                        PERMISSIONS_STORAGE,
                        REQUEST_EXTERNAL_STORAGE
                );
            }
            try {
                FileReader fr1 = new FileReader(file1);
                FileReader fr2 = new FileReader(file2);
                FileReader fr3 = new FileReader(file3);
                FileReader fr4 = new FileReader(file4);
                FileReader fr5 = new FileReader(file5);

                BufferedReader reader1 = new BufferedReader(fr1);
                BufferedReader reader2 = new BufferedReader(fr2);
                BufferedReader reader3 = new BufferedReader(fr3);
                BufferedReader reader4 = new BufferedReader(fr4);
                BufferedReader reader5 = new BufferedReader(fr5);

                String line1 = reader1.readLine();
                String line2 = reader2.readLine();
                String line3 = reader3.readLine();
                String line4 = reader4.readLine();
                String line5 = reader5.readLine();

                while (line1 != null) {
                    contentValues.put(DBHelper.KEY_RU_WORD, line1);
                    contentValues.put(DBHelper.KEY_EN_WORD, line2);
                    contentValues.put(DBHelper.KEY_EXAMPLES_EN, line3);
                    contentValues.put(DBHelper.KEY_EXAMPLES_RU, line4);
                    contentValues.put(DBHelper.KEY_TRANSCRIPTION, line5);
                    contentValues.put(DBHelper.KEY_PROGRESS, 0);
                    database.insert(DBHelper.TABLE_ADJECTIVES, null, contentValues);

                    line1 = reader1.readLine();
                    line2 = reader2.readLine();
                    line3 = reader3.readLine();
                    line4 = reader4.readLine();
                    line5 = reader5.readLine();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
            file1 = new File("/storage/emulated/0/Android/data/Dula/rusWORDS/CLOTHES.txt");
            file2 = new File("/storage/emulated/0/Android/data/Dula/engWORDS/CLOTHES.txt");
            file3 = new File("/storage/emulated/0/Android/data/Dula/ExEn/CLOTHES.txt");
            file4 = new File("/storage/emulated/0/Android/data/Dula/ExRu/CLOTHES.txt");
            file5 = new File("/storage/emulated/0/Android/data/Dula/Tr/CLOTHES.txt");

            if (permission != PackageManager.PERMISSION_GRANTED) {
                // We don't have permission so prompt the user
                ActivityCompat.requestPermissions(
                        this,
                        PERMISSIONS_STORAGE,
                        REQUEST_EXTERNAL_STORAGE
                );
            }
            try {
                FileReader fr1 = new FileReader(file1);
                FileReader fr2 = new FileReader(file2);
                FileReader fr3 = new FileReader(file3);
                FileReader fr4 = new FileReader(file4);
                FileReader fr5 = new FileReader(file5);

                BufferedReader reader1 = new BufferedReader(fr1);
                BufferedReader reader2 = new BufferedReader(fr2);
                BufferedReader reader3 = new BufferedReader(fr3);
                BufferedReader reader4 = new BufferedReader(fr4);
                BufferedReader reader5 = new BufferedReader(fr5);

                String line1 = reader1.readLine();
                String line2 = reader2.readLine();
                String line3 = reader3.readLine();
                String line4 = reader4.readLine();
                String line5 = reader5.readLine();

                while (line1 != null) {
                    contentValues.put(DBHelper.KEY_RU_WORD, line1);
                    contentValues.put(DBHelper.KEY_EN_WORD, line2);
                    contentValues.put(DBHelper.KEY_EXAMPLES_EN, line3);
                    contentValues.put(DBHelper.KEY_EXAMPLES_RU, line4);
                    contentValues.put(DBHelper.KEY_TRANSCRIPTION, line5);
                    contentValues.put(DBHelper.KEY_PROGRESS, 0);
                    database.insert(DBHelper.TABLE_CLOTHES, null, contentValues);

                    line1 = reader1.readLine();
                    line2 = reader2.readLine();
                    line3 = reader3.readLine();
                    line4 = reader4.readLine();
                    line5 = reader5.readLine();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
            file1 = new File("/storage/emulated/0/Android/data/Dula/rusWORDS/COLORS.txt");
            file2 = new File("/storage/emulated/0/Android/data/Dula/engWORDS/COLORS.txt");
            file3 = new File("/storage/emulated/0/Android/data/Dula/ExEn/COLORS.txt");
            file4 = new File("/storage/emulated/0/Android/data/Dula/ExRu/COLORS.txt");
            file5 = new File("/storage/emulated/0/Android/data/Dula/Tr/COLORS.txt");

            if (permission != PackageManager.PERMISSION_GRANTED) {
                // We don't have permission so prompt the user
                ActivityCompat.requestPermissions(
                        this,
                        PERMISSIONS_STORAGE,
                        REQUEST_EXTERNAL_STORAGE
                );
            }
            try {
                FileReader fr1 = new FileReader(file1);
                FileReader fr2 = new FileReader(file2);
                FileReader fr3 = new FileReader(file3);
                FileReader fr4 = new FileReader(file4);
                FileReader fr5 = new FileReader(file5);

                BufferedReader reader1 = new BufferedReader(fr1);
                BufferedReader reader2 = new BufferedReader(fr2);
                BufferedReader reader3 = new BufferedReader(fr3);
                BufferedReader reader4 = new BufferedReader(fr4);
                BufferedReader reader5 = new BufferedReader(fr5);

                String line1 = reader1.readLine();
                String line2 = reader2.readLine();
                String line3 = reader3.readLine();
                String line4 = reader4.readLine();
                String line5 = reader5.readLine();

                while (line1 != null) {
                    contentValues.put(DBHelper.KEY_RU_WORD, line1);
                    contentValues.put(DBHelper.KEY_EN_WORD, line2);
                    contentValues.put(DBHelper.KEY_EXAMPLES_EN, line3);
                    contentValues.put(DBHelper.KEY_EXAMPLES_RU, line4);
                    contentValues.put(DBHelper.KEY_TRANSCRIPTION, line5);
                    contentValues.put(DBHelper.KEY_PROGRESS, 0);
                    database.insert(DBHelper.TABLE_COLORS, null, contentValues);

                    line1 = reader1.readLine();
                    line2 = reader2.readLine();
                    line3 = reader3.readLine();
                    line4 = reader4.readLine();
                    line5 = reader5.readLine();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
            file1 = new File("/storage/emulated/0/Android/data/Dula/rusWORDS/HEALTH.txt");
            file2 = new File("/storage/emulated/0/Android/data/Dula/engWORDS/HEALTH.txt");
            file3 = new File("/storage/emulated/0/Android/data/Dula/ExEn/HEALTH.txt");
            file4 = new File("/storage/emulated/0/Android/data/Dula/ExRu/HEALTH.txt");
            file5 = new File("/storage/emulated/0/Android/data/Dula/Tr/HEALTH.txt");

            if (permission != PackageManager.PERMISSION_GRANTED) {
                // We don't have permission so prompt the user
                ActivityCompat.requestPermissions(
                        this,
                        PERMISSIONS_STORAGE,
                        REQUEST_EXTERNAL_STORAGE
                );
            }
            try {
                FileReader fr1 = new FileReader(file1);
                FileReader fr2 = new FileReader(file2);
                FileReader fr3 = new FileReader(file3);
                FileReader fr4 = new FileReader(file4);
                FileReader fr5 = new FileReader(file5);

                BufferedReader reader1 = new BufferedReader(fr1);
                BufferedReader reader2 = new BufferedReader(fr2);
                BufferedReader reader3 = new BufferedReader(fr3);
                BufferedReader reader4 = new BufferedReader(fr4);
                BufferedReader reader5 = new BufferedReader(fr5);

                String line1 = reader1.readLine();
                String line2 = reader2.readLine();
                String line3 = reader3.readLine();
                String line4 = reader4.readLine();
                String line5 = reader5.readLine();

                while (line1 != null) {
                    contentValues.put(DBHelper.KEY_RU_WORD, line1);
                    contentValues.put(DBHelper.KEY_EN_WORD, line2);
                    contentValues.put(DBHelper.KEY_EXAMPLES_EN, line3);
                    contentValues.put(DBHelper.KEY_EXAMPLES_RU, line4);
                    contentValues.put(DBHelper.KEY_TRANSCRIPTION, line5);
                    contentValues.put(DBHelper.KEY_PROGRESS, 0);
                    database.insert(DBHelper.TABLE_HEALTH, null, contentValues);

                    line1 = reader1.readLine();
                    line2 = reader2.readLine();
                    line3 = reader3.readLine();
                    line4 = reader4.readLine();
                    line5 = reader5.readLine();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
            file1 = new File("/storage/emulated/0/Android/data/Dula/rusWORDS/HUMAN.txt");
            file2 = new File("/storage/emulated/0/Android/data/Dula/engWORDS/HUMAN.txt");
            file3 = new File("/storage/emulated/0/Android/data/Dula/ExEn/HUMAN.txt");
            file4 = new File("/storage/emulated/0/Android/data/Dula/ExRu/HUMAN.txt");
            file5 = new File("/storage/emulated/0/Android/data/Dula/Tr/HUMAN.txt");

            if (permission != PackageManager.PERMISSION_GRANTED) {
                // We don't have permission so prompt the user
                ActivityCompat.requestPermissions(
                        this,
                        PERMISSIONS_STORAGE,
                        REQUEST_EXTERNAL_STORAGE
                );
            }
            try {
                FileReader fr1 = new FileReader(file1);
                FileReader fr2 = new FileReader(file2);
                FileReader fr3 = new FileReader(file3);
                FileReader fr4 = new FileReader(file4);
                FileReader fr5 = new FileReader(file5);

                BufferedReader reader1 = new BufferedReader(fr1);
                BufferedReader reader2 = new BufferedReader(fr2);
                BufferedReader reader3 = new BufferedReader(fr3);
                BufferedReader reader4 = new BufferedReader(fr4);
                BufferedReader reader5 = new BufferedReader(fr5);

                String line1 = reader1.readLine();
                String line2 = reader2.readLine();
                String line3 = reader3.readLine();
                String line4 = reader4.readLine();
                String line5 = reader5.readLine();

                while (line1 != null) {
                    contentValues.put(DBHelper.KEY_RU_WORD, line1);
                    contentValues.put(DBHelper.KEY_EN_WORD, line2);
                    contentValues.put(DBHelper.KEY_EXAMPLES_EN, line3);
                    contentValues.put(DBHelper.KEY_EXAMPLES_RU, line4);
                    contentValues.put(DBHelper.KEY_TRANSCRIPTION, line5);
                    contentValues.put(DBHelper.KEY_PROGRESS, 0);
                    database.insert(DBHelper.TABLE_HUMAN, null, contentValues);

                    line1 = reader1.readLine();
                    line2 = reader2.readLine();
                    line3 = reader3.readLine();
                    line4 = reader4.readLine();
                    line5 = reader5.readLine();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
            file1 = new File("/storage/emulated/0/Android/data/Dula/rusWORDS/INTERMEDIATE.txt");
            file2 = new File("/storage/emulated/0/Android/data/Dula/engWORDS/INTERMEDIATE.txt");
            file3 = new File("/storage/emulated/0/Android/data/Dula/ExEn/INTERMEDIATE.txt");
            file4 = new File("/storage/emulated/0/Android/data/Dula/ExRu/INTERMEDIATE.txt");
            file5 = new File("/storage/emulated/0/Android/data/Dula/Tr/INTERMEDIATE.txt");

            if (permission != PackageManager.PERMISSION_GRANTED) {
                // We don't have permission so prompt the user
                ActivityCompat.requestPermissions(
                        this,
                        PERMISSIONS_STORAGE,
                        REQUEST_EXTERNAL_STORAGE
                );
            }
            try {
                FileReader fr1 = new FileReader(file1);
                FileReader fr2 = new FileReader(file2);
                FileReader fr3 = new FileReader(file3);
                FileReader fr4 = new FileReader(file4);
                FileReader fr5 = new FileReader(file5);

                BufferedReader reader1 = new BufferedReader(fr1);
                BufferedReader reader2 = new BufferedReader(fr2);
                BufferedReader reader3 = new BufferedReader(fr3);
                BufferedReader reader4 = new BufferedReader(fr4);
                BufferedReader reader5 = new BufferedReader(fr5);

                String line1 = reader1.readLine();
                String line2 = reader2.readLine();
                String line3 = reader3.readLine();
                String line4 = reader4.readLine();
                String line5 = reader5.readLine();

                while (line1 != null) {
                    contentValues.put(DBHelper.KEY_RU_WORD, line1);
                    contentValues.put(DBHelper.KEY_EN_WORD, line2);
                    contentValues.put(DBHelper.KEY_EXAMPLES_EN, line3);
                    contentValues.put(DBHelper.KEY_EXAMPLES_RU, line4);
                    contentValues.put(DBHelper.KEY_TRANSCRIPTION, line5);
                    contentValues.put(DBHelper.KEY_PROGRESS, 0);
                    database.insert(DBHelper.TABLE_INTERMEDIATE, null, contentValues);

                    line1 = reader1.readLine();
                    line2 = reader2.readLine();
                    line3 = reader3.readLine();
                    line4 = reader4.readLine();
                    line5 = reader5.readLine();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
            file1 = new File("/storage/emulated/0/Android/data/Dula/rusWORDS/IT.txt");
            file2 = new File("/storage/emulated/0/Android/data/Dula/engWORDS/IT.txt");
            file3 = new File("/storage/emulated/0/Android/data/Dula/ExEn/IT.txt");
            file4 = new File("/storage/emulated/0/Android/data/Dula/ExRu/IT.txt");
            file5 = new File("/storage/emulated/0/Android/data/Dula/Tr/IT.txt");

            if (permission != PackageManager.PERMISSION_GRANTED) {
                // We don't have permission so prompt the user
                ActivityCompat.requestPermissions(
                        this,
                        PERMISSIONS_STORAGE,
                        REQUEST_EXTERNAL_STORAGE
                );
            }
            try {
                FileReader fr1 = new FileReader(file1);
                FileReader fr2 = new FileReader(file2);
                FileReader fr3 = new FileReader(file3);
                FileReader fr4 = new FileReader(file4);
                FileReader fr5 = new FileReader(file5);

                BufferedReader reader1 = new BufferedReader(fr1);
                BufferedReader reader2 = new BufferedReader(fr2);
                BufferedReader reader3 = new BufferedReader(fr3);
                BufferedReader reader4 = new BufferedReader(fr4);
                BufferedReader reader5 = new BufferedReader(fr5);

                String line1 = reader1.readLine();
                String line2 = reader2.readLine();
                String line3 = reader3.readLine();
                String line4 = reader4.readLine();
                String line5 = reader5.readLine();

                while (line1 != null) {
                    contentValues.put(DBHelper.KEY_RU_WORD, line1);
                    contentValues.put(DBHelper.KEY_EN_WORD, line2);
                    contentValues.put(DBHelper.KEY_EXAMPLES_EN, line3);
                    contentValues.put(DBHelper.KEY_EXAMPLES_RU, line4);
                    contentValues.put(DBHelper.KEY_TRANSCRIPTION, line5);
                    contentValues.put(DBHelper.KEY_PROGRESS, 0);
                    database.insert(DBHelper.TABLE_IT, null, contentValues);

                    line1 = reader1.readLine();
                    line2 = reader2.readLine();
                    line3 = reader3.readLine();
                    line4 = reader4.readLine();
                    line5 = reader5.readLine();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
            file1 = new File("/storage/emulated/0/Android/data/Dula/rusWORDS/NATURE.txt");
            file2 = new File("/storage/emulated/0/Android/data/Dula/engWORDS/NATURE.txt");
            file3 = new File("/storage/emulated/0/Android/data/Dula/ExEn/NATURE.txt");
            file4 = new File("/storage/emulated/0/Android/data/Dula/ExRu/NATURE.txt");
            file5 = new File("/storage/emulated/0/Android/data/Dula/Tr/NATURE.txt");

            if (permission != PackageManager.PERMISSION_GRANTED) {
                // We don't have permission so prompt the user
                ActivityCompat.requestPermissions(
                        this,
                        PERMISSIONS_STORAGE,
                        REQUEST_EXTERNAL_STORAGE
                );
            }
            try {
                FileReader fr1 = new FileReader(file1);
                FileReader fr2 = new FileReader(file2);
                FileReader fr3 = new FileReader(file3);
                FileReader fr4 = new FileReader(file4);
                FileReader fr5 = new FileReader(file5);

                BufferedReader reader1 = new BufferedReader(fr1);
                BufferedReader reader2 = new BufferedReader(fr2);
                BufferedReader reader3 = new BufferedReader(fr3);
                BufferedReader reader4 = new BufferedReader(fr4);
                BufferedReader reader5 = new BufferedReader(fr5);

                String line1 = reader1.readLine();
                String line2 = reader2.readLine();
                String line3 = reader3.readLine();
                String line4 = reader4.readLine();
                String line5 = reader5.readLine();

                while (line1 != null) {
                    contentValues.put(DBHelper.KEY_RU_WORD, line1);
                    contentValues.put(DBHelper.KEY_EN_WORD, line2);
                    contentValues.put(DBHelper.KEY_EXAMPLES_EN, line3);
                    contentValues.put(DBHelper.KEY_EXAMPLES_RU, line4);
                    contentValues.put(DBHelper.KEY_TRANSCRIPTION, line5);
                    contentValues.put(DBHelper.KEY_PROGRESS, 0);
                    database.insert(DBHelper.TABLE_NATURE, null, contentValues);

                    line1 = reader1.readLine();
                    line2 = reader2.readLine();
                    line3 = reader3.readLine();
                    line4 = reader4.readLine();
                    line5 = reader5.readLine();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
            file1 = new File("/storage/emulated/0/Android/data/Dula/rusWORDS/ROUTINE.txt");
            file2 = new File("/storage/emulated/0/Android/data/Dula/engWORDS/ROUTINE.txt");
            file3 = new File("/storage/emulated/0/Android/data/Dula/ExEn/ROUTINE.txt");
            file4 = new File("/storage/emulated/0/Android/data/Dula/ExRu/ROUTINE.txt");
            file5 = new File("/storage/emulated/0/Android/data/Dula/Tr/ROUTINE.txt");

            if (permission != PackageManager.PERMISSION_GRANTED) {
                // We don't have permission so prompt the user
                ActivityCompat.requestPermissions(
                        this,
                        PERMISSIONS_STORAGE,
                        REQUEST_EXTERNAL_STORAGE
                );
            }
            try {
                FileReader fr1 = new FileReader(file1);
                FileReader fr2 = new FileReader(file2);
                FileReader fr3 = new FileReader(file3);
                FileReader fr4 = new FileReader(file4);
                FileReader fr5 = new FileReader(file5);

                BufferedReader reader1 = new BufferedReader(fr1);
                BufferedReader reader2 = new BufferedReader(fr2);
                BufferedReader reader3 = new BufferedReader(fr3);
                BufferedReader reader4 = new BufferedReader(fr4);
                BufferedReader reader5 = new BufferedReader(fr5);

                String line1 = reader1.readLine();
                String line2 = reader2.readLine();
                String line3 = reader3.readLine();
                String line4 = reader4.readLine();
                String line5 = reader5.readLine();

                while (line1 != null) {
                    contentValues.put(DBHelper.KEY_RU_WORD, line1);
                    contentValues.put(DBHelper.KEY_EN_WORD, line2);
                    contentValues.put(DBHelper.KEY_EXAMPLES_EN, line3);
                    contentValues.put(DBHelper.KEY_EXAMPLES_RU, line4);
                    contentValues.put(DBHelper.KEY_TRANSCRIPTION, line5);
                    contentValues.put(DBHelper.KEY_PROGRESS, 0);
                    database.insert(DBHelper.TABLE_ROUTINE, null, contentValues);

                    line1 = reader1.readLine();
                    line2 = reader2.readLine();
                    line3 = reader3.readLine();
                    line4 = reader4.readLine();
                    line5 = reader5.readLine();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
            file1 = new File("/storage/emulated/0/Android/data/Dula/rusWORDS/PHRASAL.txt");
            file2 = new File("/storage/emulated/0/Android/data/Dula/engWORDS/PHRASAL.txt");
            file3 = new File("/storage/emulated/0/Android/data/Dula/ExEn/PHRASAL.txt");
            file4 = new File("/storage/emulated/0/Android/data/Dula/ExRu/PHRASAL.txt");
            file5 = new File("/storage/emulated/0/Android/data/Dula/Tr/PHRASAL.txt");

            if (permission != PackageManager.PERMISSION_GRANTED) {
                // We don't have permission so prompt the user
                ActivityCompat.requestPermissions(
                        this,
                        PERMISSIONS_STORAGE,
                        REQUEST_EXTERNAL_STORAGE
                );
            }
            try {
                FileReader fr1 = new FileReader(file1);
                FileReader fr2 = new FileReader(file2);
                FileReader fr3 = new FileReader(file3);
                FileReader fr4 = new FileReader(file4);
                FileReader fr5 = new FileReader(file5);

                BufferedReader reader1 = new BufferedReader(fr1);
                BufferedReader reader2 = new BufferedReader(fr2);
                BufferedReader reader3 = new BufferedReader(fr3);
                BufferedReader reader4 = new BufferedReader(fr4);
                BufferedReader reader5 = new BufferedReader(fr5);

                String line1 = reader1.readLine();
                String line2 = reader2.readLine();
                String line3 = reader3.readLine();
                String line4 = reader4.readLine();
                String line5 = reader5.readLine();

                while (line1 != null) {
                    contentValues.put(DBHelper.KEY_RU_WORD, line1);
                    contentValues.put(DBHelper.KEY_EN_WORD, line2);
                    contentValues.put(DBHelper.KEY_EXAMPLES_EN, line3);
                    contentValues.put(DBHelper.KEY_EXAMPLES_RU, line4);
                    contentValues.put(DBHelper.KEY_TRANSCRIPTION, line5);
                    contentValues.put(DBHelper.KEY_PROGRESS, 0);
                    database.insert(DBHelper.TABLE_PHRASAL, null, contentValues);

                    line1 = reader1.readLine();
                    line2 = reader2.readLine();
                    line3 = reader3.readLine();
                    line4 = reader4.readLine();
                    line5 = reader5.readLine();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
            file1 = new File("/storage/emulated/0/Android/data/Dula/rusWORDS/WRONG.txt");
            file2 = new File("/storage/emulated/0/Android/data/Dula/engWORDS/WRONG.txt");
            file3 = new File("/storage/emulated/0/Android/data/Dula/ExEn/WRONG.txt");
            file4 = new File("/storage/emulated/0/Android/data/Dula/ExRu/WRONG.txt");
            file5 = new File("/storage/emulated/0/Android/data/Dula/Tr/WRONG.txt");

            if (permission != PackageManager.PERMISSION_GRANTED) {
                // We don't have permission so prompt the user
                ActivityCompat.requestPermissions(
                        this,
                        PERMISSIONS_STORAGE,
                        REQUEST_EXTERNAL_STORAGE
                );
            }
            try {
                FileReader fr1 = new FileReader(file1);
                FileReader fr2 = new FileReader(file2);
                FileReader fr3 = new FileReader(file3);
                FileReader fr4 = new FileReader(file4);
                FileReader fr5 = new FileReader(file5);

                BufferedReader reader1 = new BufferedReader(fr1);
                BufferedReader reader2 = new BufferedReader(fr2);
                BufferedReader reader3 = new BufferedReader(fr3);
                BufferedReader reader4 = new BufferedReader(fr4);
                BufferedReader reader5 = new BufferedReader(fr5);

                String line1 = reader1.readLine();
                String line2 = reader2.readLine();
                String line3 = reader3.readLine();
                String line4 = reader4.readLine();
                String line5 = reader5.readLine();

                while (line1 != null) {
                    contentValues.put(DBHelper.KEY_RU_WORD, line1);
                    contentValues.put(DBHelper.KEY_EN_WORD, line2);
                    contentValues.put(DBHelper.KEY_EXAMPLES_EN, line3);
                    contentValues.put(DBHelper.KEY_EXAMPLES_RU, line4);
                    contentValues.put(DBHelper.KEY_TRANSCRIPTION, line5);
                    contentValues.put(DBHelper.KEY_PROGRESS, 0);
                    database.insert(DBHelper.TABLE_IRREGULAR, null, contentValues);

                    line1 = reader1.readLine();
                    line2 = reader2.readLine();
                    line3 = reader3.readLine();
                    line4 = reader4.readLine();
                    line5 = reader5.readLine();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
            file1 = new File("/storage/emulated/0/Android/data/Dula/rusWORDS/SLANG.txt");
            file2 = new File("/storage/emulated/0/Android/data/Dula/engWORDS/SLANG.txt");
            file3 = new File("/storage/emulated/0/Android/data/Dula/ExEn/SLANG.txt");
            file4 = new File("/storage/emulated/0/Android/data/Dula/ExRu/SLANG.txt");
            file5 = new File("/storage/emulated/0/Android/data/Dula/Tr/SLANG.txt");

            if (permission != PackageManager.PERMISSION_GRANTED) {
                // We don't have permission so prompt the user
                ActivityCompat.requestPermissions(
                        this,
                        PERMISSIONS_STORAGE,
                        REQUEST_EXTERNAL_STORAGE
                );
            }
            try {
                FileReader fr1 = new FileReader(file1);
                FileReader fr2 = new FileReader(file2);
                FileReader fr3 = new FileReader(file3);
                FileReader fr4 = new FileReader(file4);
                FileReader fr5 = new FileReader(file5);

                BufferedReader reader1 = new BufferedReader(fr1);
                BufferedReader reader2 = new BufferedReader(fr2);
                BufferedReader reader3 = new BufferedReader(fr3);
                BufferedReader reader4 = new BufferedReader(fr4);
                BufferedReader reader5 = new BufferedReader(fr5);

                String line1 = reader1.readLine();
                String line2 = reader2.readLine();
                String line3 = reader3.readLine();
                String line4 = reader4.readLine();
                String line5 = reader5.readLine();

                while (line1 != null) {
                    contentValues.put(DBHelper.KEY_RU_WORD, line1);
                    contentValues.put(DBHelper.KEY_EN_WORD, line2);
                    contentValues.put(DBHelper.KEY_EXAMPLES_EN, line3);
                    contentValues.put(DBHelper.KEY_EXAMPLES_RU, line4);
                    contentValues.put(DBHelper.KEY_TRANSCRIPTION, line5);
                    contentValues.put(DBHelper.KEY_PROGRESS, 0);
                    database.insert(DBHelper.TABLE_SLANG, null, contentValues);

                    line1 = reader1.readLine();
                    line2 = reader2.readLine();
                    line3 = reader3.readLine();
                    line4 = reader2.readLine();
                    line5 = reader3.readLine();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
*/
            //-----------------------------------------------------------------------------------------------------------
//            permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
//            file1 = new File("/storage/emulated/0/Android/data/Dula/rusWORDS/IDIOM.txt");
//            file2 = new File("/storage/emulated/0/Android/data/Dula/engWORDS/IDIOM.txt");
//            file3 = new File("/storage/emulated/0/Android/data/Dula/ExEn/IDIOM.txt");
//            file4 = new File("/storage/emulated/0/Android/data/Dula/ExRu/IDIOM.txt");
//
//            if (permission != PackageManager.PERMISSION_GRANTED) {
//                // We don't have permission so prompt the user
//                ActivityCompat.requestPermissions(
//                        this,
//                        PERMISSIONS_STORAGE,
//                        REQUEST_EXTERNAL_STORAGE
//                );
//            }
//            try {
//                FileReader fr1 = new FileReader(file1);
//                FileReader fr2 = new FileReader(file2);
//                FileReader fr3 = new FileReader(file3);
//                FileReader fr4 = new FileReader(file4);
//
//                BufferedReader reader1 = new BufferedReader(fr1);
//                BufferedReader reader2 = new BufferedReader(fr2);
//                BufferedReader reader3 = new BufferedReader(fr3);
//                BufferedReader reader4 = new BufferedReader(fr4);
//
//                String line1 = reader1.readLine();
//                String line2 = reader2.readLine();
//                String line3 = reader3.readLine();
//                String line4 = reader4.readLine();
//
//                while (line1 != null) {
//                    contentValues.put(DBHelper.KEY_RU_WORD, line1);
//                    contentValues.put(DBHelper.KEY_EN_WORD, line2);
//                    contentValues.put(DBHelper.KEY_EXAMPLES_EN, line3);
//                    contentValues.put(DBHelper.KEY_EXAMPLES_RU, line4);
//                    contentValues.put(DBHelper.KEY_PROGRESS, 0);
//                    database.insert(DBHelper.TABLE_IDIOMS, null, contentValues);
//
//                    line1 = reader1.readLine();
//                    line2 = reader2.readLine();
//                    line3 = reader3.readLine();
//                    line4 = reader4.readLine();
//                }
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            Intent intent = getIntent();
            int lesson_id = intent.getIntExtra("lesson_id", -1);
            String Category_name = intent.getStringExtra("Category_name");

            Cursor cursor_counter = null;
            if (Category_name.equals("TOP100")) {
                cursor_counter = database.query(dbHelper.TABLE_TOP100, null, null, null, null, null, null);
                cursor_counter.moveToFirst();
            } else if (Category_name.equals("TOP1000")) {
                cursor_counter = database.query(dbHelper.TABLE_TOP1000, null, null, null, null, null, null);
                cursor_counter.moveToFirst();
            } else if (Category_name.equals("ADJECTIVES")) {
                cursor_counter = database.query(dbHelper.TABLE_ADJECTIVES, null, null, null, null, null, null);
                cursor_counter.moveToFirst();
            } else if (Category_name.equals("IRREGULAR")) {
                cursor_counter = database.query(dbHelper.TABLE_IRREGULAR, null, null, null, null, null, null);
                cursor_counter.moveToFirst();
            } else if (Category_name.equals("PHRASAL")) {
                cursor_counter = database.query(dbHelper.TABLE_PHRASAL, null, null, null, null, null, null);
                cursor_counter.moveToFirst();
            } else if (Category_name.equals("ROUTINE")) {
                cursor_counter = database.query(dbHelper.TABLE_ROUTINE, null, null, null, null, null, null);
                cursor_counter.moveToFirst();
            } else if (Category_name.equals("TOP100")) {
                cursor_counter = database.query(dbHelper.TABLE_TOP100, null, null, null, null, null, null);
                cursor_counter.moveToFirst();
            } else if (Category_name.equals("SLANG")) {
                cursor_counter = database.query(dbHelper.TABLE_SLANG, null, null, null, null, null, null);
                cursor_counter.moveToFirst();
            } else if (Category_name.equals("HUMAN")) {
                cursor_counter = database.query(dbHelper.TABLE_HUMAN, null, null, null, null, null, null);
                cursor_counter.moveToFirst();
            } else if (Category_name.equals("HEALTH")) {
                cursor_counter = database.query(dbHelper.TABLE_HEALTH, null, null, null, null, null, null);
                cursor_counter.moveToFirst();
            } else if (Category_name.equals("COLORS")) {
                cursor_counter = database.query(dbHelper.TABLE_COLORS, null, null, null, null, null, null);
                cursor_counter.moveToFirst();
            } else if (Category_name.equals("INTERMEDIATE")) {
                cursor_counter = database.query(dbHelper.TABLE_INTERMEDIATE, null, null, null, null, null, null);
                cursor_counter.moveToFirst();
            } else if (Category_name.equals("NATURE")) {
                cursor_counter = database.query(dbHelper.TABLE_NATURE, null, null, null, null, null, null);
                cursor_counter.moveToFirst();
            } else if (Category_name.equals("IT")) {
                cursor_counter = database.query(dbHelper.TABLE_IT, null, null, null, null, null, null);
                cursor_counter.moveToFirst();
            } else if (Category_name.equals("CLOTHES")) {
                cursor_counter = database.query(dbHelper.TABLE_CLOTHES, null, null, null, null, null, null);
                cursor_counter.moveToFirst();
            }

            int row_count = 0;
            cursor_counter.moveToFirst();

            do {
                row_count = row_count + 1;
            } while (cursor_counter.moveToNext());

            //System.out.println(row_count + " - " + "row_count");
            int amountForOneLesson = row_count / 20;
            //System.out.println(amountForOneLesson + " - " + "amountForOneLesson");
            int startFromRow = amountForOneLesson * (lesson_id - 1);
            //System.out.println(startFromRow + " - " + "startFromRow");
            int untilRow = startFromRow + amountForOneLesson;
            //System.out.println(untilRow + " - " + "untilRow");

            //startFromRow = 0; untilRow = 5;
            cursor_counter.close();
            //System.out.println(untilRow + " - " + "untilRow");
            //Cursor cursor = database.query(dbHelper.TABLE_TOP100, null, null, null, null, null, null);
            Cursor cursor = null;
            if (Category_name.equals("TOP100")) {
                cursor = database.query(dbHelper.TABLE_TOP100, null, null, null, null, null, null);
            } else if (Category_name.equals("TOP1000")) {
                cursor = database.query(dbHelper.TABLE_TOP1000, null, null, null, null, null, null);
            } else if (Category_name.equals("ADJECTIVES")) {
                cursor = database.query(dbHelper.TABLE_ADJECTIVES, null, null, null, null, null, null);
            } else if (Category_name.equals("IRREGULAR")) {
                cursor = database.query(dbHelper.TABLE_IRREGULAR, null, null, null, null, null, null);
            } else if (Category_name.equals("PHRASAL")) {
                cursor = database.query(dbHelper.TABLE_PHRASAL, null, null, null, null, null, null);
            } else if (Category_name.equals("ROUTINE")) {
                cursor = database.query(dbHelper.TABLE_ROUTINE, null, null, null, null, null, null);
            } else if (Category_name.equals("TOP100")) {
                cursor = database.query(dbHelper.TABLE_TOP100, null, null, null, null, null, null);
            } else if (Category_name.equals("SLANG")) {
                cursor = database.query(dbHelper.TABLE_SLANG, null, null, null, null, null, null);
                startFromRow = 0;
                untilRow = row_count;
            } else if (Category_name.equals("CLOTHES")) {
                cursor = database.query(dbHelper.TABLE_CLOTHES, null, null, null, null, null, null);
                startFromRow = 0;
                untilRow = row_count;
            } else if (Category_name.equals("IT")) {
                cursor = database.query(dbHelper.TABLE_IT, null, null, null, null, null, null);
                startFromRow = 0;
                untilRow = row_count;
            } else if (Category_name.equals("INTERMEDIATE")) {
                cursor = database.query(dbHelper.TABLE_INTERMEDIATE, null, null, null, null, null, null);
                startFromRow = 0;
                untilRow = row_count;
            }  else if (Category_name.equals("HEALTH")) {
                cursor = database.query(dbHelper.TABLE_HEALTH, null, null, null, null, null, null);
                startFromRow = 0;
                untilRow = row_count;
            } else if (Category_name.equals("NATURE")) {
                cursor = database.query(dbHelper.TABLE_NATURE, null, null, null, null, null, null);
                startFromRow = 0;
                untilRow = row_count;
            } else if (Category_name.equals("COLORS")) {
                cursor = database.query(dbHelper.TABLE_COLORS, null, null, null, null, null, null);
                startFromRow = 0;
                untilRow = row_count;
            }  else if (Category_name.equals("HUMAN")) {
                cursor = database.query(dbHelper.TABLE_HUMAN, null, null, null, null, null, null);
                startFromRow = 0;
                untilRow = row_count;
            }

            if (cursor.moveToFirst()) {
                int idIndex = cursor.getColumnIndex(dbHelper.KEY_ID);
                int ru_wordIndex = cursor.getColumnIndex(dbHelper.KEY_RU_WORD);
                int en_wordIndex = cursor.getColumnIndex(dbHelper.KEY_EN_WORD);
                int exampleEnIndex = cursor.getColumnIndex(dbHelper.KEY_EXAMPLES_EN);
                int exampleRuIndex = cursor.getColumnIndex(dbHelper.KEY_EXAMPLES_RU);
                int transcriptionIndex = cursor.getColumnIndex(dbHelper.KEY_TRANSCRIPTION);
                int progressIndex = cursor.getColumnIndex(dbHelper.KEY_PROGRESS);

                for (int i = startFromRow; i < untilRow; i++) {
                    cursor.moveToPosition(i);
                    //System.out.println(i + " - i");
                    Transcriptions.add(cursor.getString(transcriptionIndex));
                    WordsEn.add(cursor.getString(en_wordIndex));
                    Words.add(cursor.getString(ru_wordIndex));
                    ExampleRu.add(cursor.getString(exampleRuIndex));
                    ExampleEn.add(cursor.getString(exampleEnIndex));
                }
            }
            cursor.close();

            //System.out.println(Transcriptions);System.out.println(WordsEn);System.out.println(Words);System.out.println(ExampleEn);System.out.println(ExampleRu);

            //Получаю с какой таблицей работать
            //String getTablenameFromMainActivity = "";
            //DBHelper.TABLE_AllWORDS = getTablenameFromMainActivity;

            ArrayList<ArrayList<String>> ExampleSetRu = new ArrayList();
            for (int i = 0; i < ExampleEn.size(); i++) {
                ArrayList<String> ExampleSetRu1 = new ArrayList<>();
                for (int j = 0; j < 2; j++) {
                    String pass = new String();
                    ExampleSetRu1.add(pass);
                }
                ExampleSetRu.add(ExampleSetRu1);
            }

            ArrayList<ArrayList<String>> ExampleSetEn = new ArrayList();
            for (int i = 0; i < ExampleEn.size(); i++) {
                ArrayList<String> ExampleSetRu1 = new ArrayList<>();
                for (int j = 0; j < 2; j++) {
                    String pass = new String();
                    ExampleSetRu1.add(pass);
                }
                ExampleSetEn.add(ExampleSetRu1);
            }
            List<String> stringList1;
            List<String> stringList;
            int c = -1;
            for (int k = 0; k < ExampleEn.size(); k++) {
                c++;
                String[] words = ExampleEn.get(k).split("Example: ");
                String[] words1 = ExampleRu.get(k).split("Пример: ");
                stringList = new ArrayList<String>(Arrays.asList(words));
                stringList.removeAll(Collections.singleton(null));
                stringList.removeAll(Collections.singleton(""));
                for (int i = 0; i < stringList.size(); i++) {
                    ExampleSetEn.get(c).add(stringList.get(i));
                }
                stringList1 = new ArrayList<String>(Arrays.asList(words1));
                stringList1.removeAll(Collections.singleton(null));
                stringList1.removeAll(Collections.singleton(""));
                for (int i = 0; i < stringList1.size(); i++) {
                    ExampleSetRu.get(c).add(stringList1.get(i));
                }

                //System.out.println("stringList.get(1)");
                //System.out.println(ExampleSetEn);System.out.println(ExampleSetRu);System.out.println("stringList.get(1)");
//                words = Arrays.stream(words)
//                        .filter(value ->
//                                value != null && value.length() > 0
//                        )
//                        .toArray(size -> new String[size]);
//
//                words1 = Arrays.stream(words1)
//                        .filter(value ->
//                                value != null && value.length() > 0
//                        )
//                        .toArray(size -> new String[size]);
//
//                List<String> list = Arrays.asList(words);
//                List<String> list1 = Arrays.asList(words1);

//                String en, ru;
//                ArrayList<String> en_array = new ArrayList<>();
//                ArrayList<String> ru_array = new ArrayList<>();
//                for(int qq = 0; qq < words.length; qq++){
//                    if(Array.get(words, qq).equals(null)){
//                        en_array.add((String) Array.get(words, qq));
//                    }
//                    if(Array.get(words, qq).equals(null)){
//                        ru_array.add((String) Array.get(words, qq));
//                    }
//                }
//                //System.out.println("en_array"); System.out.println(en_array);System.out.println("ru_array"); System.out.println(en_array);
//                //System.out.println(list); System.out.println(list1);
//                for(int z = 0; z < words.length; z++){
//                    //System.out.println("TEXT");
//                    //String en1 = "Example: " + list.get(z);
//                    //String ru1 = "Пример: " + list1.get(z);
//
//                    //System.out.println(en); System.out.println(ru);
//                    //(ExampleSetEn.get(k)).add(en1);
//                    //(ExampleSetRu.get(k)).add(ru1);
//                }
            }

            for(int i = 0; i < ExampleSetEn.size(); i++){
                ExampleSetEn.get(i).removeAll(Collections.singleton(null));
                ExampleSetEn.get(i).removeAll(Collections.singleton(""));
            }
            for(int i = 0; i < ExampleSetRu.size(); i++){
                ExampleSetRu.get(i).removeAll(Collections.singleton(null));
                ExampleSetRu.get(i).removeAll(Collections.singleton(""));
            }
            //System.out.println(ExampleSetEn.get(0)); System.out.println(ExampleSetRu);

            ArrayList<Integer> Imgs = new ArrayList<Integer>();
            Imgs.add(R.drawable.di);
            Imgs.add(R.drawable.d1);
            Imgs.add(R.drawable.d2);
            Imgs.add(R.drawable.d2);
            Imgs.add(R.drawable.d2);

            ImageView img777 = findViewById(R.id.imageView3);
            img777.setOnClickListener(v777 -> {
                Toast.makeText(this, "Ты нажал на фотку", Toast.LENGTH_SHORT).show();
            });

            final int[] iterate4 = {0};
            //НАЧАЛЬНАЯ ИНИЦИАЛИЗАЦИЯ
            TextView tv0 = findViewById(R.id.textView31);
            tv0.setText(WordsEn.get(iterate4[0]));

            TextView tv00 = findViewById(R.id.textView32);
            tv00.setText(Transcriptions.get(iterate4[0]));

            TextView tv000 = findViewById(R.id.textView33);
            tv000.setText(Words.get(iterate4[0]));

            TextView tv0000 = findViewById(R.id.textView34);
            tv0000.setText("Example: " + ExampleSetEn.get(iterate4[0]).get(0));

            TextView tv00000 = findViewById(R.id.textView44);
            tv00000.setText("Пример: " + ExampleSetRu.get(iterate4[0]).get(0));

            ImageView image0 = findViewById(R.id.imageView3);
            image0.setImageResource(Imgs.get(1));

            button = findViewById(R.id.button2);

            button.setOnClickListener(v -> {
                if (iterate4[0] != 0)
                    iterate4[0] = iterate4[0] - 1;

                TextView tv = findViewById(R.id.textView31);
                tv.setText(WordsEn.get(iterate4[0]));

                TextView tv1 = findViewById(R.id.textView32);
                tv1.setText(Transcriptions.get(iterate4[0]));

                TextView tv2 = findViewById(R.id.textView33);
                tv2.setText(Words.get(iterate4[0]));

                TextView tv3 = findViewById(R.id.textView34);
                tv3.setText("Example: " + ExampleSetEn.get(iterate4[0]).get(0));

                TextView tv4 = findViewById(R.id.textView44);
                tv4.setText("Пример: " + ExampleSetRu.get(iterate4[0]).get(0));

                ImageView image = findViewById(R.id.imageView3);
                image.setImageResource(Imgs.get(1));

            });

            button = findViewById(R.id.button1);
            button.setOnClickListener(v -> {

                if (iterate4[0] != Transcriptions.size() - 1)
                    iterate4[0] = iterate4[0] + 1;

                TextView tv = findViewById(R.id.textView31);
                tv.setText(WordsEn.get(iterate4[0]));

                TextView tv1 = findViewById(R.id.textView32);
                tv1.setText(Transcriptions.get(iterate4[0]));

                TextView tv2 = findViewById(R.id.textView33);
                tv2.setText(Words.get(iterate4[0]));

                TextView tv3 = findViewById(R.id.textView34);
                tv3.setText("Example: " + ExampleSetEn.get(iterate4[0]).get(0));

                TextView tv4 = findViewById(R.id.textView44);
                tv4.setText("Пример: " + ExampleSetRu.get(iterate4[0]).get(0));

                ImageView image = findViewById(R.id.imageView3);
                image.setImageResource(Imgs.get(1));
            });

            Button button1 = findViewById(R.id.button31);
            //ПРОВЕРИТЬ ЕСЛИ СЛОВО УЖЕ ЕСТЬ В БД, ТО
            //СКАЗАТЬ, ЧТО ОНО УЖЕ ЕСТЬ В БД
            button1.setOnClickListener(v1212 -> {
                contentValues.put(DBHelper.KEY_EN_WORD, WordsEn.get(iterate4[0]));
                contentValues.put(DBHelper.KEY_TRANSCRIPTION, Transcriptions.get(iterate4[0]));
                contentValues.put(DBHelper.KEY_RU_WORD, Words.get(iterate4[0]));
                contentValues.put(DBHelper.KEY_EXAMPLES_RU, ExampleRu.get(iterate4[0]));
                contentValues.put(DBHelper.KEY_EXAMPLES_EN, ExampleEn.get(iterate4[0]));
                contentValues.put(DBHelper.KEY_PROGRESS, 0);
                database.insert(DBHelper.TABLE_FAVORITE, null, contentValues);
                Toast.makeText(this, "Слово добавлено в избранное!", Toast.LENGTH_SHORT).show();
            });
        }); bhelp3.callOnClick();
    }

    public void TextChanger(View view) {
        dialogBuilder = new AlertDialog.Builder(this);
        final View contactPopupView = getLayoutInflater().inflate(R.layout.popup, null);
        newcontactpopup_textview = (EditText) contactPopupView.findViewById(R.id.epopup);

        newcontactpopup_send = (Button) contactPopupView.findViewById(R.id.sendButton);
        newcontactpopup_cancel = (Button) contactPopupView.findViewById(R.id.cancelButton);

        dialogBuilder.setView(contactPopupView);
        dialog = dialogBuilder.create();
        dialog.show();

        newcontactpopup_send.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity3.this, "Ваш вариант предложения отправлен на проверку", Toast.LENGTH_SHORT).show();
            }});
        newcontactpopup_cancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }});

    }
}

//package com.example.dula;
//
//import static com.example.dula.DBHelper.createDB;
//
//import android.Manifest;
//import android.content.pm.PackageManager;
//import android.database.Cursor;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.widget.Toolbar;
//import androidx.core.app.ActivityCompat;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//
//public class MainActivity3 extends AppCompatActivity {
//    private Button button;
//    DBHelper DB;
//    private static final int REQUEST_EXTERNAL_STORAGE = 1;
//    private static String[] PERMISSIONS_STORAGE = {
//            Manifest.permission.READ_EXTERNAL_STORAGE,
//            Manifest.permission.WRITE_EXTERNAL_STORAGE
//    };
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main3);
//        getSupportActionBar().hide();
//        getSupportActionBar().setDisplayShowTitleEnabled(true);
//
//        Toolbar toolbar4 = findViewById(R.id.toolbar4);
//        toolbar4.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
//
//        toolbar4.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MainActivity3.this.onBackPressed();
//            }
//        });
//
//
//        //ArrayList<String> Words = new ArrayList();
//        //ArrayList<String> WordsEn = new ArrayList();
//        //ArrayList<String> Transcriptions = new ArrayList();
//
//        DB = new DBHelper(this);
//
//        Button bhelp3 = findViewById(R.id.bhelp3);
//        bhelp3.setOnClickListener(v -> {
//            //СЧИТЫВАНИЕ ИЗ БД
//            Cursor res = DB.getdata();
//            if(res.getCount() == 0){
//                Toast.makeText(this, "База данных пуста", Toast.LENGTH_SHORT).show();
//                return;
//            }
//            StringBuffer buffer = new StringBuffer();
//            while (res.moveToNext()){
//                buffer.append("Name :"+res.getString(0)+"\n");
//            }
//        });
//
//
//        ArrayList<String> Words = new ArrayList();
//        Words.add("слово");
//        Words.add("цветок");
//        Words.add("белка");
//        Words.add("воздушный шар");
//
//        ArrayList<String> WordsEn = new ArrayList();
//        WordsEn.add("Word");
//        WordsEn.add("Flower");
//        WordsEn.add("Squirrel");
//        WordsEn.add("Hot air ballon");
//
//        ArrayList<String> Transcriptions = new ArrayList();
//        Transcriptions.add("[wз:d]");
//        Transcriptions.add("[ˈflaʊər]");
//        Transcriptions.add("[ˈskwɜːrəl]");
//        Transcriptions.add("[hɔt ɛə bəˈluːn]");
//
//        /*
//        ДЛЯ ТОГО, ЧТОБЫ ДОБАВИТЬ ИЗОБРАЖЕНИЯ НЕ НУЖНО
//        ДОБАВЛЯТЬ ИХ В БД МОЖНО ПРОСТО ДОБАВИТЬ ИХ
//        В drawable и добавить к arraylist вот так:
//        ArrayList<Integer> array_image = new ArrayList<Integer>();
//        array_image.add(R.drawable.image6);
//        array_image.add(R.drawable.image1);
//        */
//
//        ArrayList<Integer> Imgs = new ArrayList<Integer>();
//        Imgs.add(R.drawable.di);
//        Imgs.add(R.drawable.d1);
//        Imgs.add(R.drawable.d2);
//        Imgs.add(R.drawable.d3);
//
//
//        final int[] iterate4 = {0};
//        //НАЧАЛЬНАЯ ИНИЦИАЛИЗАЦИЯ
//        TextView tv0 = (TextView)findViewById(R.id.textView31);
//        tv0.setText(WordsEn.get(iterate4[0]));
//
//        TextView tv00 = (TextView)findViewById(R.id.textView32);
//        tv00.setText(Transcriptions.get(iterate4[0]));
//
//        TextView tv000 = (TextView)findViewById(R.id.textView33);
//        tv000.setText(Words.get(iterate4[0]));
//
//        ImageView image0 = (ImageView)findViewById(R.id.imageView3);
//        image0.setImageResource(Imgs.get(iterate4[0]));
//
//        button = findViewById(R.id.button2);
//        button.setOnClickListener(v -> {
//            if (iterate4[0] != 0)
//                iterate4[0] = iterate4[0] - 1;
//
//            TextView tv = (TextView)findViewById(R.id.textView31);
//            tv.setText(WordsEn.get(iterate4[0]));
//
//            TextView tv1 = (TextView)findViewById(R.id.textView32);
//            tv1.setText(Transcriptions.get(iterate4[0]));
//
//            TextView tv2 = (TextView)findViewById(R.id.textView33);
//            tv2.setText(Words.get(iterate4[0]));
//
//            ImageView image = (ImageView)findViewById(R.id.imageView3);
//            image.setImageResource(Imgs.get(iterate4[0]));
//
//        });
//
//        button = findViewById(R.id.button1);
//        button.setOnClickListener(v -> {
//
//            if (iterate4[0] != Transcriptions.size()-1)
//                iterate4[0] = iterate4[0] + 1;
//
//            TextView tv = (TextView)findViewById(R.id.textView31);
//            tv.setText(WordsEn.get(iterate4[0]));
//
//            TextView tv1 = (TextView)findViewById(R.id.textView32);
//            tv1.setText(Transcriptions.get(iterate4[0]));
//
//            TextView tv2 = (TextView)findViewById(R.id.textView33);
//            tv2.setText(Words.get(iterate4[0]));
//
//            ImageView image = (ImageView)findViewById(R.id.imageView3);
//            image.setImageResource(Imgs.get(iterate4[0]));
//        });
//
//        Button button1 = findViewById(R.id.button31);
//        //ПРОВЕРИТЬ ЕСЛИ СЛОВО УЖЕ ЕСТЬ В БД, ТО
//        //СКАЗАТЬ, ЧТО ОНО УЖЕ ЕСТЬ В БД
//        button1.setOnClickListener(v -> {
//            Boolean checkinsertdata = DB.insertuserdata(Words.get(iterate4[0]), WordsEn.get(iterate4[0]), Transcriptions.get(iterate4[0]));
//            if (checkinsertdata == true){
//                Toast.makeText(this, "Слово добавлено в избранное!", Toast.LENGTH_SHORT).show();
//            }
//            else{
//                Toast.makeText(this, "Слово уже было добавлено ранее", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//
//
//
//
//
//
//
//        button1.setOnClickListener(v -> {
//            int permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE );
//            File file1 = new File("/storage/emulated/0/ENGLISH.txt");
//            File file2 = new File("/storage/emulated/0/RUSSIAN.txt");
//            File file3 = new File("/storage/emulated/0/TRANSCRIPTION.txt");
//            System.out.println("ХЗ ПРОСТ ПРОВЕРКА");
//            if (permission != PackageManager.PERMISSION_GRANTED) {
//                System.out.println("РАЗРЕШЕНИЯ НЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕТ");
//                // We don't have permission so prompt the user
//                ActivityCompat.requestPermissions(
//                        this,
//                        PERMISSIONS_STORAGE,
//                        REQUEST_EXTERNAL_STORAGE
//                );
//            }
//            else {
//                System.out.println("ЕСТТЬ ПО ИДЕЕЕ");
//            }
//            try {
//                // создаем объект FileReader для объекта File
//                FileReader fr1 = new FileReader(file1);
//                FileReader fr2 = new FileReader(file2);
//                FileReader fr3 = new FileReader(file3);
//
//                // создаем BufferedReader с существующего FileReader для построчного считывания
//                BufferedReader reader1 = new BufferedReader(fr1);
//                BufferedReader reader2 = new BufferedReader(fr2);
//                BufferedReader reader3 = new BufferedReader(fr3);
//
//                // считаем сначала первую строку
//                String line1 = reader1.readLine();
//                String line2 = reader2.readLine();
//                String line3 = reader3.readLine();
//
//                createDB();
//                int iterator = 0;
//                while (line1 != null) {
//                    // System.out.println(line1);
//                    System.out.println(DB);
//                    System.out.println(line1);System.out.println(line2);System.out.println(line3);
//                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
//                    //Boolean checkinsertdata = DB.insertuserdata(line1, line2, line3);
//                    Boolean checkinsertdata1 = DB.insertDB(iterator, line1, line2, line3);
//                    iterator += 1;
//                    // считываем остальные строки в цикле
//                    line1 = reader1.readLine();
//                    line2 = reader2.readLine();
//                    line3 = reader3.readLine();
//                }
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });
//
//
//    }
//}