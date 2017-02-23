package com.example.bjorn.shop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;


public class AFR extends AppCompatActivity {

    Button back;
    Button passMessage;
    TextView receivedMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afr);

        passMessage = (Button) findViewById(R.id.start);
        back = (Button) findViewById(R.id.back);
        receivedMessage = (TextView)findViewById(R.id.receivedMessage);

        passMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (AFR.this, HiddenActivity.class);
                startActivityForResult(intent, 1);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AFR.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            String message=data.getStringExtra("MESSAGE");
            receivedMessage.setText(message);
        }
    }
}
