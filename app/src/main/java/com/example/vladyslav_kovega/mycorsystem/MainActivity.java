package com.example.vladyslav_kovega.mycorsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    /*public byte numberOfPumps = 4;
    Controller controller = new Controller();

*/
    double gCurrent, gPower, gCurrentStarDeltaLine, gCurrentStarDeltaShoulder;
    EditText current, power;
    TextView wire_cross_section;
    String wireCrossSection;

    WireCalculation wireCalculation;
    public static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wireCalculation =  new WireCalculation();
        // обработка вьюшек
        wire_cross_section = (TextView) findViewById(R.id.wire_cross_section);
        current = (EditText) findViewById(R.id.current);
        power = (EditText) findViewById(R.id.power);

        current.setOnEditorActionListener(new EditText.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId,
                                          KeyEvent event) {
                if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER))
                        || (actionId == EditorInfo.IME_ACTION_DONE)) {
                    //сделать, что нужно по нажатию на Done
                    try {
                        gCurrent = Double.parseDouble(current.getText().toString());
                        Log.e(TAG, "Присваивание после ввода --> " + gCurrent);
                        //gPower = Double.parseDouble(power.getText().toString());
                        wireCalculation.setCurrent(gCurrent);
                        Log.e(TAG, "Установка setCurrent --> " + gCurrent);
                        wireCrossSection = wireCalculation.wireCross();
                        Log.e(TAG, "візов метода wireCross() --> " + gCurrent);
                        wireCalculation.starDelta();
                        gCurrentStarDeltaLine = wireCalculation.getCurrentStarDeltaLine();
                        gCurrentStarDeltaShoulder = wireCalculation.getCurrentStarDeltaShoulder();


                    }

                    catch (NumberFormatException e) {
                        wire_cross_section.setText("Введите корректные значения тока или мощности");
                    }

                    wire_cross_section.setText(
                            "Сечение провода - " + wireCalculation.wireCross()+"\n" +
                            "Линейный ток в звезде - " + gCurrentStarDeltaLine + "\n" +
                            "Сечение провода для звезды - " + wireCalculation.wireCross(gCurrentStarDeltaLine) + "\n"+
                            "Ток в звезде (меньший контактор) - " +  gCurrentStarDeltaShoulder + "\n" +
                            "Сечение на маленьком контакторе - " + wireCalculation.wireCross(gCurrentStarDeltaShoulder)
                    );
                    power.setText("~" + Double.toString(wireCalculation.getCalcPower(gCurrent))+" kW");

                }
                return false;
            }
        });

        power.setOnEditorActionListener(new EditText.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId,
                                          KeyEvent event) {
                if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER))
                        || (actionId == EditorInfo.IME_ACTION_DONE)) {
                    //сделать, что нужно по нажатию на Done
                    try {
                        gPower = Double.parseDouble(power.getText().toString());
                        Log.e(TAG, "Присваивание после ввода --> ");
                        //gPower = Double.parseDouble(power.getText().toString());
                        wireCalculation.setPower(gPower);
                        Log.e(TAG, "Установка");
                        wireCrossSection = wireCalculation.wireCross();
                        Log.e(TAG, "візов метода wireCross() --> ");
                    }

                    catch (NumberFormatException e) {
                        wire_cross_section.setText("Введите корректные значения тока или мощности");
                    }

                    wire_cross_section.setText("Сечение провода - " + wireCalculation.wireCross());
                }
                return false;
            }
        });

        // обработка нажатия кнопки просчета
        final Button button1 = (Button) findViewById(R.id.Button1);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                try {
                    gCurrent = Double.parseDouble(current.getText().toString());
                    Log.e(TAG, "Присваивание после ввода --> " + gCurrent);
                    //gPower = Double.parseDouble(power.getText().toString());
                    wireCalculation.setCurrent(gCurrent);
                    Log.e(TAG, "Установка setCurrent --> " + gCurrent);
                    wireCrossSection = wireCalculation.wireCross();
                    Log.e(TAG, "візов метода wireCross() --> " + gCurrent);
                }

                catch (NumberFormatException e) {
                    wire_cross_section.setText("Введите корректные значения тока или мощности");
                }

                wire_cross_section.setText("Сечение провода - " + wireCalculation.wireCross());

            }


        });



        /*
        controller.InOutPump(numberOfPumps);*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
   /* public void trueOrFolse(View view){
        controller.discretInOutPump[1].wsk = !controller.discretInOutPump[1].wsk;
        Toast toast = Toast.makeText(getApplicationContext(),
                Boolean.toString(controller.discretInOutPump[1].wsk) , Toast.LENGTH_SHORT);
        toast.show();
    }*/



}
