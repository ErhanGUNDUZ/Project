package com.example.samsung.yarisma;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp;
    int ses,titresim;
    Button basla,hakkinda,ayarlar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ses=getIntent().getExtras().getInt("ses");
        titresim=getIntent().getExtras().getInt("titresim");

        if(ses==1)
        {
            mp = MediaPlayer.create(MainActivity.this, R.raw.mzk);
            mp.start();
        }

       basla=(Button) findViewById(R.id.basla);
        basla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bsl=new Intent(MainActivity.this,yarisma.class);
                bsl.putExtra("ses",ses);
                bsl.putExtra("titresim",titresim);
                startActivity(bsl);

            }
        });
        hakkinda= (Button) findViewById(R.id.hakkinda);
        hakkinda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hkd=new Intent(MainActivity.this,hakkinda.class);
                hkd.putExtra("ses",ses);
                hkd.putExtra("titresim",titresim);
                startActivity(hkd);
            }
        });

        ayarlar=(Button) findViewById(R.id.ayarlar);

        ayarlar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ayr=new Intent(MainActivity.this,Ayarlar.class);
                ayr.putExtra("ses",ses);
                ayr.putExtra("titresim",titresim);
                startActivity(ayr);
            }
        });


    }

    @Override
     protected void onPause() {
        super.onPause();
        if(ses==1)
        {
            mp.release();
            finish();
        }

    }

}
