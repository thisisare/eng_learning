package com.example.dula.ui.zoi;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.dula.MainActivity2;
import com.example.dula.R;
import com.example.dula.ScrollingActivity;
import com.example.dula.databinding.FragmentZoiBinding;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class ZoiFragment extends Fragment {

    private FragmentZoiBinding binding;
    MaterialCardView cometchatStatusIndicator;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View myView = inflater.inflate(R.layout.fragment_zoi, container, false);
        //WebView webView = myView.findViewById(R.id.webview12);
        //webView.getSettings().setJavaScriptEnabled(true);
        //webView.loadUrl("https://www.amalgama-lab.com/");

        //View myView = inflater.inflate(R.layout.fragment_zoi, container, false);

        ArrayList<Integer> Btns = new ArrayList<Integer>();
        Btns.add(R.id.bz1); Btns.add(R.id.bz2); Btns.add(R.id.bz3); Btns.add(R.id.bz4);
        Btns.add(R.id.bz5); Btns.add(R.id.bz6); Btns.add(R.id.bz7); Btns.add(R.id.bz8);

        ArrayList<String> urlki = new ArrayList();
        urlki.add("https://eng360.ru/the-wonderful-wizard-of-oz");
        urlki.add("https://liteka.ru/english/library/98-robinson-crusoe");
        urlki.add("https://linguabooster.com/ru/en/book/mejzliks-case");
        urlki.add("https://linguabooster.com/ru/en/book/old-beggar-woman");
        urlki.add("https://linguabooster.com/ru/en/book/purloined-letter");
        urlki.add("https://linguabooster.com/ru/en/book/fathers-and-sons");
        urlki.add("https://linguabooster.com/ru/en/book/a-new-years-eve-adventure");
        urlki.add("https://envoc.ru/text/parallelnye-teksty/anglijskie-anekdoty");

        for (int i = 0; i < Btns.size(); i++) {
            MaterialCardView cometchatStatusIndicator = (MaterialCardView) myView.findViewById(Btns.get(i));
            int finalI = i;
            cometchatStatusIndicator.setOnClickListener(view -> {
                Intent intent = new Intent(getActivity(), ScrollingActivity.class);
                intent.putExtra("urlka", urlki.get(finalI));
                //intent.putExtra("screen",R.id.cometchat_status_indicator);
                startActivity(intent);
            });
        }


        return myView;
    }




    /*@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }*/
}