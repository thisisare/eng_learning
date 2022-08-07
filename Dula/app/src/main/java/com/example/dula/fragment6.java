package com.example.dula;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;


public class fragment6 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_fragment6, container, false);

        ArrayList<Integer> Btns = new ArrayList<Integer>();
        Btns.add(R.id.b61);     Btns.add(R.id.b62);     Btns.add(R.id.b63);     Btns.add(R.id.b64);     Btns.add(R.id.b65);
        Btns.add(R.id.b66);     Btns.add(R.id.b67);     Btns.add(R.id.b68);     Btns.add(R.id.b69);     Btns.add(R.id.b610);
        Btns.add(R.id.b611);    Btns.add(R.id.b612);    Btns.add(R.id.b613);    Btns.add(R.id.b614);    Btns.add(R.id.b615);
        Btns.add(R.id.b616);    Btns.add(R.id.b617);    Btns.add(R.id.b618);    Btns.add(R.id.b619);    Btns.add(R.id.b620);

        ArrayList<String> Lessons = new ArrayList();
        Lessons.add("Урок 1");   Lessons.add("Урок 2");   Lessons.add("Урок 3");   Lessons.add("Урок 4");   Lessons.add("Урок 5");
        Lessons.add("Урок 6");   Lessons.add("Урок 7");   Lessons.add("Урок 8");   Lessons.add("Урок 9");   Lessons.add("Урок 10");
        Lessons.add("Урок 11");  Lessons.add("Урок 12");  Lessons.add("Урок 13");  Lessons.add("Урок 14");  Lessons.add("Урок 15");
        Lessons.add("Урок 16");  Lessons.add("Урок 17");  Lessons.add("Урок 18");  Lessons.add("Урок 19");  Lessons.add("Урок 20");

        for(int i = 0; i < Lessons.size(); i++)
        {
            String x = Lessons.get(i) + " - Бытовая лексика";
            Lessons.set(i, x);
        }
        String Category_name = "ROUTINE";


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