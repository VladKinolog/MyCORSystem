package com.example.vladyslav_kovega.mycorsystem;

        import android.app.Activity;
        import android.content.res.Resources;
        import android.graphics.Color;
        import android.os.Bundle;
        import android.support.v4.content.ContextCompat;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.LinearLayout;

/**
 * Created by Vladyslav
 */
public class SettingActivity extends AppCompatActivity {

    int color = ContextCompat.getColor(getApplicationContext(), R.color.green_bg);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.prog_setting);
            //TODO Осуществить проверку на первый запуск.??
        LinearLayout linearLayoutRoot = (LinearLayout) findViewById(R.id.activity_root_element);
        linearLayoutRoot.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.green_bg));

    }

    public void onClickGreenBgButton(View view){
        LinearLayout linearLayoutRoot = (LinearLayout) findViewById(R.id.activity_root_element);
        linearLayoutRoot.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.green_bg));
        color = ContextCompat.getColor(getApplicationContext(), R.color.green_bg);
    }

    public void onClickBlueBgButton(View view){
        LinearLayout linearLayoutRoot = (LinearLayout) findViewById(R.id.activity_root_element);
        linearLayoutRoot.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.blue_bg));
        color = ContextCompat.getColor(getApplicationContext(), R.color.blue_bg);
    }

    public void onClickLightyellowBgButton(View view){
        LinearLayout linearLayoutRoot = (LinearLayout) findViewById(R.id.activity_root_element);
        linearLayoutRoot.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.light_yel_bg));
        color = ContextCompat.getColor(getApplicationContext(), R.color.light_yel_bg);
    }

    public void onClickYellowBgButton(View view){
        LinearLayout linearLayoutRoot = (LinearLayout) findViewById(R.id.activity_root_element);
        linearLayoutRoot.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.yellow_bg));
        color = ContextCompat.getColor(getApplicationContext(), R.color.yellow_bg);
    }

    public void onClickPinkBgButton(View view){
        LinearLayout linearLayoutRoot = (LinearLayout) findViewById(R.id.activity_root_element);
        linearLayoutRoot.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.pink_bg));
        color = ContextCompat.getColor(getApplicationContext(), R.color.pink_bg);
    }

    public void onClickRedBgButton(View view) {
        LinearLayout linearLayoutRoot = (LinearLayout) findViewById(R.id.activity_root_element);
        linearLayoutRoot.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.red_bg));
        color = ContextCompat.getColor(getApplicationContext(), R.color.red_bg);
    }
}
