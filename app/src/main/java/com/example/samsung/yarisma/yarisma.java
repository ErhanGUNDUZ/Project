package com.example.samsung.yarisma;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.text.InputType;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class yarisma extends Activity implements View.OnClickListener {
    Button ans,sc1,sc2,sc3,sc4,jkr_yzdlli,jkr_syrc,jkr_tel,jkr_cft;
    int dgrcvp=0;
    int ynlcvp=0;
    boolean ilkacilis=true;
    TextView sr;
    int ses,titresim;
    String RUMUZ="";
    int ciftcevap=0;
    boolean bitir=false,suredoldumu=false;
    String[] sorugelenler;
    MediaPlayer mp;
    ProgressBar progress;
    CountDownTimer mCountDownTimer;

    int secilensk;
    DbHelper db = new DbHelper(yarisma.this);
    int i = 0;
    Yarisanlar yars_puan=new Yarisanlar();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yarisma);


        ses=getIntent().getExtras().getInt("ses");
        titresim=getIntent().getExtras().getInt("titresim");


        progress = (ProgressBar) findViewById(R.id.pb);

        final ObjectAnimator animation = ObjectAnimator.ofInt(progress, "progress", 0, 100);
        animation.setDuration(150000);
        animation.setInterpolator(new DecelerateInterpolator());
        animation.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) { }

            @Override
            public void onAnimationEnd(Animator animator) {

                animator.cancel();
                suredoldubitir();
            }

            @Override
            public void onAnimationCancel(Animator animator) { }

            @Override
            public void onAnimationRepeat(Animator animator) { }
        });

        if(ses==1)
        {
        mp=MediaPlayer.create(yarisma.this, R.raw.mzk);
        mp.start();
        }




        sr= (TextView) findViewById(R.id.soru);
        sc1= (Button) findViewById(R.id.a);
        sc2= (Button) findViewById(R.id.b);
        sc3= (Button) findViewById(R.id.c);
        sc4= (Button) findViewById(R.id.d);
        ans= (Button) findViewById(R.id.ans);
        jkr_yzdlli= (Button) findViewById(R.id.jk1);
        jkr_syrc= (Button) findViewById(R.id.jk3);
        jkr_tel= (Button) findViewById(R.id.jk2);
        jkr_cft= (Button) findViewById(R.id.jk4);
        jkr_cft.setEnabled(false);


        sifirla();
        sorugelenler = db.sorucek();
        sr.setText(sorugelenler[1]);
        sc1.setText(sorugelenler[2]);
        sc2.setText(sorugelenler[3]);
        sc3.setText(sorugelenler[4]);
        sc4.setText(sorugelenler[5]);

        sc1.setOnClickListener(this);
        sc2.setOnClickListener(this);
        sc3.setOnClickListener(this);
        sc4.setOnClickListener(this);


        AlertDialog.Builder rmz_al=new AlertDialog.Builder(yarisma.this);
        rmz_al.setCancelable(false);
        rmz_al.setTitle("Merhaba!");
        rmz_al.setMessage("Yarışmamıza Hoşgeldiniz.");

        final EditText input = new EditText(this);
        input.setText("Lütfen rumuz giriniz..");
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        rmz_al.setView(input);

        input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ilkacilis)
                input.setText("");
                ilkacilis=false;
            }
        });

        rmz_al.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                animation.start();
                RUMUZ = input.getText().toString();
            }
        });

        rmz_al.create().show();

        ans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii = new Intent(yarisma.this, MainActivity.class);
                ii.putExtra("ses",ses);
                ii.putExtra("titresim",titresim);
                startActivity(ii);
            }
        });




        jkr_yzdlli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                jkr_yzdlli.setEnabled(false);
                jkr_yzdlli.setBackgroundResource(R.drawable.jk1kullanildi);

                int c=0,i=0;

                while(c<=2)
                {
                    if(String.valueOf(i).equals(sorugelenler[6]))
                    {
                        ;
                    }
                    else
                    {
                        switch (i) {
                            case 1:
                                sc1.setEnabled(false);
                                break;
                            case 2:
                                sc2.setEnabled(false);
                                break;
                            case 3:
                                sc3.setEnabled(false);
                                break;
                            case 4:
                                sc4.setEnabled(false);
                                break;
                        }
                        c++;
                    }
                    i++;
                }



            }
        });



        jkr_tel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                jkr_tel.setEnabled(false);
                jkr_tel.setBackgroundResource(R.drawable.jk2kullanildi);

                if(db.getbulunulansoru()>=0 && db.getbulunulansoru()<=5)
                {
                    Toast.makeText(yarisma.this, "Sorulacak kişi arandı.", Toast.LENGTH_SHORT).show();
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    AlertDialog.Builder cvpp  = new AlertDialog.Builder(yarisma.this, R.style.Base_Theme_AppCompat_Dialog_MinWidth);
                    cvpp.setTitle("Aranılan kişi şunu söyledi:");
                    String vv=null;
                    switch (db.getdogrucevap())
                    {
                        case 1: vv=sc1.getText().toString(); break;
                        case 2: vv=sc2.getText().toString(); break;
                        case 3: vv=sc3.getText().toString(); break;
                        case 4: vv=sc4.getText().toString(); break;
                    }
                    cvpp.setMessage("Sorunun cevabı: "+vv);

                    cvpp.setPositiveButton("Anladım",null);
                    cvpp.create().show();
                }

                else if(db.getbulunulansoru()>=6 && db.getbulunulansoru()<=10)
                {
                    Toast.makeText(yarisma.this, "Sorulacak kişi arandı.", Toast.LENGTH_SHORT).show();
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    AlertDialog.Builder cvpp  = new AlertDialog.Builder(yarisma.this, R.style.Base_Theme_AppCompat_Dialog_MinWidth);
                    cvpp.setTitle("Aranılan kişi şunu söyledi:");
                    String vv=null;
                    switch (db.getdogrucevap())
                    {
                        case 1: vv=sc1.getText().toString(); break;
                        case 2: vv=sc2.getText().toString(); break;
                        case 3: vv=sc3.getText().toString(); break;
                        case 4: vv=sc4.getText().toString(); break;
                    }
                    cvpp.setMessage("Sorunun cevabı muhtemelen " + vv + " diye düşünüyorum.");

                    cvpp.setPositiveButton("Anladım",null);
                    cvpp.create().show();
                }

                else if(db.getbulunulansoru()>=11 && db.getbulunulansoru()<=15)
                {
                    Toast.makeText(yarisma.this, "Sorulacak kişi arandı.", Toast.LENGTH_SHORT).show();
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    AlertDialog.Builder cvpp  = new AlertDialog.Builder(yarisma.this, R.style.Base_Theme_AppCompat_Dialog_MinWidth);
                    cvpp.setTitle("Aranılan kişi şunu söyledi:");
                    String vv=null;
                    Random rrr=new Random();
                    int j=rrr.nextInt(4)+1;
                    switch (j)
                    {
                        case 1: vv=sc1.getText().toString(); break;
                        case 2: vv=sc2.getText().toString(); break;
                        case 3: vv=sc3.getText().toString(); break;
                        case 4: vv=sc4.getText().toString(); break;
                    }
                    cvpp.setMessage("Üzgünüm. Hiçbir fikrim yok lâkin ben olsam "+vv+" cevabını verirdim.");

                    cvpp.setPositiveButton("Anladım",null);

                    cvpp.create().show();
                }
            }
        });


        jkr_syrc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                jkr_syrc.setEnabled(false);
                jkr_syrc.setBackgroundResource(R.drawable.jk3kullanildi);
                Random seyirci=new Random();

                Integer[] lll=new Integer[3];



                if(db.getbulunulansoru()>=0 && db.getbulunulansoru()<=5)
                {
                    Toast.makeText(yarisma.this, "Seyirciye soruldu.", Toast.LENGTH_SHORT).show();
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    int t=0;

                    while(true)
                    {

                        while(t<3)
                        {
                            lll[t] = seyirci.nextInt(15);
                            t++;
                        }

                        if(t==3 && (lll[0]+lll[1]+lll[2]!=15))
                        {
                            t=0;
                            continue;
                        }

                        else break;
                    }

                    AlertDialog.Builder cvpp  = new AlertDialog.Builder(yarisma.this, R.style.Base_Theme_AppCompat_Dialog_MinWidth);
                    cvpp.setTitle("Seyircilerin cevabı:");

                    switch (db.getdogrucevap())
                    {
                        case 1:
                            cvpp.setMessage(" "+sc1.getText()+": %85"+"\n "+sc2.getText()+": %"+lll[0].toString()+"\n "+sc3.getText()+": %"+lll[1].toString()+"\n "+sc4.getText()+": %"+lll[2].toString());
                            break;
                        case 2:
                            cvpp.setMessage(" "+sc1.getText()+": %"+lll[0].toString()+"\n "+sc2.getText()+": %85"+"\n "+sc3.getText()+": %"+lll[1].toString()+"\n "+sc4.getText()+": %"+lll[2].toString());
                            break;
                        case 3:
                            cvpp.setMessage(" "+sc1.getText()+": %"+lll[0].toString()+"\n "+sc2.getText()+": %"+lll[1].toString()+"\n "+sc3.getText()+": %85"+"\n "+sc4.getText()+": %"+lll[2].toString());
                            break;
                        case 4:
                            cvpp.setMessage(" "+sc1.getText()+": %"+lll[0].toString()+"\n "+sc2.getText()+": %"+lll[1].toString()+"\n "+sc3.getText()+": %"+lll[2].toString()+"\n "+sc4.getText()+": %85");
                            break;
                    }

                    cvpp.setPositiveButton("Anladım",null);

                    cvpp.create().show();

                }

                else if(db.getbulunulansoru()>=6 && db.getbulunulansoru()<=10)
                {
                    Toast.makeText(yarisma.this, "Aranıyor...", Toast.LENGTH_SHORT).show();
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    int t=0;

                    while(true)
                    {

                        while(t<3)
                        {
                            lll[t] = seyirci.nextInt(35);
                            t++;
                        }

                        if(t==3 && (lll[0]+lll[1]+lll[2]!=35))
                        {
                            t=0;
                            continue;
                        }

                        else break;
                    }

                    AlertDialog.Builder cvpp  = new AlertDialog.Builder(yarisma.this, R.style.Base_Theme_AppCompat_Dialog_MinWidth);
                    cvpp.setTitle("Seyircilerin cevabı:");

                    switch (db.getdogrucevap())
                    {
                        case 1:
                            cvpp.setMessage(" "+sc1.getText()+": %65"+"\n "+sc2.getText()+": %"+lll[0].toString()+"\n "+sc3.getText()+": %"+lll[1].toString()+"\n "+sc4.getText()+": %"+lll[2].toString());
                            break;
                        case 2:
                            cvpp.setMessage(" "+sc1.getText()+": %"+lll[0].toString()+"\n "+sc2.getText()+": %65"+"\n "+sc3.getText()+": %"+lll[1].toString()+"\n "+sc4.getText()+": %"+lll[2].toString());
                            break;
                        case 3:
                            cvpp.setMessage(" "+sc1.getText()+": %"+lll[0].toString()+"\n "+sc2.getText()+": %"+lll[1].toString()+"\n "+sc3.getText()+": %65"+"\n "+sc4.getText()+": %"+lll[2].toString());
                            break;
                        case 4:
                            cvpp.setMessage(" "+sc1.getText()+": %"+lll[0].toString()+"\n "+sc2.getText()+": %"+lll[1].toString()+"\n "+sc3.getText()+": %"+lll[2].toString()+"\n "+sc4.getText()+": %65");
                            break;
                    }

                    cvpp.setPositiveButton("Anladım",null);

                    cvpp.create().show();

                }

                else if(db.getbulunulansoru()>=11 && db.getbulunulansoru()<=15)
                {
                    Toast.makeText(yarisma.this, "Aranıyor...", Toast.LENGTH_SHORT).show();
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                    int t=0;

                    while(true)
                    {

                        while(t<3)
                        {
                            lll[t] = seyirci.nextInt(60);
                            t++;
                        }

                        if(t==3 && (lll[0]+lll[1]+lll[2]!=60))
                        {
                            t=0;
                            continue;
                        }

                        else break;
                    }

                    AlertDialog.Builder cvpp  = new AlertDialog.Builder(yarisma.this, R.style.Base_Theme_AppCompat_Dialog_MinWidth);
                    cvpp.setTitle("Seyircilerin cevabı:");

                    switch (db.getdogrucevap())
                    {
                        case 1:
                            cvpp.setMessage(" "+sc1.getText()+": %40"+"\n "+sc2.getText()+": %"+lll[0].toString()+"\n "+sc3.getText()+": %"+lll[1].toString()+"\n "+sc4.getText()+": %"+lll[2].toString());
                            break;
                        case 2:
                            cvpp.setMessage(" "+sc1.getText()+": %"+lll[0].toString()+"\n "+sc2.getText()+": %40"+"\n "+sc3.getText()+": %"+lll[1].toString()+"\n "+sc4.getText()+": %"+lll[2].toString());
                            break;
                        case 3:
                            cvpp.setMessage(" "+sc1.getText()+": %"+lll[0].toString()+"\n "+sc2.getText()+": %"+lll[1].toString()+"\n "+sc3.getText()+": %40"+"\n "+sc4.getText()+": %"+lll[2].toString());
                            break;
                        case 4:
                            cvpp.setMessage(" "+sc1.getText()+": %"+lll[0].toString()+"\n "+sc2.getText()+": %"+lll[1].toString()+"\n "+sc3.getText()+": %"+lll[2].toString()+"\n "+sc4.getText()+": %40");
                            break;
                    }

                    cvpp.setPositiveButton("Anladım",null);

                    cvpp.create().show();

                }

            }
        });


        jkr_cft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(yarisma.this,"Çift cevap jokeri kullanılıyor..",Toast.LENGTH_LONG).show();
                jkr_cft.setEnabled(false);
                jkr_cft.setBackgroundResource(R.drawable.jk4kullanildi);
                ciftcevap=1;

            }
        });

    }

    public void suredoldubitir()
    {

        Vibrator mVibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this, R.style.Base_Theme_AppCompat_Light_Dialog);

            if (titresim == 1) {
                mVibrator.vibrate(500);
            }

            dlgAlert.setTitle("Süre doldu!. Yarışma sona erdi!");
            dlgAlert.setMessage("15 sorudan " + db.getdogrucevaplanansorusayisi() + " soru doğru cevaplandı.");

            Yarisanlar yars_puan = new Yarisanlar();
            yars_puan.setYRumuz(RUMUZ);
            yars_puan.setYPuan(db.getbulunulansoru()-1);
            db.SkorKaydet(yars_puan.getYRumuz(), yars_puan.getYPuan());

            dlgAlert.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    Intent git = new Intent(yarisma.this, Skorgoster.class);
                    git.putExtra("ses", ses);
                    git.putExtra("titresim", titresim);
                    startActivity(git);

                }
            });

        try {
            dlgAlert.create().show();
        } catch (Exception e) {
            ;
        }
    }




    void sifirla()
    {
        sc1.setEnabled(true);
        sc2.setEnabled(true);
        sc3.setEnabled(true);
        sc4.setEnabled(true);
        sc1.setBackgroundColor(Color.GRAY);
        sc2.setBackgroundColor(Color.GRAY);
        sc3.setBackgroundColor(Color.GRAY);
        sc4.setBackgroundColor(Color.GRAY);
        bitir=false;
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


    @Override
    protected void onResume()
    {
        super.onResume();

    }

    @Override
    public void onClick(View v) {


        Vibrator mVibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this, R.style.Base_Theme_AppCompat_Light_Dialog);

        sifirla();

        switch (v.getId())
        {
            case R.id.a:

                if(sorugelenler[6].equals("1"))
                {
                    sc1.setBackgroundColor(Color.GREEN);
                    dgrcvp++;


                    if(db.getbulunulansoru()!=16)
                    {
                        dlgAlert.setMessage(db.getbulunulansoru() + ". soruya geçiliyor.");
                        if (db.getbulunulansoru() == 15) {
                            dlgAlert.setMessage(db.getbulunulansoru() + ". soruya geçiliyor. Final sorusu.");
                        }
                    }
                    else
                    {
                        dlgAlert.setMessage("Tebrikler! Tüm soruları doğru yanıtlayarak yarışmayı tamamladınız.");


                        Yarisanlar yars_puan=new Yarisanlar();
                        yars_puan.setYRumuz(RUMUZ);
                        yars_puan.setYPuan(db.getbulunulansoru()-1);
                        db.SkorKaydet(yars_puan.getYRumuz(),yars_puan.getYPuan());

                    }
                    dlgAlert.setTitle("Doğru cevap");

                }
                else
                {
                    sc1.setBackgroundColor(Color.RED);

                    if(ciftcevap!=1)
                    {
                        switch (sorugelenler[6]) {
                            case "2":
                                sc2.setBackgroundColor(Color.GREEN);
                                break;
                            case "3":
                                sc3.setBackgroundColor(Color.GREEN);
                                break;
                            case "4":
                                sc4.setBackgroundColor(Color.GREEN);
                                break;
                        }
                        ynlcvp++;
                        if (titresim == 1) {
                            mVibrator.vibrate(500);
                        }
                        dlgAlert.setTitle("Yanlış cevap. Yarışma sona erdi!");
                        dlgAlert.setMessage("15 sorudan " + db.getdogrucevaplanansorusayisi() + " soru doğru cevaplandı.");

                        Yarisanlar yars_puan=new Yarisanlar();
                        yars_puan.setYRumuz(RUMUZ);
                        yars_puan.setYPuan(db.getbulunulansoru()-1);
                        db.SkorKaydet(yars_puan.getYRumuz(), yars_puan.getYPuan());

                        bitir = true;

                    }
                    else
                    {
                        if (titresim == 1) {
                            mVibrator.vibrate(500);
                        }
                        Toast.makeText(yarisma.this,"Lütfen diğer cevabınızı veriniz.", Toast.LENGTH_LONG).show();

                    }
                }
                secilensk=1;
                break;
            case R.id.b:
                if(sorugelenler[6].equals("2"))
                {
                    sc2.setBackgroundColor(Color.GREEN);
                    dgrcvp++;


                    if(db.getbulunulansoru()!=16)
                    {
                        dlgAlert.setMessage(db.getbulunulansoru() + ". soruya geçiliyor.");
                        if (db.getbulunulansoru() == 15) {
                            dlgAlert.setMessage(db.getbulunulansoru() + ". soruya geçiliyor. Final sorusu.");
                        }
                    }
                    else
                    {
                        dlgAlert.setMessage("Tebrikler! Tüm soruları doğru yanıtlayarak yarışmayı tamamladınız.");


                        Yarisanlar yars_puan=new Yarisanlar();
                        yars_puan.setYRumuz(RUMUZ);
                        yars_puan.setYPuan(db.getbulunulansoru()-1);
                        db.SkorKaydet(yars_puan.getYRumuz(),yars_puan.getYPuan());

                    }
                    dlgAlert.setTitle("Doğru cevap");

                }
                else {
                    sc2.setBackgroundColor(Color.RED);
                    if (ciftcevap != 1) {
                        switch (sorugelenler[6]) {
                            case "1":
                                sc1.setBackgroundColor(Color.GREEN);
                                break;
                            case "3":
                                sc3.setBackgroundColor(Color.GREEN);
                                break;
                            case "4":
                                sc4.setBackgroundColor(Color.GREEN);
                                break;
                        }
                        ynlcvp++;

                        if (titresim == 1) {
                            mVibrator.vibrate(500);
                        }
                        dlgAlert.setMessage("Yanlış cevap. Yarışma sona erdi!");
                        dlgAlert.setTitle("15 sorudan " + db.getdogrucevaplanansorusayisi() + " soru doğru cevaplandı.");


                        Yarisanlar yars_puan=new Yarisanlar();
                        yars_puan.setYRumuz(RUMUZ);
                        yars_puan.setYPuan(db.getbulunulansoru()-1);
                        db.SkorKaydet(yars_puan.getYRumuz(), yars_puan.getYPuan());

                        bitir = true;
                    }
                }
                secilensk=2;
                break;
            case R.id.c:
                if(sorugelenler[6].equals("3"))
                {
                    sc3.setBackgroundColor(Color.GREEN);
                    dgrcvp++;


                    if(db.getbulunulansoru()!=16)
                    {
                        dlgAlert.setMessage(db.getbulunulansoru()+". soruya geçiliyor.");
                    if(db.getbulunulansoru()==15)
                    {
                        dlgAlert.setMessage(db.getbulunulansoru()+". soruya geçiliyor. Final sorusu.");
                    }
                    }
                    else
                    {
                        dlgAlert.setMessage("Tebrikler! Tüm soruları doğru yanıtlayarak yarışmayı tamamladınız.");

                        Yarisanlar yars_puan=new Yarisanlar();
                        yars_puan.setYRumuz(RUMUZ);
                        yars_puan.setYPuan(db.getbulunulansoru()-1);
                        db.SkorKaydet(yars_puan.getYRumuz(),yars_puan.getYPuan());

                    }
                    dlgAlert.setTitle("Doğru cevap");


                }
                else
                {
                    sc3.setBackgroundColor(Color.RED);
                    if(ciftcevap!=1)
                    {
                    switch (sorugelenler[6])
                    {
                        case "2": sc2.setBackgroundColor(Color.GREEN); break;
                        case "1": sc1.setBackgroundColor(Color.GREEN); break;
                        case "4": sc4.setBackgroundColor(Color.GREEN); break;
                    }
                    ynlcvp++;

                    if(titresim==1)
                    {
                        mVibrator.vibrate(500);
                    }
                    dlgAlert.setTitle("Yanlış cevap. Yarışma sona erdi!");
                    dlgAlert.setMessage("15 sorudan " + db.getdogrucevaplanansorusayisi() + " soru doğru cevaplandı.");

                    Yarisanlar yars_puan=new Yarisanlar();
                    yars_puan.setYRumuz(RUMUZ);
                    yars_puan.setYPuan(db.getbulunulansoru()-1);
                    db.SkorKaydet(yars_puan.getYRumuz(), yars_puan.getYPuan());


                    bitir=true;

                }
                    else
                    {
                        if (titresim == 1) {
                            mVibrator.vibrate(500);
                        }
                        Toast.makeText(yarisma.this,"Lütfen diğer cevabınızı veriniz.", Toast.LENGTH_LONG).show();

                    }
                }
                secilensk=3;
                break;
            case R.id.d:
                if(sorugelenler[6].equals("4"))
                {
                    sc4.setBackgroundColor(Color.GREEN);
                    dgrcvp++;

                    if(db.getbulunulansoru()!=16)
                    {
                    dlgAlert.setMessage(db.getbulunulansoru()+". soruya geçiliyor.");
                    if(db.getbulunulansoru()==15)
                    {
                        dlgAlert.setMessage(db.getbulunulansoru()+". soruya geçiliyor. Final sorusu.");
                    }
                    }
                    else
                    {
                        dlgAlert.setMessage("Tebrikler! Tüm soruları doğru yanıtlayarak yarışmayı tamamladınız.");

                        Yarisanlar yars_puan=new Yarisanlar();
                        yars_puan.setYRumuz(RUMUZ);
                        yars_puan.setYPuan(db.getbulunulansoru()-1);
                        db.SkorKaydet(yars_puan.getYRumuz(),yars_puan.getYPuan());

                    }
                    dlgAlert.setTitle("Doğru cevap");


                }
               else {
                    sc4.setBackgroundColor(Color.RED);
                    if (ciftcevap != 1) {
                        switch (sorugelenler[6]) {
                            case "2":
                                sc2.setBackgroundColor(Color.GREEN);
                                break;
                            case "3":
                                sc3.setBackgroundColor(Color.GREEN);
                                break;
                            case "1":
                                sc1.setBackgroundColor(Color.GREEN);
                                break;
                        }
                        ynlcvp++;

                        if (titresim == 1) {
                            mVibrator.vibrate(500);
                        }
                        dlgAlert.setTitle("Yanlış cevap. Yarışma sona erdi!");
                        dlgAlert.setMessage("15 sorudan " + db.getdogrucevaplanansorusayisi() + " soru doğru cevaplandı.");

                        Yarisanlar yars_puan=new Yarisanlar();
                        yars_puan.setYRumuz(RUMUZ);
                        yars_puan.setYPuan(db.getbulunulansoru()-1);
                        db.SkorKaydet(yars_puan.getYRumuz(),yars_puan.getYPuan());


                        bitir = true;
                    }
                    else
                    {
                        if (titresim == 1) {
                            mVibrator.vibrate(500);
                        }
                        Toast.makeText(yarisma.this,"Lütfen diğer cevabınızı veriniz.", Toast.LENGTH_LONG).show();

                    }
                }
                secilensk=4;
                break;
        }


        dlgAlert.setCancelable(false);

        if(ciftcevap==1)
        {
            if(secilensk!=Integer.parseInt(sorugelenler[6]))
            {
                dlgAlert.setTitle("Yanlış cevap.");
                dlgAlert.setMessage("Lütfen diğer cevabınızı veriniz.");
            }
        }

        dlgAlert.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                if (db.getbulunulansoru() <= 15 && bitir != true && secilensk == Integer.parseInt(sorugelenler[6])) {
                    sifirla();
                    sorugelenler = db.sorucek();
                    sr.setText(sorugelenler[1]);
                    sc1.setText(sorugelenler[2]);
                    sc2.setText(sorugelenler[3]);
                    sc3.setText(sorugelenler[4]);
                    sc4.setText(sorugelenler[5]);
                    if (db.getbulunulansoru() == 7) {
                        jkr_cft.setEnabled(true);
                    }


                } else{

                    if(ciftcevap!=1)
                    {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        Intent git = new Intent(yarisma.this, Skorgoster.class);
                        git.putExtra("ses", ses);
                        git.putExtra("titresim", titresim);
                        startActivity(git);
                    }
                }


                ciftcevap=0;
            }
        });



        dlgAlert.create().show();
    }
}

