package com.example.dula;

import static androidx.core.app.NotificationCompat.PRIORITY_HIGH;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class MainActivity2 extends AppCompatActivity {
    private Button button, button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //getSupportActionBar().hide();
        //getSupportActionBar().setDisplayShowTitleEnabled(true);

        Toolbar toolbar3 = findViewById(R.id.toolbar3);
        toolbar3.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);

        Intent intent1 = getIntent();
        String toolbar_title = intent1.getStringExtra("toolbar_title");


        Intent intent2 = getIntent();
        int lesson_id = intent2.getIntExtra("lesson_id", -1);
        String Category_name = intent2.getStringExtra("Category_name");


        setSupportActionBar(toolbar3);
        getSupportActionBar().setTitle(toolbar_title);

        toolbar3.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity2.this.onBackPressed();
            }
        });

        button = findViewById(R.id.button_lesfun1);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity3.class);
            intent.putExtra("lesson_id", lesson_id);
            intent.putExtra("Category_name", Category_name);
            startActivity(intent);
        });

        button2 = findViewById(R.id.button_lesfun2);
        button2.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity4.class);
            intent.putExtra("lesson_id", lesson_id);
            intent.putExtra("Category_name", Category_name);
            startActivity(intent);
        });

        button = findViewById(R.id.button_lesfun3);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity5.class);
            intent.putExtra("lesson_id", lesson_id);
            intent.putExtra("Category_name", Category_name);
            startActivity(intent);
        });

        button = findViewById(R.id.button_lesfun4);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity6.class);
            intent.putExtra("lesson_id", lesson_id);
            intent.putExtra("Category_name", Category_name);
            startActivity(intent);
        });

        button = findViewById(R.id.button_lesfun5);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity7.class);
            intent.putExtra("lesson_id", lesson_id);
            intent.putExtra("Category_name", Category_name);
            startActivity(intent);
        });

        button = findViewById(R.id.button_lesfun6);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity8.class);
            intent.putExtra("lesson_id", lesson_id);
            intent.putExtra("Category_name", Category_name);
            startActivity(intent);
        });
    }
}


/*
package com.example.dula;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity2 extends AppCompatActivity {
    private Button button, button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        getSupportActionBar().hide();

        getSupportActionBar().setDisplayShowTitleEnabled(true);

        Toolbar toolbar3 = findViewById(R.id.toolbar3);
        toolbar3.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        toolbar3.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity2.this.onBackPressed();
            }
        });

        button = findViewById(R.id.button_lesfun1);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity3.class);
            startActivity(intent);
        });

        button2 = findViewById(R.id.button_lesfun2);
        button2.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity4.class);
            startActivity(intent);
        });

        button = findViewById(R.id.button_lesfun3);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity5.class);
            startActivity(intent);
        });

        button = findViewById(R.id.button_lesfun4);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity6.class);
            startActivity(intent);
        });

        button = findViewById(R.id.button_lesfun5);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity7.class);
            startActivity(intent);
        });

        button = findViewById(R.id.button_lesfun6);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity8.class);
            startActivity(intent);
        });

    }
}
 */