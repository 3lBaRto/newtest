package com.newtest.newtest2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    EditText user;

    Button retur;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.TxtUser);
        retur = findViewById(R.id.BtnRetur);


        SharedPreferences preferences = getSharedPreferences("backd", Context.MODE_PRIVATE);
        user.setText(preferences.getString("name",""));
    }

    public void retur(View view)
    {
        SharedPreferences preferences = getSharedPreferences("backd", Context.MODE_PRIVATE);
        SharedPreferences.Editor objEditor = preferences.edit();
        objEditor.putString("name",user.getText().toString());
        objEditor.commit();
        finish();
    }

    public void onStart()
    {
        super.onStart();

        retur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retur(view);
            }
        });

    }
}