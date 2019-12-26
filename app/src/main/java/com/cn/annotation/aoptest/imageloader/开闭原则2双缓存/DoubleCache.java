package com.cn.annotation.aoptest.imageloader.开闭原则2双缓存;

import android.graphics.Bitmap;

import com.cn.annotation.aoptest.imageloader.单一原则.ImageCache;
import com.cn.annotation.aoptest.imageloader.开闭原则1.DiskCache;

public class DoubleCache {
    ImageCache mImageCache = new ImageCache();
    DiskCache mDiskCache = new DiskCache();

    //先从内存取图片，没有再从SD卡取
    public Bitmap get(String url) {
        Bitmap bitmap = mImageCache.get(url);
        if (bitmap == null) {
            bitmap = mDiskCache.get(url);
        }
        return bitmap;
    }
    public void put(String url,Bitmap bitmap){
        mImageCache.put(url,bitmap);
        mDiskCache.put(url,bitmap);
    }

}
