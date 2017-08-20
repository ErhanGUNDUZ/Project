package com.example.samsung.yarisma;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Giris extends Activity implements Runnable {

    Thread trd=new Thread(this);
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris);
        trd.start();
        mp=MediaPlayer.create(Giris.this, R.raw.grs);
        mp.start();

    }

    @Override
    public void run() {
        try {
            trd.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            Intent i=new Intent(Giris.this,MainActivity.class);
            i.putExtra("ses",1);
            i.putExtra("titresim",1);
            startActivity(i);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        mp.release();
        finish();
        }
    }
