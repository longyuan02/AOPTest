package com.cn.annotation.aoptest.imageloader.开闭优化;

import android.graphics.Bitmap;

public interface ImageCache {
    Bitmap get(String url);
    void put(String url,Bitmap bitmap);
}
