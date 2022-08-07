package com.example.dula;


import android.content.Intent;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;

import java.util.ArrayList;
import java.util.Collections;


public class MainActivity7 extends AppCompatActivity {
    final int[] Score = new int[1];
    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        getSupportActionBar().hide();

        getSupportActionBar().setDisplayShowTitleEnabled(true);

        Toolbar toolbar8 = findViewById(R.id.toolbar8);
        toolbar8.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        toolbar8.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity7.this.onBackPressed();
            }
        });


        ArrayList<String> Words = new ArrayList();
        ArrayList<String> WordsEn = new ArrayList();
        dbHelper = new DBHelper(this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ArrayList<String> Mixed = new ArrayList();

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
        System.out.println("startFromRow: " + startFromRow);System.out.println("untilRow: " + untilRow);
        System.out.println("Words.size(): " + Words.size()); System.out.println("Words: " + Words);
        System.out.println("WordsEn: " + WordsEn);

        ArrayList<Integer> Btns1 = new ArrayList<Integer>();
        Btns1.add(R.id.button_chooset6);
        Btns1.add(R.id.button_chooset5);
        Btns1.add(R.id.button_chooset4);
        Btns1.add(R.id.button_chooset3);
        Btns1.add(R.id.button_chooset2);
        Btns1.add(R.id.button_chooset1);

        ArrayList<String> OptionsExtended = new ArrayList();
        OptionsExtended.add("you"); OptionsExtended.add("sky"); OptionsExtended.add("oil"); OptionsExtended.add("butter");
        OptionsExtended.add("all"); OptionsExtended.add("smile"); OptionsExtended.add("shine"); OptionsExtended.add("high");
        OptionsExtended.add("money"); OptionsExtended.add("shoe"); OptionsExtended.add("real"); OptionsExtended.add("climb");
        OptionsExtended.add("mother"); OptionsExtended.add("album"); OptionsExtended.add("shine"); OptionsExtended.add("stuck");
        final int[] iterate = {0};
        Button button0 = findViewById(R.id.btnhelp7);
        button0.setOnClickListener(v -> {
            int ind = -1;
            TextView tv = (TextView) findViewById(R.id.textView71);
            tv.setText(Words.get(iterate[0]));
            ArrayList<String> Options = new ArrayList();
            Options.add(WordsEn.get(iterate[0]));

            if(WordsEn.size() == 6) {
                    for(int i = 0; i < 5; i++) {
                        int r;
                        boolean k;
                        do {
                            System.out.println(i);
                            r = (int) (Math.random() * WordsEn.size());
                            k = Options.contains(WordsEn.get(r));

                            System.out.println("WordsEn.size()" + WordsEn.size());
                            System.out.println("Options.size()" + Options.size());

                            if (WordsEn.size() == Options.size()) {
                                break;
                            }
                            //System.out.println(k);
                        } while (r == iterate[0] || k);
                        Options.add(WordsEn.get(r));
                    }
                }
            else {
                        for(int i = 0; i < 4; i++) {
                            int r;
                            boolean k;
                            do {
                                System.out.println(i);
                                r = (int) (Math.random() * WordsEn.size());
                                k = Options.contains(WordsEn.get(r));

                                System.out.println("WordsEn.size()" + WordsEn.size());
                                System.out.println("Options.size()" + Options.size());

                                if (WordsEn.size() == Options.size()) {
                                    break;
                                }
                                //System.out.println(k);
                            } while (r == iterate[0] || k);
                            Options.add(WordsEn.get(r));
                        }
                }

            System.out.println("Options" + Options);
            boolean key1 = true;
            if(Options.size()<6){
                while(Options.size() != 6){
                    int r = (int) (Math.random() * OptionsExtended.size());
                    if(Options.contains(OptionsExtended.get(r))){
                        key1 = false;
                    }

                    if(key1){
                        //System.out.println("CHECCKKKK" );
                        Options.add(OptionsExtended.get(r));
                    }
                    key1 = true;
                }
            }
            Collections.shuffle(Options);

            for(int i = 0; i < Options.size(); i++) {
                if((Options.get(i)).equals(WordsEn.get(iterate[0]))) ind = i;
            }

            for(int i = 0; i < Btns1.size(); i++) {
                Button button = findViewById(Btns1.get(i));
                button.setText(Options.get(i));
                //button.setBackgroundColor(getResources().getColor(R.color.grey));
                ViewCompat.setBackgroundTintList(button, ColorStateList.valueOf(Color.GRAY));
                //button.setBackgroundColor(Color.GRAY);
            }

            for(int i = 0; i < Btns1.size(); i++) {
                Button b0 = findViewById(Btns1.get(i));
                int finalInd = ind;
                int finalI = i;
                b0.setOnClickListener(v1 -> {
                    if(finalI == finalInd)
                    {
                        ViewCompat.setBackgroundTintList(b0, ColorStateList.valueOf(Color.GREEN));
                        if ((iterate[0] != Words.size() - 1) && (Score[0] != 25)) {
                            Score[0] = Score[0] + (25 / Words.size());
                        }
                        else if ((iterate[0] == Words.size() - 1) && (Score[0] != 25)){
                            Score[0] = Score[0] + (25 / WordsEn.size()) + (25 % WordsEn.size());
                        }
                        //System.out.println("SCORE: " + Score[0]);
                        iterate[0]++;
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                if (iterate[0] != Words.size()) button0.performClick();
                            }
                        }, 1000);
                    }
                    else {
                        ViewCompat.setBackgroundTintList(b0, ColorStateList.valueOf(Color.RED));
                        Button b00 = findViewById(Btns1.get(finalInd));
                        final Animation animShake = AnimationUtils.loadAnimation(this, R.anim.shake);
                        //Button btn_done = (Button) findViewById(Btns1.get(finalI));
                        b0.startAnimation(animShake);

                        if (Score[0] != 0) {
                            Score[0] = Score[0] - (25 / Words.size());
                        }
                        System.out.println("SCORE: " + Score[0]);

                        //iterate[0]++;

                        //Handler handler = new Handler();
                        //handler.postDelayed(new Runnable() {
                        //    @Override
                        //    public void run() {
                        //        button0.performClick();
                        //    }
                        //}, 500);

                        //performclicking(Btns1, Words, WordsEn, iterate);

                    }
                    //button0.performClick();
                    //button0.setOnClickListener();
                });
                //button0.performClick();
            }

        });
        button0.callOnClick();
        }

}