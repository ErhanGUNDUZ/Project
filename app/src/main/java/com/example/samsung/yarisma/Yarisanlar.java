package com.example.samsung.yarisma;

/**
 * Created by Samsung on 20.5.2016.
 */
public class Yarisanlar {
    private int YNo;
    private String YRumuz;
    private int YPuan;

    public Yarisanlar(String YRumuz, int YPuan) {
        this.YRumuz = YRumuz;
        this.YPuan = YPuan;
    }

    public Yarisanlar(){


        YNo=0;
        YRumuz="";
        YPuan=0;
    }

    public int getYNo() {
        return YNo;
    }

    public void setYNo(int YNo) {
        this.YNo = YNo;
    }

    public String getYRumuz() {
        return YRumuz;
    }

    public void setYRumuz(String YRumuz) {
        this.YRumuz = YRumuz;
    }

    public int getYPuan() {
        return YPuan;
    }

    public void setYPuan(int YPuan) {
        this.YPuan = YPuan;
    }
}

