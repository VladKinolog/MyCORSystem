package com.example.vladyslav_kovega.mycorsystem;

/**
 * Created by ingineer on 28.11.2015.
 */
public abstract class Pressure {

    private float setPressure;
    private float pressureMaxSensor;
    private float pressureMinSensor;
    private float pressureGisteresis;
    private float pressureWithoutVltGisreresis;
    private float maxPressure;
    private float minPressure;
    private boolean withOrWitoutVlt;
    private int getPressure;

    /**
     *  конструктор оп умолчанию
     */
    public Pressure(){
        this.pressureMaxSensor = 6.0f;
        this.pressureMinSensor = 0.0f;
        this.pressureGisteresis = 0.5f;
        this.pressureWithoutVltGisreresis = 1.0f;
        this.maxPressure = 6.0f;
        this.minPressure = 2.0f;
        this.setPressure = 4.0f;
    }

    /**
     *   установка параметров системмы по давлению
     */

    public void pressure(float pressureMaxSensor, float pressureMinSensor, float pressureGisteresis,
                         float pressureWithoutVltGisreresis, float maxPressure, float minPressure){
        this.pressureMaxSensor = pressureMaxSensor;
        this.pressureMinSensor = pressureMinSensor;
        this.pressureGisteresis = pressureGisteresis;
        this.pressureWithoutVltGisreresis = pressureWithoutVltGisreresis;
        this.maxPressure = maxPressure;
        this.minPressure = minPressure;
    }

    /**
     * задание давления
     */

    public float setPressure (float setPressure ){
        this.setPressure = setPressure;
        return this.setPressure;
    }

    /**
     * Давление по датчику давления принял от 0 до 1000 типа int
     */

    public void getPressure (int getPressureSensor){

    }

    /**
     *  Проверка установлен ли режирым работы без ПЧ или нет
     */
    public boolean withOrWitoutVlt (boolean withOrWitoutVlt){
        this.withOrWitoutVlt = withOrWitoutVlt;
        return this.withOrWitoutVlt;
    }

}
