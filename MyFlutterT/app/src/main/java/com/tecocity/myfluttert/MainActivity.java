package com.tecocity.myfluttert;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import io.flutter.embedding.android.FlutterFragment;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Flutter MainActivity";


    /**
     * 嵌入到 Activity 界面的 FlutterFragment
     */
    private FlutterFragment mFlutterFragment;



    private TextView tv_result;
    private Button btn1,btn2,btn3,btn4,btn5;
    private FrameLayout fragme;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化控件
        tv_result=findViewById(R.id.tv_show);
        //创建fragment
        btn1=findViewById(R.id.button1);
        //跳转到 flutter的framgnetactvity中
        btn2=findViewById(R.id.button2);

        //设置发消息的通道
        btn3=findViewById(R.id.button3);
        btn4=findViewById(R.id.button4);
        btn5=findViewById(R.id.button5);
        //当前界面需要引用flutter设置的fragment
        fragme=findViewById(R.id.frame);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction =
                        getSupportFragmentManager().beginTransaction();

                // 使用该方法创建的 Fragment 没有传递数据
                //FlutterFragment.createDefault()
                // 打开默认界面
                //fragmentTransaction.replace(R.id.frame, FlutterFragment.createDefault());

                mFlutterFragment = FlutterFragment.withNewEngine().
                        initialRoute("嵌入 FlutterFragment").build();

                Log.i(TAG, "mFlutterFragment : " + mFlutterFragment);

                // 创建 FlutterFragment
                fragmentTransaction.replace(R.id.frame, mFlutterFragment);
                fragmentTransaction.commit();
            }
        });


    }
}