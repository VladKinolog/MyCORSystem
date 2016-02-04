package com.example.vladyslav_kovega.mycorsystem;

import android.util.Log;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by ingineer on 07.12.2015.
 */
public class WireCalculation {

    private double current;
    private double power;
    private double calcPower;
    private double calcCurrent;
    private double currentStarDeltaLine;
    private double currentStarDeltaShoulder;
    //double wireCrossSection;
    private String [] wireCrossSection = new String[14];
    private double [] fixCurrent = new double[14];
    public static final String TAG = "WireCalculation";

    public  WireCalculation (){
        this.wireCrossSection [0] = "0.5 mm2";
        this.wireCrossSection [1] = "0.75 mm2";
        this.wireCrossSection [2] = "1.5 mm2";
        this.wireCrossSection [3] = "2.5 mm2";
        this.wireCrossSection [4] = "4.0 mm2";
        this.wireCrossSection [5] = "6.0 mm2";
        this.wireCrossSection [6] = "10.0 mm2";
        this.wireCrossSection [7] = "16.0 mm2";
        this.wireCrossSection [8] = "25.0 mm2";
        this.wireCrossSection [9] = "35.0 mm2";
        this.wireCrossSection [10] = "50.0 mm2";
        this.wireCrossSection [11] = "70.0 mm2";
        this.wireCrossSection [12] = "95.0 mm2";
        this.wireCrossSection [13] = "120.0 mm2";

        this.fixCurrent [0] = 0.0;
        this.fixCurrent [1] = 5.3;
        this.fixCurrent [2] = 8.7;
        this.fixCurrent [3] = 14.0;
        this.fixCurrent [4] = 20.9;
        this.fixCurrent [5] = 27.8;
        this.fixCurrent [6] = 34.7;
        this.fixCurrent [7] = 43.4;
        this.fixCurrent [8] = 66.6;
        this.fixCurrent [9] = 83.3;
        this.fixCurrent [10] = 105.0;
        this.fixCurrent [11] = 139.0;
        this.fixCurrent [12] = 173.0;
        this.fixCurrent [13] = 212.0;
        Log.e(TAG, "Конструктор  WireCalculation () --> " + fixCurrent [13]);
    }

    public void setCurrent (double current){
        Log.e(TAG, "Метод setCurrent"+current);
        this.current = current;
        Log.e(TAG, "Метод setCurrent после присваивания"+this.current);
    }

    public double round (double round){
        double rou = new BigDecimal(round).setScale(2, RoundingMode.UP).doubleValue();;
        return rou;
    }

    public void setPower (double power){
        this.power = power;
    }

    public String wireCross() {
        String x = "";
        for (int i = 0; i < wireCrossSection.length - 1; i++) {

            Log.e(TAG, "Цикл For  WireCalculation () --> " + i);
            if (this.current > fixCurrent[i] && this.current <= fixCurrent[i + 1]) {

                x = this.wireCrossSection[i];
                return x;
            }

            else if (this.current > fixCurrent[wireCrossSection.length - 1] && this.current < 250.0) {
                x = this.wireCrossSection[13];
                return x;
            }

            else if (this.current == 0.0){
                x = "Введите не нулевое значение!";
                return x;
            }

            else
            x = "Ставь шину";
        }

        return x;

    }

    public String wireCross(double current) {
        String x = "";
        for (int i = 0; i < wireCrossSection.length - 1; i++) {


            if (current > fixCurrent[i] && current <= fixCurrent[i + 1]) {

                x = this.wireCrossSection[i];
                return x;
            }

            else if (current > fixCurrent[wireCrossSection.length - 1] && current < 250.0) {
                x = this.wireCrossSection[13];
                return x;
            }

            else if (current == 0.0){
                x = "Введите не нулевое значение!";
                return x;
            }

            else
                x = "Ставь шину";
        }

        return x;

    }

    public double getCurrent (){
        Log.e(TAG, "Метод getCurrent --> "+current);
        return current;
    }

    public double getPower (){
        return this.power;
    }
    // Расчет мощности по току (приблеженное значение)

    public double getCalcPower (){
        this.calcPower = 0.57127*this.current - 0.26115;
        calcPower = new BigDecimal(this.calcPower).setScale(2, RoundingMode.UP).doubleValue();
        return calcPower;
    }

    public double getCalcPower (double current){
        this.calcPower = 0.57127*current - 0.26115;
        calcPower = new BigDecimal(this.calcPower).setScale(2, RoundingMode.UP).doubleValue();
        return calcPower;
    }

    // Расчет тока по мощности (приблеженное значение)
    public double getCalcCurrent (){
        this.calcCurrent = 0.57127*this.current - 0.26115;
        calcCurrent = new BigDecimal(this.calcCurrent).setScale(2, RoundingMode.UP).doubleValue();
        return calcCurrent;
    }

    public double getCalcCurrent (double power){
        this.calcCurrent = 1.75126*power + 0.386555;
        calcCurrent = new BigDecimal(this.calcCurrent).setScale(2, RoundingMode.UP).doubleValue();
        return calcCurrent;
    }


    public void starDelta (){

        this.currentStarDeltaLine = round(this.current*0.58) ;
        this.currentStarDeltaShoulder = round(this.current * 0.333);
    }

    public double getCurrentStarDeltaLine (){
        return  this.currentStarDeltaLine;
    }

    public double getCurrentStarDeltaShoulder(){
        return this.currentStarDeltaShoulder;
    }
}
