package com.movealonging.aidemographicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Act_MainMenu extends AppCompatActivity {

    Button btn_statistics, btn_maps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_main_menu);
        initUi();


    }







    public void initUi(){
        btn_maps = findViewById(R.id.btn_Maps);
        btn_statistics = findViewById(R.id.btn_Stadistics);
    }

    public void changeMaps(View view){
        Intent intent = new Intent(this, Act_MapTemp.class);
        startActivity(intent);
    }

    public void changeStatistics(View view){
        Intent intent = new Intent(this, Act_RawDataTemp.class);
        startActivity(intent);
    }
}