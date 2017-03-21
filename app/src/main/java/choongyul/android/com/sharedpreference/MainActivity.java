package choongyul.android.com.sharedpreference;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Switch;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class MainActivity extends AppCompatActivity {

    EditText etEmail;
    Switch aSwitch;
    RelativeLayout layout2;

    PropertyUtil propertyUtil;

    // 내부저장소 절대경로 가져오기 , files 경로를 포함함. (/data/data/패키지명/files)
    final String propertyFile = "test.properties";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        propertyUtil.getInstance(this);
        etEmail = (EditText) findViewById(R.id.etEmail);
        aSwitch = (Switch) findViewById(R.id.aSwitch);
        layout2 = (RelativeLayout) findViewById(R.id.layout2);

        // firstopen 체크가 되어있으면 도움말 레이아웃을 닫아준다.
        if("false".equals(propertyUtil.getProperty("firstOpen"))) {
            layout2.setVisibility(View.GONE);
        }
    }

    public void closeHelp(View view) {
        layout2.setVisibility(view.GONE);
        propertyUtil.saveProperty("firstOpen","false");
    }

    public void saveSetting(View view) {

    }



}
