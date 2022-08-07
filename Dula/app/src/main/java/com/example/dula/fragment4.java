package com.example.dula;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class fragment4 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View myView = inflater.inflate(R.layout.fragment_fragment4, container, false);

        ArrayList<Integer> Btns = new ArrayList<Integer>();
        Btns.add(R.id.b41);     Btns.add(R.id.b42);     Btns.add(R.id.b43);     Btns.add(R.id.b44);     Btns.add(R.id.b45);
        Btns.add(R.id.b46);     Btns.add(R.id.b47);     Btns.add(R.id.b48);     Btns.add(R.id.b49);     Btns.add(R.id.b410);
        Btns.add(R.id.b411);    Btns.add(R.id.b412);    Btns.add(R.id.b413);    Btns.add(R.id.b414);    Btns.add(R.id.b415);
        Btns.add(R.id.b416);    Btns.add(R.id.b417);    Btns.add(R.id.b418);    Btns.add(R.id.b419);    Btns.add(R.id.b420);


        ArrayList<String> Lessons = new ArrayList();
        Lessons.add("Урок 1");   Lessons.add("Урок 2");   Lessons.add("Урок 3");   Lessons.add("Урок 4");   Lessons.add("Урок 5");
        Lessons.add("Урок 6");   Lessons.add("Урок 7");   Lessons.add("Урок 8");   Lessons.add("Урок 9");   Lessons.add("Урок 10");
        Lessons.add("Урок 11");  Lessons.add("Урок 12");  Lessons.add("Урок 13");  Lessons.add("Урок 14");  Lessons.add("Урок 15");
        Lessons.add("Урок 16");  Lessons.add("Урок 17");  Lessons.add("Урок 18");  Lessons.add("Урок 19");  Lessons.add("Урок 20");

        for(int i = 0; i < Lessons.size(); i++)
        {
            String x = Lessons.get(i) + " - Неправильные глаголы";
            Lessons.set(i, x);
        }
        String Category_name = "IRREGULAR";
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