package com.example.vladyslav_kovega.mycorsystem;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
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
import android.widget.LinearLayout;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class MainActivity extends AppCompatActivity {

    /*public byte numberOfPumps = 4;
    Controller controller = new Controller();

*/
    private static final int SET_SETTING = 0;

    public static final String COLOR_KEY_MAIN = "com.example.vladyslav_kovega.mycorsystem_COLOR_KEY_MAIN";
    public static final String TAG = "MainActivity";
    public static final String APP_PREFERENCES = "mySetting";
    public static final String APP_PREF_COLOR_BG = "colorBg";

    double gCurrent, gPower, gCurrentStarDeltaLine, gCurrentStarDeltaShoulder;

    EditText current, power;
    TextView wire_cross_section;
    String wireCrossSection;

    private SharedPreferences mySetting;

    private String appVersion = BuildConfig.VERSION_NAME;

    WireCalculation wireCalculation;
    int color;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mySetting = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

        wireCalculation =  new WireCalculation();
        // обработка вьюшек
        wire_cross_section = (TextView) findViewById(R.id.wire_cross_section);
        current = (EditText) findViewById(R.id.current);
        power = (EditText) findViewById(R.id.power);



                // Обработка введенного значения в поле ТОК и переопределение клавиши ГОТОВО цифровой клавиатуры
        current.setOnEditorActionListener(new EditText.OnEditorActionListener() {


                    @Override
                    public boolean onEditorAction(TextView v, int actionId,
                                                  KeyEvent event) {
                        if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER))
                                || (actionId == EditorInfo.IME_ACTION_DONE)) {
                            //сделать, что нужно по нажатию на Done
                            try {

                                gCurrent = Double.parseDouble(current.getText().toString());
                                //Log.e(TAG, "Присваивание после ввода --> " + gCurrent);
                                //gPower = Double.parseDouble(power.getText().toString());
                                wireCalculation.setCurrent(gCurrent);
                                //Log.e(TAG, "Установка setCurrent --> " + gCurrent);
                                wireCrossSection = wireCalculation.wireCross();
                                //Log.e(TAG, "візов метода wireCross() --> " + gCurrent);
                                wireCalculation.starDelta();
                                gCurrentStarDeltaLine = wireCalculation.getCurrentStarDeltaLine();
                                gCurrentStarDeltaShoulder = wireCalculation.getCurrentStarDeltaShoulder();


                            } catch (NumberFormatException e) {
                                wire_cross_section.setText("Введите корректные значения тока или мощности");
                            }

                            wire_cross_section.setText(
                                    "Сечение провода - " + wireCalculation.wireCross() + "\n" +
                                            "Линейный ток в звезде - " + gCurrentStarDeltaLine + "\n" +
                                            "Сечение провода для звезды - " + wireCalculation.wireCross(gCurrentStarDeltaLine) + "\n" +
                                            "Ток в звезде (меньший контактор) - " + gCurrentStarDeltaShoulder + "\n" +
                                            "Сечение на маленьком контакторе - " + wireCalculation.wireCross(gCurrentStarDeltaShoulder)
                            );
                            if (gCurrent == 0) power.setText("0");
                            else
                                power.setText("~" + Double.toString(wireCalculation.getCalcPower(gCurrent)) + " kW");

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
                        //Log.e(TAG, "Присваивание после ввода --> ");
                        //gPower = Double.parseDouble(power.getText().toString());
                        wireCalculation.setCurrent(new BigDecimal(wireCalculation.getCalcCurrent(gPower)*1.1).setScale(2, RoundingMode.UP).doubleValue());
                        //Log.e(TAG, "Установка");
                        wireCrossSection = wireCalculation.wireCross();
                        //Log.e(TAG, "вызов метода wireCross() --> ");
                        wireCalculation.starDelta();
                        gCurrentStarDeltaLine = wireCalculation.getCurrentStarDeltaLine();
                        gCurrentStarDeltaShoulder = wireCalculation.getCurrentStarDeltaShoulder();
                    }

                    catch (NumberFormatException e) {
                        wire_cross_section.setText("Введите корректные значения тока или мощности");
                    }

                    wire_cross_section.setText(
                            "Сечение провода - " + wireCalculation.wireCross() + "\n" +
                                    "Линейный ток в звезде - " + gCurrentStarDeltaLine + "\n" +
                                    "Сечение провода для звезды - " + wireCalculation.wireCross(gCurrentStarDeltaLine) + "\n" +
                                    "Ток в звезде (меньший контактор) - " + gCurrentStarDeltaShoulder + "\n" +
                                    "Сечение на маленьком контакторе - " + wireCalculation.wireCross(gCurrentStarDeltaShoulder)
                    );
                    if (gPower == 0) current.setText("0");
                    else
                        current.setText("~" + Double.toString(new BigDecimal(wireCalculation.getCalcCurrent(gPower)*1.1).setScale(2, RoundingMode.UP).doubleValue()) + " A");
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
    public void onResume(){
        super.onResume();
        Log.e(TAG, "onResume!!!!!!!!!!!!!!!!!!!!!");
                LinearLayout linearLayoutRoot = (LinearLayout) findViewById(R.id.lL);
        if (mySetting.contains(APP_PREF_COLOR_BG)){
            color = mySetting.getInt(APP_PREF_COLOR_BG,ContextCompat.getColor(getApplicationContext(), R.color.green_bg));
            linearLayoutRoot.setBackgroundColor(color);
        }
    }

    public void onPause(){
        super.onPause();
        Log.e(TAG, "onPause!!!!!!!!!!!!!!!!!!!!!");
        SharedPreferences.Editor editor = mySetting.edit();
        editor.putInt(APP_PREF_COLOR_BG, color);
        editor.apply();

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

       switch (id) {
           case R.id.action_settings:
               Log.e(TAG, "Выбор меню вызова активити Настроек!!!!!!!!!!!!!!!!!");
               // Выбор пункта меню выведет Активити настроек.
               Intent intent = new Intent(MainActivity.this, SettingActivity.class);
               LinearLayout linearLayoutRoot = (LinearLayout) findViewById(R.id.lL);
               //Запуск активити свойств с ожиданием результата.
               intent.putExtra(COLOR_KEY_MAIN, color);
               startActivityForResult(intent,SET_SETTING);
               Log.e(TAG, "Запуск активити с ожиданием результата!!!!!!!!!!!!!!!!!");

               return true;

           case R.id.about_prog:
               AlertDialog.Builder builder;
               builder = new AlertDialog.Builder(MainActivity.this);
               builder.setTitle("о программе!")
                       .setMessage("Подбор сечения." + "\n" + "Версия программы:" + appVersion)
                       .setCancelable(false)
                       .setNegativeButton("ОК",
                               new DialogInterface.OnClickListener() {
                                   public void onClick(DialogInterface dialog, int id) {
                                       dialog.cancel();
                                   }
                               });
               AlertDialog alert = builder.create();
               alert.show();

               return true;

           default:
               return super.onOptionsItemSelected(item);
       }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        Log.e(TAG, "вызов метода onActivityResult!!!!!!!!!!!!!!!!!" +  "requestCode = " + requestCode + "RESULT_OK" + RESULT_OK +", resultCode = " + resultCode);
        //LinearLayout linearLayoutRoot = (LinearLayout) findViewById(R.id.lL);

        if (requestCode == SET_SETTING){
            if (resultCode == RESULT_OK){
                color = data.getIntExtra(SettingActivity.COLOR_KEY,ContextCompat.getColor(getApplicationContext(), R.color.green_bg));
                //linearLayoutRoot.setBackgroundColor(colorbg);
                //this.color = colorbg;
            //} else {
             //   linearLayoutRoot.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.green_bg));
            }
        }
        SharedPreferences.Editor editor = mySetting.edit();
        editor.putInt(APP_PREF_COLOR_BG,color);
        editor.apply();

    }

   /* public void trueOrFolse(View view){
        controller.discretInOutPump[1].wsk = !controller.discretInOutPump[1].wsk;
        Toast toast = Toast.makeText(getApplicationContext(),
                Boolean.toString(controller.discretInOutPump[1].wsk) , Toast.LENGTH_SHORT);
        toast.show();
    }*/



}
