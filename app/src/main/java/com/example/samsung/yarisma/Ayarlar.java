package com.example.samsung.yarisma;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

/**
 * Created by Samsung on 19.5.2016.
 */
public class Ayarlar extends Activity {

    Switch sw1,sw2;
    int ses,titresim;
    Button ans;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayarlar);


        ses=getIntent().getExtras().getInt("ses");
        titresim=getIntent().getExtras().getInt("titresim");


        ans= (Button) findViewById(R.id.ans);
        sw1 = (Switch) findViewById(R.id.sw1);
        sw2 = (Switch) findViewById(R.id.sw2);


        if (ses==1)
        {
          sw1.setChecked(true);
        }
       else sw1.setChecked(false);

        if(titresim==1)
        {
            sw2.setChecked(true);
        }
       else sw2.setChecked(false);


        sw1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked)
                ses=1;
                else ses=0;

            }
        });
        sw2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked)
                    titresim=1;
                else titresim=0;
            }
        });

        ans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent git = new Intent(Ayarlar.this, MainActivity.class);
                git.putExtra("ses",ses);
                git.putExtra("titresim",titresim);
                startActivity(git);
            }
        });
    }
}
