package com.example.vladyslav_kovega.mycorsystem;

        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v4.content.ContextCompat;
        import android.support.v7.app.AppCompatActivity;
        import android.util.Log;
        import android.view.View;
        import android.widget.LinearLayout;

/**
 * Created by Vladyslav
 */
public class SettingActivity extends AppCompatActivity {
    // инициализация ключа для extraData по рекомендации Гугл (имя проекта + идентификатор)
    public static final String COLOR_KEY = "com.example.vladyslav_kovega.mycorsystem.COLOR_KEY";

    int color;// = ContextCompat.getColor(getApplicationContext(), R.color.green_bg);

    public static final String TAG = "SettingActivity";
    Intent intent = new Intent();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "SettingActivity запущен+++++++++++++++++++++++++");
        setContentView(R.layout.prog_setting);
            //TODO Осуществить проверку на первый запуск.??
//        LinearLayout linearLayoutRoot = (LinearLayout) findViewById(R.id.activity_root_element);
//        Intent getIntent = getIntent();
//        color = getIntent.getIntExtra(MainActivity.COLOR_KEY_MAIN,ContextCompat.getColor(getApplicationContext(), R.color.green_bg));
//        linearLayoutRoot.setBackgroundColor(color);


    }

    protected void onResume(){
        super.onResume();
        LinearLayout linearLayoutRoot = (LinearLayout) findViewById(R.id.activity_root_element);
        Intent getIntent = getIntent();
        color = getIntent.getIntExtra(MainActivity.COLOR_KEY_MAIN,ContextCompat.getColor(getApplicationContext(), R.color.red_bg));
        Log.e(TAG, "Intent getIntent = getIntent()+++++++++++++++++++++++++"+ color);
        linearLayoutRoot.setBackgroundColor(color);
    }

    public void onClickGreenBgButton(View view){
        LinearLayout linearLayoutRoot = (LinearLayout) findViewById(R.id.activity_root_element);
        linearLayoutRoot.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.green_bg));
        this.color = ContextCompat.getColor(getApplicationContext(), R.color.green_bg);
        intent.putExtra(COLOR_KEY, color);
        setResult(RESULT_OK, intent);

    }

    public void onClickBlueBgButton(View view){
        LinearLayout linearLayoutRoot = (LinearLayout) findViewById(R.id.activity_root_element);
        linearLayoutRoot.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.blue_bg));
        this.color = ContextCompat.getColor(getApplicationContext(), R.color.blue_bg);
        intent.putExtra(COLOR_KEY, color);
        setResult(RESULT_OK, intent);
    }

    public void onClickLightyellowBgButton(View view){
        LinearLayout linearLayoutRoot = (LinearLayout) findViewById(R.id.activity_root_element);
        linearLayoutRoot.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.light_yel_bg));
        this.color = ContextCompat.getColor(getApplicationContext(), R.color.light_yel_bg);
        intent.putExtra(COLOR_KEY, color);
        setResult(RESULT_OK, intent);
    }

    public void onClickYellowBgButton(View view){
        LinearLayout linearLayoutRoot = (LinearLayout) findViewById(R.id.activity_root_element);
        linearLayoutRoot.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.yellow_bg));
        this.color = ContextCompat.getColor(getApplicationContext(), R.color.yellow_bg);
        intent.putExtra(COLOR_KEY, color);
        setResult(RESULT_OK, intent);
    }

    public void onClickPinkBgButton(View view){
        LinearLayout linearLayoutRoot = (LinearLayout) findViewById(R.id.activity_root_element);
        linearLayoutRoot.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.pink_bg));
        this.color = ContextCompat.getColor(getApplicationContext(), R.color.pink_bg);
        intent.putExtra(COLOR_KEY, color);
        setResult(RESULT_OK, intent);
    }

    public void onClickRedBgButton(View view) {
        LinearLayout linearLayoutRoot = (LinearLayout) findViewById(R.id.activity_root_element);
        linearLayoutRoot.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.red_bg));
        this.color = ContextCompat.getColor(getApplicationContext(), R.color.red_bg);

        intent.putExtra(COLOR_KEY, color);
        setResult(RESULT_OK, intent);

    }

  //  @Override
//    public void onPause (){
//        super.onPause();
//        Log.e(TAG, "вызов onPause+++++++++++++++++++++++++");
//        Intent intent = new Intent();
//        intent.putExtra(COLOR_KEY, color);
//        setResult(RESULT_OK, intent);
//        Log.e(TAG, "setResult++++++++++++++++++++++++++++++++");
//    }
}
