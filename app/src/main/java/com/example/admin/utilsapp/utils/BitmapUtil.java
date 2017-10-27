package com.example.admin.utilsapp.utils;

import android.graphics.Bitmap;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Woodslake on 2017/3/29.
 */

public class BitmapUtil {

    public static File toFile(Bitmap bm, String path, String fileName){
        try {
            File dirFile = new File(path);
            if(!dirFile.exists()){
                dirFile.mkdir();
            }

            File file = new File(path , fileName);
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
            bm.compress(Bitmap.CompressFormat.JPEG, 80, bos);
            bos.flush();
            bos.close();
            return file;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
