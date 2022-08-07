package com.example.dula;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;


public class fragment5 extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_fragment5, container, false);

        ArrayList<Integer> Btns = new ArrayList<Integer>();
        Btns.add(R.id.b51);     Btns.add(R.id.b52);     Btns.add(R.id.b53);     Btns.add(R.id.b54);     Btns.add(R.id.b55);
        Btns.add(R.id.b56);     Btns.add(R.id.b57);     Btns.add(R.id.b58);     Btns.add(R.id.b59);     Btns.add(R.id.b510);
        Btns.add(R.id.b511);    Btns.add(R.id.b512);    Btns.add(R.id.b513);    Btns.add(R.id.b514);    Btns.add(R.id.b515);
        Btns.add(R.id.b516);    Btns.add(R.id.b517);    Btns.add(R.id.b518);    Btns.add(R.id.b519);    Btns.add(R.id.b520);

        ArrayList<String> Lessons = new ArrayList();
        Lessons.add("Урок 1");   Lessons.add("Урок 2");   Lessons.add("Урок 3");   Lessons.add("Урок 4");   Lessons.add("Урок 5");
        Lessons.add("Урок 6");   Lessons.add("Урок 7");   Lessons.add("Урок 8");   Lessons.add("Урок 9");   Lessons.add("Урок 10");
        Lessons.add("Урок 11");  Lessons.add("Урок 12");  Lessons.add("Урок 13");  Lessons.add("Урок 14");  Lessons.add("Урок 15");
        Lessons.add("Урок 16");  Lessons.add("Урок 17");  Lessons.add("Урок 18");  Lessons.add("Урок 19");  Lessons.add("Урок 20");

        for(int i = 0; i < Lessons.size(); i++)
        {
            String x = Lessons.get(i) + " - Фразовые глаголы";
            Lessons.set(i, x);
        }
        String Category_name = "PHRASAL";

        for (int i = 0; i < Btns.size(); i++) {
            MaterialCardView cometchatStatusIndicator = (MaterialCardView) myView.findViewById(Btns.get(i));
            int finalI = i;
            cometchatStatusIndicator.setOnClickListener(view -> {
                Intent intent = new Intent(getActivity(), MainActivity2.class);
                intent.putExtra("toolbar_title", Lessons.get(finalI));
                intent.putExtra("lesson_id", finalI + 1);
                intent.putExtra("Category_name", Category_name);
                startActivity(intent);
            });
        }
        return myView;
    }
}