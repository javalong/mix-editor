package com.javalong.lib.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by javalong on 16/10/16.
 */
public class ToastUtils {
    /**
     * 显示Toast.
     *
     * @param text
     */
    public static void showToast(Context context, final String text) {
        Toast.makeText(context, text,
                Toast.LENGTH_SHORT).show();
    }

}
