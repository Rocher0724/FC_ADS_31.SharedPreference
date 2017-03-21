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

    // 내부저장소 절대경로 가져오기 , files 경로를 포함함. (/data/data/패키지명/files)
    String internalStoragePath;
    final String propertyFile = "test.properties";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etEmail = (EditText) findViewById(R.id.etEmail);
        aSwitch = (Switch) findViewById(R.id.aSwitch);
        layout2 = (RelativeLayout) findViewById(R.id.layout2);

        internalStoragePath = getFilesDir().getPath();

        // firstopen 체크가 되어있으면 도움말 레이아웃을 닫아준다.
        if("false".equals(getProperty("firstOpen"))) {
            layout2.setVisibility(View.GONE);
        }
    }

    public void closeHelp(View view) {
        layout2.setVisibility(view.GONE);
        saveProperty("firstOpen","false");
    }

    public void saveSetting(View view) {

    }

    public String getProperty(String key) {
        String value = "";

        Properties prop = new Properties();
        try{
            FileInputStream fis = new FileInputStream(internalStoragePath + "/" + propertyFile);
            prop.load(fis);
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        prop.list(System.out); // 프로퍼티 목록 전체 나열하기

        value = prop.getProperty(key);

        return value;
    }

    public void saveProperty(String key , String value) {
        Properties prop = new Properties();
        prop.put(key, value);

        try {
            // 앱의 내부저장소/files/test.properties 파일을 저장
            FileOutputStream fos = new FileOutputStream(internalStoragePath + "/test.properties");
            prop.store(fos, "comment");

            // 저장후 파일을 닫아준다.
            fos.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
