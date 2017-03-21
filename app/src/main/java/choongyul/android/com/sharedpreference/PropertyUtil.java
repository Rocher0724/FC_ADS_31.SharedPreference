package choongyul.android.com.sharedpreference;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 * Created by myPC on 2017-03-21.
 */

public class PropertyUtil {

    private String PROP_FILE = "sp.property";
    private String internalStoragePath;
    private static PropertyUtil instance = null;
    private static Context context;

    // 생성자가 호출될때 internalStorage를 세팅해줘야 한다.
    private PropertyUtil() {
        internalStoragePath = context.getFilesDir().getAbsolutePath();
    }

    public static PropertyUtil getInstance (Context ctx) {
        if(instance == null) {
            instance = new PropertyUtil();
        }
        context = ctx;
        return instance;
    }
    public String getProperty(String key) {
        String value = "";

        Properties prop = new Properties();
        try{
            FileInputStream fis = new FileInputStream(internalStoragePath + "/" + PROP_FILE);
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
