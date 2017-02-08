package com.ls.basic.utils;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static android.R.attr.name;

/**
 * Created by hx on 2016/3/21.
 */
public abstract class FileUtils {

    /**
     * 复制assets/skin目录下的皮肤文件到指定目录
     *
     * @param context  the context
     * @param pathName file path and name
     * @param toDir    指定目录
     * @return
     */
    public static String copyAssetsFileToDir(Context context, String pathName, String toDir) throws IOException {
        String toFile = toDir + File.separator + name;
        InputStream is = context.getAssets().open(pathName);
        File fileDir = new File(toDir);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }
        OutputStream os = null;
        IOException exception = null;
        try {
            os = new FileOutputStream(toFile);
            IOUtil.copy(is, os);
        } catch (IOException e) {
            exception = e;
        } finally {
            IOUtil.closeQuietly(is);
            IOUtil.closeQuietly(os);
        }
        if (null != exception) {
            throw exception;
        }
        return toFile;
    }

    /**
     * 得到手机的缓存目录
     *
     * @param context
     * @return
     */
    public static String getCacheDir(Context context) {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            File cacheDir = context.getExternalCacheDir();
            if (cacheDir != null && (cacheDir.exists() || cacheDir.mkdirs())) {
                return cacheDir.getAbsolutePath();
            }
        }

        File cacheDir = context.getCacheDir();
        return cacheDir.getAbsolutePath();
    }


}
