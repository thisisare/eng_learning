package com.example.dula;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.security.KeyStore;
import java.util.ArrayList;

public class MainActivity8 extends AppCompatActivity {
    final int[] Score = new int[1];
    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        getSupportActionBar().hide();

        getSupportActionBar().setDisplayShowTitleEnabled(true);

        Toolbar toolbar9 = findViewById(R.id.toolbar9);
        toolbar9.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        toolbar9.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity8.this.onBackPressed();
            }
        });


        ArrayList<String> Words = new ArrayList();
        ArrayList<String> WordsEn = new ArrayList();
        dbHelper = new DBHelper(this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ArrayList<String> Mixed = new ArrayList();

        ArrayList<Integer> List = new ArrayList<Integer>();
        for (int i1 = 0; i1 < Words.size(); i1++){
            List.add(i1);
        }
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
        final int[] i1 = {0};
        final int[] i2 = {0};
        final Button[] button0 = {(Button) findViewById(R.id.btnhelp8)};
        button0[0].setOnClickListener(v -> {

            TextView tv1 = (TextView)findViewById(R.id.textView81);
            tv1.setText(WordsEn.get(i1[0]));


            int Rand1 = (int) (Math.random()*100);
            if ((Rand1 >= 0) && (Rand1 <= 50)) i2[0] = i1[0];
            else {
                for(int k = 0; k < Words.size(); k++) {
                    int Rand2;
                    do {
                        Rand2 = (int) (Math.random() * Words.size()); //Выведет от 0 до 19 ранд число
                    }
                    while (Rand2 == i1[0]);
                    i2[0] = Rand2;
                }
            }
            TextView tv2 = (TextView)findViewById(R.id.textView82);
            tv2.setText(Words.get(i2[0]));

            Button button1 = (Button) findViewById(R.id.button81);
            button1.setOnClickListener(v1 -> {
                if(i1[0] == i2[0]) {
                    Toast.makeText(this, "Правильно!", Toast.LENGTH_SHORT).show();
                    if ((i1[0] != Words.size() - 1) && (Score[0] != 25)) {
                        Score[0] = Score[0] + (25 / Words.size());
                    }
                    else if ((i1[0] == Words.size() - 1) && (Score[0] != 25)){
                        Score[0] = Score[0] + (25 / Words.size()) + (25 % Words.size());
                    }
                    System.out.println("SCORE: " + Score[0]);

                    if (i1[0] < Words.size()) {
                        i1[0]++;
                    }


                    if (i1[0] != Words.size()) {
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                if (i1[0] != Words.size()) {
                                    button0[0].performClick();
                                }
                            }
                        }, 500);
                    }
                }
                else {
                    if (i1[0] == Words.size()) {
                        i1[0]-=1;
                    }
                    else {
                      Toast.makeText(this, "Неправильно!\n" + WordsEn.get(i1[0]) + " - " + Words.get(i1[0]), Toast.LENGTH_SHORT).show();
                      final Animation animShake = AnimationUtils.loadAnimation(this, R.anim.shake);
                      button1.startAnimation(animShake);
                      if (Score[0] != 0) {
                          Score[0] = Score[0] - (25 / Words.size());
                      }
                      System.out.println("SCORE: " + Score[0]);
                    }
                }
            });

            Button button2 = (Button) findViewById(R.id.button82);
            button2.setOnClickListener(v1 -> {
                if(i1[0] == i2[0]) {
                    Toast.makeText(this, "Неправильно!\n"  + WordsEn.get(i1[0]) + " - " + Words.get(i1[0]), Toast.LENGTH_SHORT).show();
                    final Animation animShake = AnimationUtils.loadAnimation(this, R.anim.shake);
                    button2.startAnimation(animShake);
                    if (Score[0] != 0) {
                        Score[0] = Score[0] - (25 / Words.size());
                    }
                    System.out.println("SCORE: " + Score[0]);
                }
                else {
                    Toast.makeText(this, "Правильно!", Toast.LENGTH_SHORT).show();
                    if ((i1[0] != Words.size() - 1) && (Score[0] != 25)) {
                        Score[0] = Score[0] + (25 / Words.size());
                    }
                    else if ((i1[0] == Words.size() - 1) && (Score[0] != 25)){
                        Score[0] = Score[0] + (25 / Words.size()) + (25 % Words.size());
                    }
                    System.out.println("SCORE: " + Score[0]);

                    if (i1[0] < Words.size()) {
                        i1[0]++;
                    }
                    if (i1[0] != Words.size()) {
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                if (i1[0] != Words.size()) {
                                    button0[0].performClick();
                                }
                            }
                        }, 500);
                    }
                }
            });
        });
        button0[0].callOnClick();
    }
}