package com.example.dula;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {
    private Button button;
    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        getSupportActionBar().hide();

        getSupportActionBar().setDisplayShowTitleEnabled(true);

        Toolbar toolbar5 = findViewById(R.id.toolbar5);
        toolbar5.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        toolbar5.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity4.this.onBackPressed();
            }
        });


        ArrayList<String> Words = new ArrayList();
        ArrayList<String> WordsEn = new ArrayList();
        ArrayList<String> Transcriptions = new ArrayList();
        dbHelper = new DBHelper(this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        String OpenHint = "Нажмите, чтобы\n" +
                          "открыть перевод";

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
            int transcriptionIndex = cursor.getColumnIndex(dbHelper.KEY_TRANSCRIPTION);
            int progressIndex = cursor.getColumnIndex(dbHelper.KEY_PROGRESS);

            for (int i = startFromRow; i < untilRow; i++) {
                cursor.moveToPosition(i);
                Transcriptions.add(cursor.getString(transcriptionIndex));
                WordsEn.add(cursor.getString(en_wordIndex));
                Words.add(cursor.getString(ru_wordIndex));
            }
        }
        cursor.close();

        ArrayList<Integer> Imgs = new ArrayList<Integer>();
        Imgs.add(R.drawable.di);
        Imgs.add(R.drawable.d1);
        Imgs.add(R.drawable.d2);
        Imgs.add(R.drawable.d3);

        final int[] iterate4 = {0};
        final boolean[] key = {false};
        final boolean[] z = {false};
        Button b0 = findViewById(R.id.btnhelp4);
        b0.setOnClickListener(v -> {

            TextView tv0 = (TextView) findViewById(R.id.textView41);
            tv0.setText(WordsEn.get(iterate4[0]));

            TextView tv00 = (TextView) findViewById(R.id.textView42);
            tv00.setText(Transcriptions.get(iterate4[0]));

            TextView tv000 = (TextView) findViewById(R.id.textView43);
            ImageView image = (ImageView) findViewById(R.id.imageView4);

            if(iterate4[0] != Words.size() - 1) {
                tv000.setText(OpenHint);

                image.setImageResource(Imgs.get(1));
                image.setVisibility(View.GONE);
            }
            else if(!z[0]) {
                tv000.setText(OpenHint);

                image.setImageResource(Imgs.get(1));
                image.setVisibility(View.GONE);
                z[0] = true;
            }
            else {
                tv000.setText(Words.get(iterate4[0]));
                image.setVisibility(View.VISIBLE);
            }

            button = findViewById(R.id.button1);
            button.setOnClickListener(v2 -> {
                if (key[0] == false) {
                    TextView tv2 = (TextView) findViewById(R.id.textView43);
                    tv2.setText(Words.get(iterate4[0]));
                    image.setVisibility(View.VISIBLE);

                    key[0] = true;
                    //System.out.println("2iterate4[0]");
                    //System.out.println(iterate4[0]);
                }
                else if (key[0] == true) {
                    if (iterate4[0] != Transcriptions.size()-1) {
                        iterate4[0] = iterate4[0] + 1;
                    }
                    key[0] = false;

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (iterate4[0] != Words.size()) {
                                b0.performClick();
                            }
                        }
                    }, 0);
                }
            });
        });
        b0.callOnClick();
    }
}