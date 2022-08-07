package com.example.dula;

import static com.google.android.material.internal.ViewUtils.dpToPx;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.dula.ui.repeat.RepeatFragment;

import java.util.ArrayList;
import java.util.Collections;

public class DialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        //getSupportActionBar().hide();
        //getSupportActionBar().setDisplayShowTitleEnabled(true);


        //getSupportActionBar().hide();
        //getSupportActionBar().setDisplayShowTitleEnabled(true);

        Toolbar toolbar3 = findViewById(R.id.toolbardialog);
        toolbar3.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);

        Intent intent1 = getIntent();
        String toolbar_title = intent1.getStringExtra("toolbar_title");

        setSupportActionBar(toolbar3);
        getSupportActionBar().setTitle(toolbar_title);


        toolbar3.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogActivity.this.onBackPressed();
            }
        });


        ArrayList<String> Words = new ArrayList();
        Words.add("Welcome to our restaurant. Here are your menus. Are you ready to order?" +
                "\nДобро пожаловать в наш ресторан. Вот ваши меню. Вы готовы сделать заказ?");
        Words.add("Would you like anything to drink?\nХотели бы вы что-нибудь выпить?");
        Words.add("Would you like anything else?\nЧто-нибудь еще?");
        Words.add("Would you like any dessert?\nХотели бы вы десерт?");
        //Words.add("ТЕКСТ БОТА 5");
        //Words.add("ТЕКСТ БОТА 6");
        //Words.add("ТЕКСТ БОТА 7ТЕКСТ БОТА 7ТЕКСТ БОТА 7ТЕКСТ БОТА 7ТЕКСТ БОТА 7ТЕКСТ БОТА 7");
        //Words.add("ТЕКСТ БОТА 8");
        //Words.add("ТЕКСТ БОТА 9");
        //Words.add("ТЕКСТ БОТА 10");

        ArrayList<String> WordsEn = new ArrayList();
        WordsEn.add("I’ll have the fried potato." +
                "\nЯ буду жаренную картошку");
        WordsEn.add("I’ll have tea\nЯ буду чай");
        WordsEn.add("Yes, please. I would like some boiled vegetables." +
                "\nДа, пожалуйста. Я бы хотел вареных овощей");
        WordsEn.add("No, thank you\nНет, спасибо");

        ArrayList<String> BadOptions = new ArrayList();
        BadOptions.add("Yes, I like to watch movies\nДа, мне тоже нравится смотреть фильмы");
        BadOptions.add("I've never been to London\nЯ никогда не был в Лондоне");
        BadOptions.add("Do you believe in God?\nВы верите в Бога?");
        BadOptions.add("I was also disappointed with the ending of Game of Thrones\nЯ тоже был разочарован концовкой «Игры престолов»");
        BadOptions.add("No, I don't know her\nНет, я не знаю ее");
        BadOptions.add("I go to swimming pool at least twice in a week\nЯ иду в бассейн как минимум дважды в неделю");
        BadOptions.add("This meat is underdone\nЭто мясо недожарено");
        BadOptions.add("Have a good day!\nХорошего дня!");

        ArrayList<Integer> Btns1 = new ArrayList<Integer>();
        Btns1.add(R.id.bdi1);
        Btns1.add(R.id.bdi2);
        Btns1.add(R.id.bdi3);

        ScrollView scrollView = (ScrollView) findViewById(R.id.svdialog);

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ll1);

        final int[] iterate = {0};
        Button button0 = findViewById(R.id.btndialog);
        button0.setOnClickListener(v -> {
            int ind = -1;

            Button btext = new Button(this);
            btext.setVisibility(View.VISIBLE);
            btext.setTextColor(ColorStateList.valueOf(Color.parseColor("#FFFFFFFF")));
            ViewCompat.setBackgroundTintList(btext, ColorStateList.valueOf(Color.parseColor("#121330")));
            btext.setText(Words.get(iterate[0]));
            btext.setGravity(Gravity.CENTER | Gravity.LEFT);

            LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params1.gravity = Gravity.LEFT;
            params1.setMargins(0, 5, 200, 5);
            btext.setPadding(18, 18, 25, 18);
            btext.setLayoutParams(params1);
            btext.setTransformationMethod(null);

            GradientDrawable gdDefault = new GradientDrawable();
            gdDefault.setCornerRadius(40);
            btext.setBackgroundDrawable(gdDefault);
            linearLayout.addView(btext);

            Handler handler1 = new Handler();
            handler1.postDelayed(new Runnable() {
                @Override
                public void run() {
                    scrollView.scrollTo(0, (int) btext.getY());
                }
            }, 0);


            ArrayList<String> Options = new ArrayList();
            Options.add(WordsEn.get(iterate[0]));
            int r1 = 3456;
            for (int i = 0; i < 2; i++) {
                int r;
                do {
                    r = (int) (Math.random() * WordsEn.size());
                } while (r == iterate[0] || r == r1);
                r1 = r;
                Options.add(BadOptions.get(r));
            }
            Collections.shuffle(Options);

            for (int i = 0; i < Options.size(); i++) {
                if ((Options.get(i)).equals(WordsEn.get(iterate[0]))) ind = i;
            }

            for (int i = 0; i < Btns1.size(); i++) {
                Button button = findViewById(Btns1.get(i));
                button.setText(Options.get(i));
            }

            for (int i = 0; i < Btns1.size(); i++) {
                Button b0 = findViewById(Btns1.get(i));
                int finalInd = ind;
                int finalI = i;
                b0.setOnClickListener(v1 -> {
                    if (finalI == finalInd) {
                        Button btext1 = new Button(this);
                        btext1.setVisibility(View.VISIBLE);
                        btext1.setTextColor(ColorStateList.valueOf(Color.parseColor("#FFFFFFFF")));
                        ViewCompat.setBackgroundTintList(btext1, ColorStateList.valueOf(Color.parseColor("#5B6EDC")));
                        btext1.setText(WordsEn.get(iterate[0]));
                        btext1.setGravity(Gravity.CENTER | Gravity.LEFT);
                        btext1.setTransformationMethod(null);
                        //НИЖНЯЯ СТРОЧКА ВООБЩЕ НЕ РАБОТАЕТ КАЖЕТСЯ ТАМ ТОЖЕ HANDLER

                        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                        params.gravity = Gravity.RIGHT;
                        params.setMargins(200, 5, 0, 5);
                        btext1.setPadding(18, 18, 25, 18);
                        btext1.setLayoutParams(params);

                        GradientDrawable gdDefault1 = new GradientDrawable();
                        gdDefault1.setCornerRadius(40);
                        btext1.setBackgroundDrawable(gdDefault1);
                        linearLayout.addView(btext1);

                        iterate[0]++;

                        Handler ingiborgadapkunaite = new Handler();
                        ingiborgadapkunaite.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                scrollView.scrollTo(0, (int) btext1.getY());
                            }
                        }, 0);

                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                button0.performClick();
                            }
                        }, 500);


                    } else {
                        final Animation animShake = AnimationUtils.loadAnimation(this, R.anim.shake);
                        Button btn_done = (Button) findViewById(Btns1.get(finalI));
                        btn_done.startAnimation(animShake);

                    }
                });
            }
        });
        button0.callOnClick();
    }
}

