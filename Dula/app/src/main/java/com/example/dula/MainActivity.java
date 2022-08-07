package com.example.dula;

import static androidx.core.app.NotificationCompat.PRIORITY_HIGH;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager.widget.ViewPager;

import com.example.dula.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    static AssetManager assetManager;
    int count = 0;
    private NotificationManager notificationManager;
    private static final int NOTIFY_ID = 1;
    private static final String CHANNEL_ID = "CHANNEL_ID";
    NotificationCompat.Builder notificationBuilder;
    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        tabLayout = findViewById(R.id.tablayout);

        viewPager = findViewById(R.id.viewpager_id);
        tabLayout.setupWithViewPager(viewPager);

        setSupportActionBar(binding.appBarMain.toolbar);
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;

        mAppBarConfiguration = new AppBarConfiguration.Builder(R.id.nav_lessons, R.id.nav_useful, R.id.nav_repeat, R.id.nav_zoi, R.id.nav_podcasts, R.id.nav_songs, R.id.nav_tiktok, R.id.nav_telegram, R.id.nav_feedback).setOpenableLayout(drawer).build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        Button bKatyPerry = findViewById(R.id.bnotification);
        notificationManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);

        String toPath = "/data/data/" + getPackageName();
        copyAssetFolder("database", toPath);

        ArrayList<String> Words = new ArrayList();
        ArrayList<String> WordsEn = new ArrayList();
        dbHelper = new DBHelper(this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        Intent intent = getIntent();
        int lesson_id = intent.getIntExtra("lesson_id", -1);
        String Category_name = intent.getStringExtra("Category_name");

        Cursor cursor = null;
        cursor = database.query(dbHelper.TABLE_TOP1000, null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            int idIndex = cursor.getColumnIndex(dbHelper.KEY_ID);
            int ru_wordIndex = cursor.getColumnIndex(dbHelper.KEY_RU_WORD);
            int en_wordIndex = cursor.getColumnIndex(dbHelper.KEY_EN_WORD);
            int progressIndex = cursor.getColumnIndex(dbHelper.KEY_PROGRESS);

            for (int i = 0; i < 998; i++) {
                cursor.moveToPosition(i);
                WordsEn.add(cursor.getString(en_wordIndex));
                Words.add(cursor.getString(ru_wordIndex));
            }
        }
        cursor.close();

        bKatyPerry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(count == 90){
                    count--;
                }
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                PendingIntent nextPendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                PendingIntent previousPendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                Bitmap bitmap = BitmapFactory.decodeResource( getResources(), R.mipmap.ic_launcher);
                notificationBuilder =
                        new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                                .setAutoCancel(false)
                                .setSmallIcon(R.mipmap.ic_launcher_round)
                                .setWhen(System.currentTimeMillis())
                                .setContentIntent(pendingIntent)
                                .setOngoing(true)
                                .setContentTitle(WordsEn.get(count))
                                .setStyle(new NotificationCompat.BigTextStyle()
                                        .bigText(Words.get(count)))
                                .setPriority(PRIORITY_HIGH)
                                .addAction(R.mipmap.ic_launcher,"Предыдущий", previousPendingIntent)
                                .addAction(R.mipmap.ic_yandex,"Следующий", nextPendingIntent);

                createChannelIfNeeded(notificationManager);
                notificationManager.notify(NOTIFY_ID, notificationBuilder.build());

            }
        });
        bKatyPerry.callOnClick();

        for(int u = 0; u < Words.size() - 1;u++) {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    count++;
                    notificationBuilder.setContentTitle(WordsEn.get(count)).setContentText(Words.get(count));
                    notificationBuilder.setStyle(new NotificationCompat.BigTextStyle().bigText(Words.get(count)));
                    notificationManager.notify(NOTIFY_ID, notificationBuilder.build());
                }

            }, 1000);
        }
    }

    public static void createChannelIfNeeded(NotificationManager manager){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_ID, NotificationManager.IMPORTANCE_DEFAULT);
            manager.createNotificationChannel(notificationChannel);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();  // this exits the app.
    }

    private static boolean copyAssetFolder(String fromAssetPath, String toPath) {
        try {
            String[] files = assetManager.list(fromAssetPath);
            new File(toPath).mkdirs();
            boolean res = true;
            for (String file : files)
                if (file.contains("."))
                    res &= copyAsset(assetManager,
                            fromAssetPath + "/" + file,
                            toPath + "/" + file);
                else
                    res &= copyAssetFolder(fromAssetPath + "/" + file,
                            toPath + "/" + file);
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean copyAsset(AssetManager assetManager,
                                     String fromAssetPath, String toPath) {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = assetManager.open(fromAssetPath);
            new File(toPath).createNewFile();
            out = new FileOutputStream(toPath);
            copyFile(in, out);
            in.close();
            in = null;
            out.flush();
            out.close();
            out = null;
            return true;
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while((read = in.read(buffer)) != -1){
            out.write(buffer, 0, read);
        }
    }
}