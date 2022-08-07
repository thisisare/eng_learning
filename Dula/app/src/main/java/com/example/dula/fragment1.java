package com.example.dula;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;


public class fragment1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View myView = inflater.inflate(R.layout.fragment_fragment1, container, false);

        ArrayList<Integer> Btns = new ArrayList<Integer>();
        Btns.add(R.id.b11); Btns.add(R.id.b12); Btns.add(R.id.b13); Btns.add(R.id.b14); Btns.add(R.id.b15);
        Btns.add(R.id.b16); Btns.add(R.id.b17); Btns.add(R.id.b18); Btns.add(R.id.b19); Btns.add(R.id.b110);
        Btns.add(R.id.b111); Btns.add(R.id.b112); Btns.add(R.id.b113); Btns.add(R.id.b114); Btns.add(R.id.b115);
        Btns.add(R.id.b116); Btns.add(R.id.b117); Btns.add(R.id.b118); Btns.add(R.id.b119); Btns.add(R.id.b120);

        ArrayList<String> Lessons = new ArrayList();
        Lessons.add("Урок 1");   Lessons.add("Урок 2");   Lessons.add("Урок 3");   Lessons.add("Урок 4");   Lessons.add("Урок 5");
        Lessons.add("Урок 6");   Lessons.add("Урок 7");   Lessons.add("Урок 8");   Lessons.add("Урок 9");   Lessons.add("Урок 10");
        Lessons.add("Урок 11");  Lessons.add("Урок 12");  Lessons.add("Урок 13");  Lessons.add("Урок 14");  Lessons.add("Урок 15");
        Lessons.add("Урок 16");  Lessons.add("Урок 17");  Lessons.add("Урок 18");  Lessons.add("Урок 19");  Lessons.add("Урок 20");

        for(int i = 0; i < Lessons.size(); i++)
        {
            String x = Lessons.get(i) + " - ТОП 100";
            Lessons.set(i, x);
        }
        String Category_name = "TOP100";

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

        //MainActivity5 activity = (MainActivity5) getActivity();
        //int myDataFromActivity = activity.getMyData();


        //MaterialCardView cometchatStatusIndicator1 = (MaterialCardView) myView.findViewById(R.id.b12);
        //cometchatStatusIndicator1.setOnClickListener(view -> {
        //    Intent intent = new Intent(getActivity(), MainActivity2.class);
        //    //intent.putExtra("screen",R.id.cometchat_status_indicator);
        //    startActivity(intent);
       //});





        //}

        //Button button1 = myView.findViewById(R.id.b11);
        //button1.setOnClickListener(v -> {
        //    Intent intent = new Intent(getActivity(), MainActivity2.class);
        //    startActivity(intent);
        //});
//
        //Button button2 = myView.findViewById(R.id.b12);
        //button2.setOnClickListener(v -> {
        //    Intent intent = new Intent(getActivity(), ComponentListActivity.class);
        //    startActivity(intent);
        //});

        return myView;
    }
}