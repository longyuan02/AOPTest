package com.cn.annotation.aoptest;

import android.app.Activity;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.facebook.react.LifecycleState;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.shell.MainReactPackage;

import org.aspectj.lang.annotation.Before;

import java.text.SimpleDateFormat;


public class MainActivityTest extends Activity {
    private static final String TAG = "Main====";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.tv_text);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mText(null);
            }
        });
        new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
            }
        });
        ReactRootView react_root_view = findViewById(R.id.react_root_view);
        ReactInstanceManager mReactInstanceManager = ReactInstanceManager.builder()
                .setApplication(getApplication())
                .setBundleAssetName("index.android.bundle")
                .setJSMainModuleName("index.android")
                .addPackage(new MainReactPackage())
                .setUseDeveloperSupport(BuildConfig.DEBUG)
                .setInitialLifecycleState(LifecycleState.RESUMED)
                .build();

        //ReactNativeApp 是项目名，需要和index.adnroid.js中的保持一致
        react_root_view.startReactApplication(mReactInstanceManager, "AOPTest", null);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    @Before("execution(public * *(..))")
    public void before() {
        System.out.println("CSDN_LQR");
    }

    /**
     * 摇一摇的模块
     *
     * @param view
     */
    public void mShake(View view) {
        //摇一摇的代码逻辑
        {
            SystemClock.sleep(3000);
            Log.i(TAG, " 摇到一个红包");

        }
    }

    /**
     * 语音的模块
     *
     * @param view
     */
    public void mAudio(View view) {
        //语音代码逻辑
        {
            SystemClock.sleep(3000);
            Log.i(TAG, "发语音：我要到一个红包啦");
        }
    }

    /**
     * 打字模块
     *
     * @param view
     */
    @BehaviorTrace(value = "打字:", type = 1)
    public void mText(View view) {
        //打字模块逻辑
        {
            SystemClock.sleep(3000);
            Log.i(TAG, "打字逻辑，我摇到了一个大红包");

        }
    }
}

