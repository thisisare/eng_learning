package com.example.dula;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity5 extends AppCompatActivity {
    private Button button;
    final int[] Score = new int[1];
    DBHelper dbHelper;
    public static ContentValues contentValues = new ContentValues();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        getSupportActionBar().hide();

        getSupportActionBar().setDisplayShowTitleEnabled(true);

        Toolbar toolbar6 = findViewById(R.id.toolbar6);
        toolbar6.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        toolbar6.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity5.this.onBackPressed();
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

        ArrayList<Integer> List = new ArrayList<Integer>();//Брать любое слово из списка (всегда разное)
        for (int i1 = 0; i1 < Words.size(); i1++){
            List.add(i1);
        }

        ArrayList<Integer> Imgs = new ArrayList<Integer>();
        Imgs.add(R.drawable.di);
        Imgs.add(R.drawable.d1);
        Imgs.add(R.drawable.d2);
        Imgs.add(R.drawable.d3);

        for(int i = 0; i < WordsEn.size(); i++) {
            String str = WordsEn.get(i);
            List<String> characters = Arrays.asList(str.split(""));
            Collections.shuffle(characters);
            String afterShuffle = "";
            for (String character : characters) {
                afterShuffle += character;
            }
            Mixed.add(afterShuffle.toLowerCase());
        }

        final int[] iterate4 = {0};
        Collections.shuffle(List);

        Button button0 = (Button) findViewById(R.id.btnhelp5);

        button0.setOnClickListener(v -> {

        //НАЧАЛЬНАЯ ИНИЦИАЛИЗАЦИЯ
        TextView tv0 = (TextView)findViewById(R.id.textView51);
        tv0.setText(Words.get(List.get(iterate4[0])));

        TextView tv00 = (TextView)findViewById(R.id.textView52);
        tv00.setText(Mixed.get((List.get(iterate4[0]))));

        ImageView image0 = (ImageView)findViewById(R.id.imageView51);
        image0.setImageResource(Imgs.get(0));

        button = findViewById(R.id.button51);
        button.setOnClickListener(v1 -> {

            String name;
            EditText ed1;
            do {
                ed1 = findViewById(R.id.edittext51);
                name = ed1.getText().toString();
                if (name.matches("")) {
                    Toast.makeText(this, "Хмм.. вы ничего не ввели", Toast.LENGTH_SHORT).show();
                    return;
                }
            } while (name.matches(""));
            name = name.toLowerCase();
            String name1 = name.substring(0, 1).toLowerCase();
            String name2 = name1 + name.substring(1);
            name = name2;


            //System.out.println("Words.size(): " + Words.size()); System.out.println("Words: " + Words);
            //System.out.println("Ваш ввод: " + name); System.out.println("WordsEn.get((List.get(iterate4[0])))): " + WordsEn.get((List.get(iterate4[0]))));

            if (name.equals(WordsEn.get((List.get(iterate4[0]))))) {
                Toast.makeText(this, "Правильно", Toast.LENGTH_SHORT).show();
                if ((iterate4[0] != WordsEn.size() - 1) && (Score[0] != 25)) {
                    Score[0] = Score[0] + (25 / WordsEn.size());
                }
                else if ((iterate4[0] == WordsEn.size() - 1) && (Score[0] != 25)){
                    Score[0] = Score[0] + (25 / WordsEn.size()) + (25 % WordsEn.size());
                }
//                for(int o = finalStartFromRow; o < finalUntilRow; o++){
//                    finalCursor1.moveToPosition(o);
//                    contentValues.put(DBHelper.KEY_PROGRESS, Score[0]);
//                    if (Category_name.equals("TOP100")) {
//                        database.insert(DBHelper.TABLE_TOP100, null, contentValues);
//                    } else if (Category_name.equals("TOP1000")) {
//                        database.insert(DBHelper.TABLE_TOP1000, null, contentValues);
//                    } else if (Category_name.equals("ADJECTIVES")) {
//                        database.insert(DBHelper.TABLE_ADJECTIVES, null, contentValues);
//                    } else if (Category_name.equals("IRREGULAR")) {
//                        database.insert(DBHelper.TABLE_IRREGULAR, null, contentValues);
//                    } else if (Category_name.equals("PHRASAL")) {
//                        database.insert(DBHelper.TABLE_PHRASAL, null, contentValues);
//                    } else if (Category_name.equals("ROUTINE")) {
//                        database.insert(DBHelper.TABLE_ROUTINE, null, contentValues);
//                    } else if (Category_name.equals("TOP100")) {
//                        database.insert(DBHelper.TABLE_TOP100, null, contentValues);
//                    } else if (Category_name.equals("SLANG")) {
//                        database.insert(DBHelper.TABLE_SLANG, null, contentValues);
//                    } else if (Category_name.equals("CLOTHES")) {
//                        database.insert(DBHelper.TABLE_CLOTHES, null, contentValues);
//                    } else if (Category_name.equals("IT")) {
//                        database.insert(DBHelper.TABLE_IT, null, contentValues);
//                    } else if (Category_name.equals("INTERMEDIATE")) {
//                        database.insert(DBHelper.TABLE_INTERMEDIATE, null, contentValues);
//                    }  else if (Category_name.equals("HEALTH")) {
//                        database.insert(DBHelper.TABLE_HEALTH, null, contentValues);
//                    } else if (Category_name.equals("NATURE")) {
//                        database.insert(DBHelper.TABLE_NATURE, null, contentValues);
//                    } else if (Category_name.equals("COLORS")) {
//                        database.insert(DBHelper.TABLE_COLORS, null, contentValues);
//                    }  else if (Category_name.equals("HUMAN")) {
//                        database.insert(DBHelper.TABLE_HUMAN, null, contentValues);
//                    }
//
//                }
            }
            else {
                Toast.makeText(this, "Неправильно " + Words.get(List.get(iterate4[0])) + " - " + WordsEn.get((List.get(iterate4[0]))), Toast.LENGTH_SHORT).show();
                if (Score[0] != 0) {
                    Score[0] = Score[0] - (25 / WordsEn.size());
                }
//                for(int o = finalStartFromRow; o < finalUntilRow; o++){
//                    finalCursor1.moveToPosition(o);
//                    contentValues.put(DBHelper.KEY_PROGRESS, Score[0]);
//                    if (Category_name.equals("TOP100")) {
//                        database.insert(DBHelper.TABLE_TOP100, null, contentValues);
//                    } else if (Category_name.equals("TOP1000")) {
//                        database.insert(DBHelper.TABLE_TOP1000, null, contentValues);
//                    } else if (Category_name.equals("ADJECTIVES")) {
//                        database.insert(DBHelper.TABLE_ADJECTIVES, null, contentValues);
//                    } else if (Category_name.equals("IRREGULAR")) {
//                        database.insert(DBHelper.TABLE_IRREGULAR, null, contentValues);
//                    } else if (Category_name.equals("PHRASAL")) {
//                        database.insert(DBHelper.TABLE_PHRASAL, null, contentValues);
//                    } else if (Category_name.equals("ROUTINE")) {
//                        database.insert(DBHelper.TABLE_ROUTINE, null, contentValues);
//                    } else if (Category_name.equals("TOP100")) {
//                        database.insert(DBHelper.TABLE_TOP100, null, contentValues);
//                    } else if (Category_name.equals("SLANG")) {
//                        database.insert(DBHelper.TABLE_SLANG, null, contentValues);
//                    } else if (Category_name.equals("CLOTHES")) {
//                        database.insert(DBHelper.TABLE_CLOTHES, null, contentValues);
//                    } else if (Category_name.equals("IT")) {
//                        database.insert(DBHelper.TABLE_IT, null, contentValues);
//                    } else if (Category_name.equals("INTERMEDIATE")) {
//                        database.insert(DBHelper.TABLE_INTERMEDIATE, null, contentValues);
//                    }  else if (Category_name.equals("HEALTH")) {
//                        database.insert(DBHelper.TABLE_HEALTH, null, contentValues);
//                    } else if (Category_name.equals("NATURE")) {
//                        database.insert(DBHelper.TABLE_NATURE, null, contentValues);
//                    } else if (Category_name.equals("COLORS")) {
//                        database.insert(DBHelper.TABLE_COLORS, null, contentValues);
//                    }  else if (Category_name.equals("HUMAN")) {
//                        database.insert(DBHelper.TABLE_HUMAN, null, contentValues);
//                    }
//
//                }
                SystemClock.sleep(500);
            }

            if (iterate4[0] != Mixed.size() - 1)
                iterate4[0] = iterate4[0] + 1;
            ed1.getText().clear();
            button0.callOnClick();
        });
        });
        button0.callOnClick();

    }
}
