package com.wangwei.groupon.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.wangwei.groupon.R;
import com.wangwei.groupon.util.SPUtil;

public class SplashActivity extends Activity {
SPUtil spUtil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        spUtil = new SPUtil(this);
        //假模假样的停留几秒钟

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //读取偏好设置文件中的值

                //根据是否是第一层使用进行相应的界面跳转
                Intent intent;
                if (spUtil.isFirst()){
               //新手指导页挑转
                    intent = new Intent(SplashActivity.this,GuideActivity.class);
                    spUtil.setFirst(false);
                }else{
               //向主页面跳转
                    intent = new Intent(SplashActivity.this,MainActivity.class);
                }
                startActivity(intent);
                finish();
            }
        },2000);
    }
}
