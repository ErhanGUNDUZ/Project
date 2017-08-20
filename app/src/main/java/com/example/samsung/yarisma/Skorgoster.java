package com.example.samsung.yarisma;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class Skorgoster extends AppCompatActivity {

    int ses,titresim;
    ListView skrlar;
    Button ans;
    DbHelper dbHelper=new DbHelper(Skorgoster.this);
    String rumuzlar[];
    String dereceler[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skorgoster);



        ses=getIntent().getExtras().getInt("ses");
        titresim=getIntent().getExtras().getInt("titresim");
        ans= (Button) findViewById(R.id.anasayfa);
        skrlar= (ListView) findViewById(R.id.skorlar);

        ArrayList<HashMap<String, String>> yrs=null;
        yrs=dbHelper.getSkorlar();

        rumuzlar = new String[yrs.size()];
        dereceler = new String[yrs.size()];

        for(int i=0;i<yrs.size();i++)
        {
            rumuzlar[i] = yrs.get(i).get("YRumuz");
        }

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, rumuzlar);

        skrlar.setAdapter(adapter);

        ans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii = new Intent(Skorgoster.this, MainActivity.class);
                ii.putExtra("ses", ses);
                ii.putExtra("titresim", titresim);
                startActivity(ii);
            }
        });



    }
}
