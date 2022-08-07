package com.example.dula;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity6 extends AppCompatActivity {
    ArrayList<Integer> List = new ArrayList<Integer>();
    ArrayList<Integer> Btns = new ArrayList<Integer>();
    ArrayList<Integer> BtnsID = new ArrayList<Integer>();
    int Clicked1ID = -1;
    int Clicked2ID = -1;
    int iterate = 0;
    DBHelper dbHelper;
    boolean key = true; Button Clicked1, Clicked2; String btext1, btext2;
    Button button0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        getSupportActionBar().hide();

        getSupportActionBar().setDisplayShowTitleEnabled(true);

        Toolbar toolbar7 = findViewById(R.id.toolbar7);
        toolbar7.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        toolbar7.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity6.this.onBackPressed();
            }
        });
        ArrayList<String> Words = new ArrayList();
        ArrayList<String> WordsEn = new ArrayList();
        dbHelper = new DBHelper(this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        String CurrentCategory = "g";
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

        Intent intent = getIntent();
        int lesson_id = intent.getIntExtra("lesson_id", -1);
        String Category_name = intent.getStringExtra("Category_name");

        Cursor cursor_counter = null;
        if (Category_name.equals("TOP100")) {
            cursor_counter = database.query(dbHelper.TABLE_TOP100, null, null, null, null, null, null);
            cursor_counter.moveToFirst();
            CurrentCategory = "TOP100";
        } else if (Category_name.equals("TOP1000")) {
            cursor_counter = database.query(dbHelper.TABLE_TOP1000, null, null, null, null, null, null);
            cursor_counter.moveToFirst();
            CurrentCategory = "TOP1000";
        } else if (Category_name.equals("ADJECTIVES")) {
            cursor_counter = database.query(dbHelper.TABLE_ADJECTIVES, null, null, null, null, null, null);
            cursor_counter.moveToFirst();
            CurrentCategory = "ADJECTIVES";
        } else if (Category_name.equals("IRREGULAR")) {
            cursor_counter = database.query(dbHelper.TABLE_IRREGULAR, null, null, null, null, null, null);
            cursor_counter.moveToFirst();
            CurrentCategory = "IRREGULAR";
        } else if (Category_name.equals("PHRASAL")) {
            cursor_counter = database.query(dbHelper.TABLE_PHRASAL, null, null, null, null, null, null);
            cursor_counter.moveToFirst();
            CurrentCategory = "PHRASAL";
        } else if (Category_name.equals("ROUTINE")) {
            cursor_counter = database.query(dbHelper.TABLE_ROUTINE, null, null, null, null, null, null);
            cursor_counter.moveToFirst();
            CurrentCategory = "ROUTINE";
        } else if (Category_name.equals("TOP100")) {
            cursor_counter = database.query(dbHelper.TABLE_TOP100, null, null, null, null, null, null);
            cursor_counter.moveToFirst();
            CurrentCategory = "TOP100";
        } else if (Category_name.equals("SLANG")) {
            cursor_counter = database.query(dbHelper.TABLE_SLANG, null, null, null, null, null, null);
            cursor_counter.moveToFirst();
            CurrentCategory = "SLANG";
        } else if (Category_name.equals("HUMAN")) {
            cursor_counter = database.query(dbHelper.TABLE_HUMAN, null, null, null, null, null, null);
            cursor_counter.moveToFirst();
            CurrentCategory = "HUMAN";
        } else if (Category_name.equals("HEALTH")) {
            cursor_counter = database.query(dbHelper.TABLE_HEALTH, null, null, null, null, null, null);
            cursor_counter.moveToFirst();
            CurrentCategory = "HEALTH";
        } else if (Category_name.equals("COLORS")) {
            cursor_counter = database.query(dbHelper.TABLE_COLORS, null, null, null, null, null, null);
            cursor_counter.moveToFirst();
            CurrentCategory = "COLORS";
        } else if (Category_name.equals("INTERMEDIATE")) {
            cursor_counter = database.query(dbHelper.TABLE_INTERMEDIATE, null, null, null, null, null, null);
            cursor_counter.moveToFirst();
            CurrentCategory = "INTERMEDIATE";
        } else if (Category_name.equals("NATURE")) {
            cursor_counter = database.query(dbHelper.TABLE_NATURE, null, null, null, null, null, null);
            cursor_counter.moveToFirst();
            CurrentCategory = "NATURE";
        } else if (Category_name.equals("IT")) {
            cursor_counter = database.query(dbHelper.TABLE_IT, null, null, null, null, null, null);
            cursor_counter.moveToFirst();
            CurrentCategory = "IT";
        } else if (Category_name.equals("CLOTHES")) {
            cursor_counter = database.query(dbHelper.TABLE_CLOTHES, null, null, null, null, null, null);
            cursor_counter.moveToFirst();
            CurrentCategory = "CLOTHES";
        }

        int row_count = 0;
        cursor_counter.moveToFirst();

        do {
            row_count = row_count + 1;
        } while (cursor_counter.moveToNext());

        int amountForOneLesson = row_count / 20;
        int startFromRow = amountForOneLesson * (lesson_id - 1);
        int untilRow = startFromRow + amountForOneLesson;

        cursor_counter.close();

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
            int progressIndex = cursor.getColumnIndex(dbHelper.KEY_PROGRESS);

            for (int i = startFromRow; i < untilRow; i++) {
                cursor.moveToPosition(i);
                WordsEn.add(cursor.getString(en_wordIndex));
                Words.add(cursor.getString(ru_wordIndex));
            }
        }
        cursor.close();

