package com.example.bjorn.shop;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class Explicit extends AppCompatActivity {

    Button back;
    Button visit;
    EditText url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit);

        url = (EditText)findViewById(R.id.url);
        visit = (Button)findViewById(R.id.visit);
        back = (Button)findViewById(R.id.back);

        visit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredURL = "http://" + url.getText().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(enteredURL));
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Explicit.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
