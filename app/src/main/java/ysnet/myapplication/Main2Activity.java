package ysnet.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.tencent.sonic.sdk.SonicEngine;
import com.tencent.sonic.sdk.SonicSessionConfig;

import butterknife.ButterKnife;
import butterknife.OnClick;

import static ysnet.myapplication.LoadDefaultCacheActivity.CLICK_TIME_WITHOUT_SONIC_CACHE;
import static ysnet.myapplication.LoadSonicWithCacheActivity.CLICK_TIME_CACHE;
import static ysnet.myapplication.LoadWithOutSonicActivity.CLICK_TIME_WITHOUT_SONIC;
import static ysnet.myapplication.LoadWithSonicActivity.CLICK_TIME;

public class Main2Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.btn_load_default, R.id.btn_load_sonic, R.id.btn_pre_load, R.id.btn_default_cache, R.id.btn_sonic_cache})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_load_default:
                Intent intent = new Intent(Main2Activity.this, LoadWithOutSonicActivity.class);
                intent.putExtra(CLICK_TIME_WITHOUT_SONIC, System.currentTimeMillis());
                startActivity(intent);
                break;
            case R.id.btn_load_sonic:
                Intent intent2 = new Intent(Main2Activity.this, LoadWithSonicActivity.class);
                intent2.putExtra(CLICK_TIME, System.currentTimeMillis());
                startActivity(intent2);
                break;
            case R.id.btn_pre_load:
                SonicSessionConfig sessionConfig = new SonicSessionConfig.Builder().build();
                boolean preloadSuccess = SonicEngine.getInstance().preCreateSession(Config.SONIC_URL, sessionConfig);
                Toast.makeText(getApplicationContext(), preloadSuccess ? "Preload start up success!" : "Preload start up fail!", Toast.LENGTH_LONG).show();
                break;
            case R.id.btn_default_cache:
                Intent intent3 = new Intent(Main2Activity.this, LoadDefaultCacheActivity.class);
                intent3.putExtra(CLICK_TIME_WITHOUT_SONIC_CACHE, System.currentTimeMillis());
                startActivity(intent3);
                break;
            case R.id.btn_sonic_cache:
                Intent intent4 = new Intent(Main2Activity.this, LoadSonicWithCacheActivity.class);
                intent4.putExtra(CLICK_TIME_CACHE, System.currentTimeMillis());
                startActivity(intent4);
                break;

        }
    }
}
