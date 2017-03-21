package choongyul.android.com.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class MainActivity extends AppCompatActivity {

    EditText etEmail;
    Switch aSwitch;
    RelativeLayout layout2;

    PropertyUtil propertyUtil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        propertyUtil = PropertyUtil.getInstance(this);
        etEmail = (EditText) findViewById(R.id.etEmail);
        aSwitch = (Switch) findViewById(R.id.aSwitch);
        layout2 = (RelativeLayout) findViewById(R.id.layout2);

        // firstopen 체크가 되어있으면 도움말 레이아웃을 닫아준다.
        if("false".equals(propertyUtil.getProperty("firstOpen"))) {
            layout2.setVisibility(View.GONE);
        }

        //세팅된 값을 가져와서 화면에 뿌린다.
        loadSetting();
    }

    public void closeHelp(View view) {
        layout2.setVisibility(view.GONE);
        propertyUtil.saveProperty("firstOpen","false");
    }

    public void saveSetting(View view) {

        // 1. Preference 생성하기
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        // 앱전체에서 사용하기 위해서는 아래와같이 쓴다.
//        SharedPreferences sharedPr1ef = getSharedPreferences("file name",Context.MODE_PRIVATE);

        // 2. Shared Preference의 값을 입력하기 위해서는 에디터를 통해서만 가능하다.
        SharedPreferences.Editor editor = sharedPref.edit();

        // 에디터에 키, 값 순서로 입력한다.
        editor.putString("email" , etEmail.getText().toString() );
        editor.putBoolean("shuffle" , aSwitch.isChecked() );

        editor.commit();

        Toast.makeText(this, "저장되었습니다.", Toast.LENGTH_SHORT).show();
    }
    public void loadSetting() {
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        String email = sharedPref.getString("email", null );
                                            // 키 , 값이없을때 디폴트로 집어넣을것
        boolean shuffle = sharedPref.getBoolean("shuffle", false );
        etEmail.setText(email);
        aSwitch.setChecked(shuffle);
    }



}
