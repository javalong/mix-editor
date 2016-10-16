package com.javalong.lib.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.IBinder;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * Created by javalong on 16/10/16.
 */
public class ViewUtils {


    //隐藏键盘
    public static void hideKeyboard(EditText v, Context context) {
        hideKeyboard(v.getWindowToken(), context);
    }

    /**
     * 隐藏键盘
     * @param windowToken editText
     * @param context
     */
    public static void hideKeyboard(IBinder windowToken, Context context) {
        InputMethodManager imm = (InputMethodManager) context
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        // 隐藏软键盘
        imm.hideSoftInputFromWindow(windowToken, 0);
    }

    //显示键盘
    public static void showKeyboard(EditText et, Context context) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(et, InputMethodManager.SHOW_FORCED);
    }

    /**
     * 打开系统相册选择图片
     * @param activity
     * @param requestCode
     */
    public static void openGallery(Activity activity,int requestCode) {
        Intent intent = new Intent(
                Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        intent.putExtra("scale", true);
        intent.putExtra("scaleUpIfNeeded", true);
        intent.putExtra("return-data", false);
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
        intent.putExtra("noFaceDetection", true); // no face detection
        activity.startActivityForResult(intent,requestCode);
    }
}
