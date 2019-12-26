package com.cn.annotation.aoptest;

import android.app.Application;


public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }
    /**
     * 强引用 保持持有引用除非主动断开 gc无法回收
     * 软引用 对象豁免gc 在oom之前进行垃圾回收
     * 弱引用  gc可回收 使用时,有就用没有就会在创建
     * 幻象
     * 引用类型都是抽象类java.long.ref.reference类
     */
}
