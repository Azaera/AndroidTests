package com.example.bjorn.shop;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static com.example.bjorn.shop.R.string;

public class browse extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);

        Button back = (Button)findViewById(R.id.back);

        Button longs = (Button) findViewById(R.id.longToast);
        Button shorts = (Button) findViewById(R.id.shortToast);
        Button long2 = (Button) findViewById(R.id.longToast2);
        Button short2 = (Button) findViewById(R.id.shortToast2);

        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(browse.this, MainActivity.class);
                startActivity(intent);
            }
        });

        longs.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Log.i("longs", "Testar");
                Toast.makeText(getApplicationContext(), "Long Toast, no String resource",Toast.LENGTH_LONG).show();
            }
        });

        long2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context c = browse.this;
                Toast.makeText(c, c.getResources().getString(R.string.longToast2), Toast.LENGTH_LONG).show();
            }
        } );

        shorts.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
               Toast.makeText(getApplicationContext(), "Short Toast, no String resource",Toast.LENGTH_SHORT).show();
            }
        });

        short2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context c = browse.this;
                Toast.makeText(c, c.getResources().getString(R.string.shortToast2), Toast.LENGTH_SHORT).show();
            }
        } );
    }
}