//        ArrayList<String> Words = new ArrayList();
//        Words.add("слово");
//        Words.add("цветок");
//        Words.add("белка");
//        Words.add("воздушный шар");
//
//        Words.add("Привет");
//        Words.add("Мир");
//        Words.add("Небо");
//        Words.add("Солнце");
//
//        Words.add("Огонь");
//        Words.add("Камень");
//        Words.add("Глаз");
//        Words.add("Тело");
//
//        Words.add("слово12");
//        Words.add("слово13");
//        Words.add("слово14");
//        Words.add("слово15");
//
//        Words.add("слово16");
//        Words.add("слово17");
//        Words.add("слово18");
//        Words.add("слово19");
//
//        ArrayList<String> WordsEn = new ArrayList();
//        WordsEn.add("Word");
//        WordsEn.add("Flower");
//        WordsEn.add("Squirrel");
//        WordsEn.add("Hot air ballon");
//
//        WordsEn.add("Hello");
//        WordsEn.add("World");
//        WordsEn.add("Sky");
//        WordsEn.add("Sun");
//
//        WordsEn.add("Fire");
//        WordsEn.add("Stone");
//        WordsEn.add("Eye");
//        WordsEn.add("Body");
//
//        WordsEn.add("Word12");
//        WordsEn.add("Word13");
//        WordsEn.add("Word14");
//        WordsEn.add("Word15");
//
//        WordsEn.add("Word16");
//        WordsEn.add("Word17");
//        WordsEn.add("Word18");
//        WordsEn.add("Word19");


        Btns.add(R.id.button_collectp1); BtnsID.add(Btns.get(0));
        Btns.add(R.id.button_collectp2); BtnsID.add(Btns.get(1));
        Btns.add(R.id.button_collectp3); BtnsID.add(Btns.get(2));
        Btns.add(R.id.button_collectp4); BtnsID.add(Btns.get(3));
        Btns.add(R.id.button_collectp5); BtnsID.add(Btns.get(4));
        Btns.add(R.id.button_collectp6); BtnsID.add(Btns.get(5));
        Btns.add(R.id.button_collectp7); BtnsID.add(Btns.get(6));
        Btns.add(R.id.button_collectp8); BtnsID.add(Btns.get(7));


        for (int i1 = 0; i1 < Btns.size(); i1++){
            List.add(i1);
        }
        final int[] count = {0};
        int critical_group = WordsEn.size() - 1;
        int index_start = (critical_group - (critical_group % 4)) - 4;
        int index_finish = (critical_group - (critical_group % 4));
        System.out.println("index_start " + index_start);System.out.println("index_finish " + index_finish);
        button0 = findViewById(R.id.btnhelp6);
        button0.setOnClickListener(v -> {
            iterate = 0;
            Collections.shuffle(List);//Получаю набор рандомных цифр
            for (int i = 0; i < List.size() - 1; i = i+2) {

                Button button = findViewById(Btns.get(List.get(i)));//кнопка с индексом List[i] становится англ
                Button button2 = findViewById(Btns.get(List.get(i+1)));//кнопка с индексом List[i+1] становится русс

                button.setVisibility (View.VISIBLE);//назначаю их видимыми
                button2.setVisibility (View.VISIBLE);//назначаю их видимыми

                ViewCompat.setBackgroundTintList(button2, ColorStateList.valueOf(Color.parseColor("#B1B1B1")));//цвета
                ViewCompat.setBackgroundTintList(button, ColorStateList.valueOf(Color.parseColor("#1B5F55")));//цвета

                button.setText(WordsEn.get(count[0]));//установка текста
                button2.setText(Words.get(count[0]));//установка текста

                button.setEnabled(true);//работающие кнопки
                button2.setEnabled(true);//работающие кнопки

                count[0]++;//индекс для прохода по массиву со словами
                if(index_finish == count[0]){
                    count[0] = index_start;
                }

            }
            final int[] c2 = {0};//счетчик пар слов в группе (их всего 8, 4 пары)
            final Button[] Clicked1 = new Button[1];//первая нажатая кнопка
            final Button[] Clicked2 = { null };//вторая нажатая кнопка
            //Button b000 = findViewById(R.id.btnhelp62);
            for (int i = 0; i < Btns.size(); i++) {
                Button button3 = findViewById(Btns.get(List.get(i)));//обработка нажатия на первую кнопку
                int finalI = i;
                button3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v1) {
                        Game(v1);
                    }
//                    Clicked1[0] = button3; //заносим ее в массив нажатых
//                    for (int j = 0; j < Btns.size(); j++) {
//                        Button button4 = findViewById(Btns.get(List.get(j))); //обработка второй кнопки
//                        int finalJ = j;
//                        button4.setOnClickListener(v2 -> {
//                            //КАЖЕТСЯ ЭТОТ if НЕ НУЖЕН
////                            if (Clicked2[0] == null) { //если не нажимали до этого на вторую, то заносим ее
////                                Clicked2[0] = button4;
////                            }
////                            if (finalI % 2 == 0 && finalJ == finalI + 1 ||
////                                    finalI % 2 != 0 && finalJ == finalI - 1) { //если нужная нам кнопка
////                                button3.setEnabled(false); //выключаем обе кнопки
////                                button4.setEnabled(false); //выключаем обе кнопки
////                                button3.setVisibility(View.INVISIBLE);//делаем их невидимыми
////                                button4.setVisibility(View.INVISIBLE);//делаем их невидимыми
////                                Clicked1[0] = null;//обнуляем массив нажатых кнопок
////                                Clicked2[0] = null;//обнуляем массив нажатых кнопок
////                                c2[0]++; //переходим к следующей паре слов в этой группе
////                                if (c2[0] == 4) { //если это последняя пара
////                                    SystemClock.sleep(500); //недолгая задержка на 0,5 секунды
////                                    button0.callOnClick();//переходим к следующей группе 4 пар слов
////                                }
////                            }
////                            else { //если выбрали неправильно
////                                final Animation animShake = AnimationUtils.loadAnimation(this, R.anim.shake);
////                                Clicked1[0].startAnimation(animShake);//трясем обе кнопки
////                                Clicked2[0].startAnimation(animShake);//трясем обе кнопки
////                                Clicked1[0] = null;//обнуляем массив нажатых кнопок
////                                Clicked2[0] = null;//обнуляем массив нажатых кнопок
////                            }
//                        });
//                        break;
//                    }
                });

            }
        });
        button0.callOnClick();
    }
    public void Game(View v) {

        if(key){
            Clicked1 = (Button)v;
            Clicked2 = null;
            btext2 = "";
            btext1 = Clicked1.getText().toString();
            key = false;
            for(int x = 0; x < BtnsID.size(); x++)
            {
                if(BtnsID.get(x) == Clicked1.getId())
                {
                    Clicked1ID = x;
                }
            }
            //System.out.println("Clicked1ID " + Clicked1ID);
        }
        else if(!key){
            Clicked2 = (Button)v;
            btext2 = Clicked2.getText().toString();
            key = true;
            for(int x = 0; x < BtnsID.size(); x++)
            {
                if(BtnsID.get(x) == Clicked2.getId())
                {
                    Clicked2ID = x;
                }
            }
            //System.out.println("Clicked2ID " + Clicked2ID);

            //System.out.println("Clicked1 " + Clicked1);System.out.println("Clicked2 " + Clicked2);
            //System.out.println("btext1 " + btext1);System.out.println("btext2 " + btext2);
            //System.out.println("List.get(0) " + List.get(0));System.out.println("List.get(1) " + List.get(1));
            System.out.println("List: " + List);
            //System.out.println("Btns.get(List.get(0)): " + Btns.get(List.get(0)));System.out.println("Btns.get(List.get(1)): " + Btns.get(List.get(1)));
            //System.out.println("Btns: " + Btns);
            for(int ii = 0; ii < List.size(); ii++){
                if (Clicked1ID == List.get(ii)) {
                    //System.out.println("ii " + ii);
                    //System.out.println("Clicked1ID " + Clicked1ID);
                    //System.out.println("Clicked2ID " + Clicked2ID);
                    //System.out.println("List.get(ii) " + List.get(ii));
                    if (((ii % 2 == 0) && (Clicked1ID == List.get(ii) && Clicked2ID == List.get(ii + 1)))
                            || ((ii % 2 != 0) && (Clicked1ID == List.get(ii) && Clicked2ID == List.get(ii - 1)))) {
                        //System.out.println("ПРАВИЛЬНО ");
                        //final Animation animShake = AnimationUtils.loadAnimation(this, R.anim.shake);
                        //Clicked1.startAnimation(animShake);//трясем обе кнопки
                        //Clicked2.startAnimation(animShake);//трясем обе кнопки
                        Clicked1.setEnabled(false); //выключаем обе кнопки
                        Clicked2.setEnabled(false); //выключаем обе кнопки
                        Clicked1.setVisibility(View.INVISIBLE);//делаем их невидимыми
                        Clicked2.setVisibility(View.INVISIBLE);//делаем их невидимыми
                        Clicked1 = null;//обнуляем массив нажатых кнопок
                        Clicked2 = null;//обнуляем массив нажатых кнопок
                        iterate++;
                        if (iterate==4){
                            button0.callOnClick();//переходим к следующей группе 4 пар слов
                        }
                        break;
                    } else {
                        System.out.println("НЕПРАВИЛЬНО "); System.out.println("Clicked1 " + Clicked1);
                        final Animation animShake = AnimationUtils.loadAnimation(this, R.anim.shake);
                        Clicked1.startAnimation(animShake);//трясем обе кнопки
                        Clicked2.startAnimation(animShake);//трясем обе кнопки
                        //Clicked1 = null;//обнуляем массив нажатых кнопок
                        //Clicked2 = null;//обнуляем массив нажатых кнопок
                    }
                }
//                else if (ii % 2 != 0){
//                    //if (Clicked1ID == Btns.get(List.get(ii)) && Clicked2ID == Btns.get(List.get(ii - 1))) {
//                        if (Clicked1ID == List.get(ii) && Clicked2ID == List.get(ii - 1)) {
//                        System.out.println("ПРАВИЛЬНО ");
////                        Clicked1.setEnabled(false); //выключаем обе кнопки
////                        Clicked2.setEnabled(false); //выключаем обе кнопки
////                        Clicked1.setVisibility(View.INVISIBLE);//делаем их невидимыми
////                        Clicked2.setVisibility(View.INVISIBLE);//делаем их невидимыми
////                        Clicked1 = null;//обнуляем массив нажатых кнопок
////                        Clicked2 = null;//обнуляем массив нажатых кнопок
//                    }
//                    else{
//                        System.out.println("НЕПРАВИЛЬНО ");
////                        final Animation animShake = AnimationUtils.loadAnimation(this, R.anim.shake);
////                        Clicked1.startAnimation(animShake);//трясем обе кнопки
////                        Clicked2.startAnimation(animShake);//трясем обе кнопки
////                        Clicked1 = null;//обнуляем массив нажатых кнопок
////                        Clicked2 = null;//обнуляем массив нажатых кнопок
//                    }
                //}
            }
        }



        //int g = Clicked1.getId();




    }
}