package com.example.samsung.yarisma;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Samsung on 22.4.2016.
 */
public class hakkinda extends Activity {
    Button ans;
    MediaPlayer mp;
    int ses,titresim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hakkinda);

        ses=getIntent().getExtras().getInt("ses");
        titresim=getIntent().getExtras().getInt("titresim");

        if(ses==1)
        {
            mp=MediaPlayer.create(hakkinda.this, R.raw.mzk);
            mp.start();
        }
        ans= (Button) findViewById(R.id.ans);
        ans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii = new Intent(hakkinda.this, MainActivity.class);
                ii.putExtra("ses",ses);
                ii.putExtra("titresim",titresim);
                startActivity(ii);

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
