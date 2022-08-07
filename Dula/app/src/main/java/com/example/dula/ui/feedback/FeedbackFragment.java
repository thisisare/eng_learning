package com.example.dula.ui.feedback;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.dula.R;
import com.example.dula.databinding.FragmentFeedbackBinding;

import java.io.InputStream;

public class FeedbackFragment extends Fragment {

    FragmentFeedbackBinding binding;

    ActivityResultLauncher<String> launcher = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
        @Override
        public void onActivityResult(Uri result) {
            binding.selectedImageView.setImageURI(result);
        }
    });


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_feedback, container, false);

        //ImageView img777 = myView.findViewById(R.id.selectedImageView);
        //img777.setOnClickListener(v777 -> {
        //    launcher.launch("image/*");
        //});

        //binding.submitSuggestion.setOnClickListener(view -> launcher.launch("image/*"));

        EditText ed1 = myView.findViewById(R.id.editText12);
        String name = ed1.getText().toString();
        Button button = myView.findViewById(R.id.submitSuggestion);
        button.setOnClickListener(v1 -> {
            Toast.makeText(getActivity(), name, Toast.LENGTH_SHORT).show();
        });

        return myView;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //binding = null;
    }
}