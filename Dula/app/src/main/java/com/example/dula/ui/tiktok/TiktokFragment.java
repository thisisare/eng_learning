package com.example.dula.ui.tiktok;

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
import com.example.dula.R;
import com.example.dula.databinding.FragmentTiktokBinding;
import com.google.android.material.card.MaterialCardView;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class TiktokFragment extends Fragment {

    private FragmentTiktokBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_tiktok, container, false);

        /*//Button button = myView.findViewById(R.id.btik1);
        MaterialCardView button = (MaterialCardView) myView.findViewById(R.id.btik1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(getContext(), button);
                popupMenu.getMenuInflater().inflate(R.menu.popupmenu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId())
                        {
                            case R.id.yp1:
                                Toast.makeText(getContext(), "1YANDEX", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.yp2:
                                Toast.makeText(getContext(), "2YANDEX", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.yp3:
                                Toast.makeText(getContext(), "3YANDEX", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return true;
                    }
                });
                popupMenu.show();
            }
        });

        //Button button2 = myView.findViewById(R.id.btik2);
        MaterialCardView button2 = (MaterialCardView) myView.findViewById(R.id.btik2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(getContext(), button2);
                popupMenu.getMenuInflater().inflate(R.menu.popupmenu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId())
                        {
                            case R.id.sp1:
                                Toast.makeText(getContext(), "1SPOTIFY", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.sp2:
                                Toast.makeText(getContext(), "2SPOTIFY", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.sp3:
                                Toast.makeText(getContext(), "3SPOTIFY", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.sp4:
                                Toast.makeText(getContext(), "4SPOTIFY", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return true;
                    }
                });
                popupMenu.show();
            }
        });*/

        return myView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}