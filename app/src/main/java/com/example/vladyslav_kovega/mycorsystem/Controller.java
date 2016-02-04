package com.example.vladyslav_kovega.mycorsystem;

import java.sql.Array;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ingineer on 01.12.2015.
 */
public class Controller {

    public byte numberOfPumps;
    DiscretInOutPump [] discretInOutPump;
   /**
   Map <String,DiscretInOutPump> discretInOutMap = new HashMap <String,DiscretInOutPump>();


    public Map InOutPump(byte numberOfPumps) {
        this.numberOfPumps = numberOfPumps;
        for (byte i = 0; i <= numberOfPumps; i++) {
            String name = "Pump"+i;
            DiscretInOutPump DiscretInOutPump = new DiscretInOutPump();
            discretInOutMap.put(name,DiscretInOutPump);
        }
        return discretInOutMap;
    }
    /*

    /**
     * Возвращает массив входов выходов для каждого насоса
     * @param numberOfPumps
     * @return
     */

    public DiscretInOutPump[] InOutPump(byte numberOfPumps){
        this.numberOfPumps = numberOfPumps;
        this.discretInOutPump = new DiscretInOutPump [numberOfPumps];
        for (byte i = 0; i < discretInOutPump.length; i++)
            discretInOutPump[i] = new DiscretInOutPump();

        return discretInOutPump;
    }
}
