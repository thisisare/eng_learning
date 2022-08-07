package com.example.dula;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;


public class fragment0 extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View myView = inflater.inflate(R.layout.fragment_fragment0, container, false);

        ArrayList<Integer> Btns = new ArrayList<Integer>();
        Btns.add(R.id.b01); Btns.add(R.id.b02); Btns.add(R.id.b03); Btns.add(R.id.b04); Btns.add(R.id.b05);
        Btns.add(R.id.b06); Btns.add(R.id.b07); Btns.add(R.id.b08); Btns.add(R.id.b09); Btns.add(R.id.b010);
        Btns.add(R.id.b011); Btns.add(R.id.b012); Btns.add(R.id.b013); Btns.add(R.id.b014); Btns.add(R.id.b015);
        Btns.add(R.id.b016); Btns.add(R.id.b017); Btns.add(R.id.b018); Btns.add(R.id.b019); Btns.add(R.id.b020);

        ArrayList<String> Lessons = new ArrayList();
        Lessons.add("Урок 1");   Lessons.add("Урок 2");   Lessons.add("Урок 3");   Lessons.add("Урок 4");   Lessons.add("Урок 5");
        Lessons.add("Урок 6");   Lessons.add("Урок 7");   Lessons.add("Урок 8");   Lessons.add("Урок 9");   Lessons.add("Урок 10");
        Lessons.add("Урок 11");  Lessons.add("Урок 12");  Lessons.add("Урок 13");  Lessons.add("Урок 14");  Lessons.add("Урок 15");
        Lessons.add("Урок 16");  Lessons.add("Урок 17");  Lessons.add("Урок 18");  Lessons.add("Урок 19");  Lessons.add("Урок 20");
        ArrayList<String> Category_name = new ArrayList();
        Category_name.add("ALLWORDS"); Category_name.add("IDIOMS"); Category_name.add("SLANG");   Category_name.add("CLOTHES");   Category_name.add("IT");
        Category_name.add("HEALTH"); Category_name.add("NATURE");   Category_name.add("TAYLORSWIFT");   Category_name.add("KATYPERRY");   Category_name.add("LANADELREY");
        Category_name.add("EMINEM");  Category_name.add("EUPHORIA");  Category_name.add("SHERLOCK");  Category_name.add("FRIENDS");  Category_name.add("SHREK");
        Category_name.add("MADAGASKAR");  Category_name.add("COLORS");  Category_name.add("HUMAN");  Category_name.add("PREINTERMEDIATE");  Category_name.add("INTERMEDIATE");


        for(int i = 0; i < Lessons.size(); i++)
        {
            String x = Lessons.get(i) + " - Дополнительные уроки";
            Lessons.set(i, x);
        }
        //String Category_name = "TOP100";
        for (int i = 0; i < Btns.size(); i++) {
            MaterialCardView cometchatStatusIndicator = (MaterialCardView) myView.findViewById(Btns.get(i));
            int finalI = i;
            cometchatStatusIndicator.setOnClickListener(view -> {
                Intent intent = new Intent(getActivity(), MainActivity2.class);
                intent.putExtra("toolbar_title", Lessons.get(finalI));
                intent.putExtra("lesson_id", finalI + 1);
                intent.putExtra("Category_name", Category_name.get(finalI));
                startActivity(intent);
            });
        }

        return myView;
    }
}