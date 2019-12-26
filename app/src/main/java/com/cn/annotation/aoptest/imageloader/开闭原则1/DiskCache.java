package com.cn.annotation.aoptest.imageloader.开闭原则1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DiskCache {
    static String cacheDir = "sdcard/cache/";

    //从缓存中取图片
    public Bitmap get(String url) {
        Bitmap bitmap = BitmapFactory.decodeFile(cacheDir + url);
        return bitmap;
    }

    //将图片缓存到内存中
    public void put(String url, Bitmap bitmap) {
        FileOutputStream fileOutputStream=null;
        try {
            fileOutputStream=new FileOutputStream(cacheDir+url);
            bitmap.compress(Bitmap.CompressFormat.PNG,100,fileOutputStream);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(fileOutputStream!=null){
                try {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}

