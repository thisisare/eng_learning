//package com.example.dula;
//
//import android.content.res.ColorStateList;
//import android.graphics.Color;
//import android.os.Bundle;
//import android.os.SystemClock;
//import android.view.View;
//import android.view.animation.Animation;
//import android.view.animation.AnimationUtils;
//import android.widget.Button;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.widget.Toolbar;
//import androidx.core.view.ViewCompat;
//
//import java.util.ArrayList;
//import java.util.Collections;
//
//public class MainActivity6 extends AppCompatActivity {
//    private Button button, button4;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main6);
//        getSupportActionBar().hide();
//
//        getSupportActionBar().setDisplayShowTitleEnabled(true);
//
//        Toolbar toolbar7 = findViewById(R.id.toolbar7);
//        toolbar7.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
//        toolbar7.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MainActivity6.this.onBackPressed();
//            }
//        });
//
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
//
//        ArrayList<Integer> Btns = new ArrayList<Integer>();
//        Btns.add(R.id.button_collectp1);
//        Btns.add(R.id.button_collectp2);
//        Btns.add(R.id.button_collectp3);
//        Btns.add(R.id.button_collectp4);
//        Btns.add(R.id.button_collectp5);
//        Btns.add(R.id.button_collectp6);
//        Btns.add(R.id.button_collectp7);
//        Btns.add(R.id.button_collectp8);
//
//        ArrayList<Integer> List = new ArrayList<Integer>();
//        for (int i1 = 0; i1 < Btns.size(); i1++){
//            List.add(i1);
//        }
//        final int[] count = {0};
//        Button button0 = findViewById(R.id.btnhelp6);
//        button0.setOnClickListener(v -> {
//
//            Collections.shuffle(List);//Получаю набор рандомных цифр
//            for (int i = 0; i < List.size() - 1; i = i+2) {
//
//                Button button = findViewById(Btns.get(List.get(i)));//кнопка с индексом List[i] становится англ
//                Button button2 = findViewById(Btns.get(List.get(i+1)));//кнопка с индексом List[i+1] становится русс
//
//                button.setVisibility (View.VISIBLE);//назначаю их видимыми
//                button2.setVisibility (View.VISIBLE);//назначаю их видимыми
//
//                ViewCompat.setBackgroundTintList(button2, ColorStateList.valueOf(Color.parseColor("#B1B1B1")));//цвета
//                ViewCompat.setBackgroundTintList(button, ColorStateList.valueOf(Color.parseColor("#1B5F55")));//цвета
//
//                button.setText(WordsEn.get(count[0]));//установка текста
//                button2.setText(Words.get(count[0]));//установка текста
//
//                button.setEnabled(true);//работающие кнопки
//                button2.setEnabled(true);//работающие кнопки
//
//                count[0]++;//индекс для прохода по массиву со словами
//
//            }
//            final int[] c2 = {0};//счетчик пар слов в группе (их всего 8, 4 пары)
//            final Button[] Clicked1 = new Button[1];//первая нажатая кнопка
//            final Button[] Clicked2 = { null };//вторая нажатая кнопка
//            //Button b000 = findViewById(R.id.btnhelp62);
//            for (int i = 0; i < Btns.size(); i++) {
//                Button button3 = findViewById(Btns.get(List.get(i)));//обработка нажатия на первую кнопку
//                int finalI = i;
//                button3.setOnClickListener(v1 -> {
//                    Clicked1[0] = button3; //заносим ее в массив нажатых
//                    for (int j = 0; j < Btns.size(); j++) {
//                        Button button4 = findViewById(Btns.get(List.get(j))); //обработка второй кнопки
//                        int finalJ = j;
//                        button4.setOnClickListener(v2 -> {
//                            //КАЖЕТСЯ ЭТОТ if НЕ НУЖЕН
//                            if (Clicked2[0] == null) { //если не нажимали до этого на вторую, то заносим ее
//                                Clicked2[0] = button4;
//                            }
//                            if (finalI % 2 == 0 && finalJ == finalI + 1 ||
//                                    finalI % 2 != 0 && finalJ == finalI - 1) { //если нужная нам кнопка
//                                button3.setEnabled(false); //выключаем обе кнопки
//                                button4.setEnabled(false); //выключаем обе кнопки
//                                button3.setVisibility(View.INVISIBLE);//делаем их невидимыми
//                                button4.setVisibility(View.INVISIBLE);//делаем их невидимыми
//                                Clicked1[0] = null;//обнуляем массив нажатых кнопок
//                                Clicked2[0] = null;//обнуляем массив нажатых кнопок
//                                c2[0]++; //переходим к следующей паре слов в этой группе
//                                if (c2[0] == 4) { //если это последняя пара
//                                    SystemClock.sleep(500); //недолгая задержка на 0,5 секунды
//                                    button0.callOnClick();//переходим к следующей группе 4 пар слов
//                                }
//                            }
//                            else { //если выбрали неправильно
//                                final Animation animShake = AnimationUtils.loadAnimation(this, R.anim.shake);
//                                Clicked1[0].startAnimation(animShake);//трясем обе кнопки
//                                Clicked2[0].startAnimation(animShake);//трясем обе кнопки
//                                Clicked1[0] = null;//обнуляем массив нажатых кнопок
//                                Clicked2[0] = null;//обнуляем массив нажатых кнопок
//                            }
//                        });
//                        break;
//                    }
//                });
//
//            }
//        });
//        button0.callOnClick();
//    }
//}