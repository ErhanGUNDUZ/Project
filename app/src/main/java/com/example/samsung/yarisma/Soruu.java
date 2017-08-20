package com.example.samsung.yarisma;

/**
 * Created by Samsung on 4.5.2016.
 */
public class Soruu {

    private int SoruNo ;
    private String Soru;
    private  int SoruZorluk;
    private  String Secenek1;
    private  String Secenek2;
    private  String Secenek3;
    private  String Secenek4;
    private int Cevap ;

    public Soruu() {
      SoruNo= 0;
        Soru = "";
       SoruZorluk= 0;
       Secenek1 = "";
        Secenek2 = "";
        Secenek3= "";
        Secenek4 = "";

        Cevap = 0;

    }

    public Soruu(String soru,  int soruZorluk, String secenek1, String secenek2, String secenek3, String secenek4, int cevap ) {
        Cevap = cevap;
        Secenek4 = secenek4;
        Secenek3 = secenek3;
        Secenek2 = secenek2;
        Secenek1 = secenek1;
        SoruZorluk = soruZorluk;
        Soru = soru;
    }

    public int getCevap() {
        return Cevap;
    }

    public void setCevap(int cevap) {
        Cevap = cevap;
    }

    public String getSecenek4() {
        return Secenek4;
    }

    public void setSecenek4(String secenek4) {
        Secenek4 = secenek4;
    }

    public String getSecenek2() {
        return Secenek2;
    }

    public void setSecenek2(String secenek2) {
        Secenek2 = secenek2;
    }

    public String getSecenek3() {
        return Secenek3;
    }

    public void setSecenek3(String secenek3) {
        Secenek3 = secenek3;
    }

    public String getSecenek1() {
        return Secenek1;
    }

    public void setSecenek1(String secenek1) {
        Secenek1 = secenek1;
    }

    public int getSoruZorluk() {
        return SoruZorluk;
    }

    public void setSoruZorluk(int soruZorluk) {
        SoruZorluk = soruZorluk;
    }

    public String getSoru() {
        return Soru;
    }

    public void setSoru(String soru) {
        Soru = soru;
    }

    public int getSoruNo() {
        return SoruNo;
    }

    public void setSoruNo(int soruNo) {
        SoruNo = soruNo;
    }
}
