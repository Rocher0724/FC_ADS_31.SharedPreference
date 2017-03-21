package choongyul.android.com.sharedpreference;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    EditText etEmail;
    Switch aSwitch;
    RelativeLayout layout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etEmail = (EditText) findViewById(R.id.etEmail);
        aSwitch = (Switch) findViewById(R.id.aSwitch);
        layout2 = (RelativeLayout) findViewById(R.id.layout2);
    }

    public void closeHelp(View view) {
        layout2.setVisibility(view.GONE);
    }

    public void saveSetting(View view) {

    }
}
