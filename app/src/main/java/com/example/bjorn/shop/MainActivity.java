package com.example.bjorn.shop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button browse = (Button)findViewById(R.id.browse);
        Button afr = (Button)findViewById(R.id.afr);
        Button e_intent = (Button)findViewById(R.id.explicit);
        Button menu = (Button)findViewById(R.id.option);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OptionMenu.class);
                startActivity(intent);
            }
        });

        browse.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, browse.class);
                startActivity(intent);
            }
        });

        afr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AFR.class);
                startActivity(intent);
            }
        });

        e_intent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Explicit.class);
                startActivity(intent);
            }
        });
    }

}