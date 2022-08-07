package com.example.dula.ui.repeat;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.dula.DialogActivity;
import com.example.dula.MainActivity2;
import com.example.dula.R;
import com.example.dula.ScrollingActivity;
import com.example.dula.databinding.FragmentRepeatBinding;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class RepeatFragment extends Fragment {

    private FragmentRepeatBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_repeat, container, false);


        ArrayList<Integer> Btns = new ArrayList<Integer>();
        Btns.add(R.id.bz1); Btns.add(R.id.bz2);
        Btns.add(R.id.bz3); Btns.add(R.id.bz4);
        Btns.add(R.id.bz5); Btns.add(R.id.bz6);
        Btns.add(R.id.bz7); Btns.add(R.id.bz8);

        ArrayList<String> Dialogs = new ArrayList();
        Dialogs.add("Разговор с официантом");
        Dialogs.add("Продавец");
        Dialogs.add("Таксист");
        Dialogs.add("Встреча с другом");
        Dialogs.add("Встреча с президентом");
        Dialogs.add("Интервью у Опры");
        Dialogs.add("Спросить дорогу");
        Dialogs.add("Прием у врача");

        for(int i = 0; i < Dialogs.size(); i++)
        {
            String x = "Диалог - " + Dialogs.get(i);
            Dialogs.set(i, x);
        }


        for (int i = 0; i < Btns.size(); i++) {
            MaterialCardView cometchatStatusIndicator = (MaterialCardView) myView.findViewById(Btns.get(i));
            int finalI = i;
            cometchatStatusIndicator.setOnClickListener(view -> {
                Intent intent = new Intent(getActivity(), DialogActivity.class);
                intent.putExtra("toolbar_title", Dialogs.get(finalI));
                //intent.putExtra("screen",R.id.cometchat_status_indicator);
                startActivity(intent);
            });
        }



        //MaterialCardView cometchatStatusIndicator = (MaterialCardView) myView.findViewById(R.id.bz1);
        //cometchatStatusIndicator.setOnClickListener(view -> {
        //    Intent intent = new Intent(getActivity(), DialogActivity.class);
        //    //intent.putExtra("screen",R.id.cometchat_status_indicator);
        //    startActivity(intent);
        //});

        return myView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}