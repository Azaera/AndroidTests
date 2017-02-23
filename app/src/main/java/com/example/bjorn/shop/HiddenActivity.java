package com.example.bjorn.shop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HiddenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hidden);

        final EditText editText1 = (EditText) findViewById(R.id.enterMessage);
        Button start = (Button) findViewById(R.id.pass);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editText1.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("MESSAGE", message);
                setResult(1, intent);
                finish();
            }
        });
    }
}
