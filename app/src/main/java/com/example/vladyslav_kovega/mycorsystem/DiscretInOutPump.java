package com.example.vladyslav_kovega.mycorsystem;

/**
 * Created by ingineer on 01.12.2015.
 */
public class DiscretInOutPump {

    boolean wsk;
    boolean manual;
    boolean automat;
    boolean pumpOff;
    boolean contactorStatusVlt;
    boolean contactorStatusDs;
    boolean ptc;
    boolean msStatus;

    /**
     * Конструктор по умолчанию.
     */

    public DiscretInOutPump(){

        this.wsk = true;
        this.manual = false;
        this.automat = false;
        this.pumpOff = true;
        this.contactorStatusVlt = false;
        this.contactorStatusDs = false;
        this.ptc = true;
        this.msStatus = false;
    }
}
