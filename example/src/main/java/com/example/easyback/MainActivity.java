package com.example.easyback;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.slidebacklib.BaseBackActivity;

public class MainActivity extends BaseBackActivity {

    private View bannerView;
    private CheckBox cbSwitch;
    private TextView tvStart;
    private int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        bannerView = findViewById(R.id.iv_banner);
        cbSwitch = (CheckBox) findViewById(R.id.cb_switch);
        cbSwitch.setChecked(false);
        cbSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    setUnslideView(bannerView);
                } else {
                    setUnslideView(null);
                }
            }
        });
        tvStart = (TextView) findViewById(R.id.tv_start);
        num = getIntent().getIntExtra("num", 0);
        tvStart.append(String.valueOf(num));
        tvStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                intent.putExtra("num", ++num);
                startActivity(intent);
            }
        });
    }
}
