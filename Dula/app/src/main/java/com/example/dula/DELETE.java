//package com.example.dula;
//
//import static com.example.dula.DBHelper.createDB;
//
//import android.Manifest;
//import android.content.ContentValues;
//import android.content.pm.PackageManager;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
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
//    DBHelper dbHelper;
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
//        dbHelper = new DBHelper(this);
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
//            Boolean checkinsertdata = dbHelper.insertuserdata(Words.get(iterate4[0]), WordsEn.get(iterate4[0]), Transcriptions.get(iterate4[0]));
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
//                    System.out.println(dbHelper);
//                    System.out.println(line1);System.out.println(line2);System.out.println(line3);
//                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
//                    //Boolean checkinsertdata = dbHelper.insertuserdata(line1, line2, line3);
//                    //Boolean checkinsertdata1 = dbHelper.insertDB(iterator, line1, line2, line3);
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
//    public void onClick(View v)
//    {
//        SQLiteDatabase database = dbHelper.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//
//        Button bhelp3 = findViewById(R.id.bhelp3);
//        bhelp3.setOnClickListener(v22 -> {
//            //СЧИТЫВАНИЕ ИЗ БД
//            Cursor cursor = database.query(dbHelper.TABLE_CONTACTS, null, null, null, null, null, null);
//            if (cursor.moveToFirst()) { //all rows  needs moveToNext() i guess
//                int idIndex = cursor.getColumnIndex(dbHelper.KEY_ID);
//                int nameIndex = cursor.getColumnIndex(dbHelper.KEY_NAME);
//                int emailIndex = cursor.getColumnIndex(dbHelper.KEY_MAIL);
//                do {
//                    Lod.d("mLog", "ID = " + cursor.getInt(idIndex) +
//                            ", name = " + cursor.getInt(nameIndex) +
//                            ", email = " + cursor.getInt(emailIndex));
//                } while (cursor.moveToNext());
//            } else
//                Log.d("mLog", "0 rows");
//            cursor.close();
//        }); bhelp3.callOnClick();
//    }
//}