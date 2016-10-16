package com.javalong.lib.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.javalong.lib.R;

/**
 * Created by javalong on 2016/4/18.
 */
public class ImageTextButton extends FrameLayout {

    protected TextView tv_txt;
    protected ImageView iv_img;

    public ImageTextButton(Context context) {
        super(context);
        init();
    }

    public ImageTextButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_imagetext_btn, this);
        tv_txt = (TextView) findViewById(R.id.tv_txt);
        iv_img = (ImageView) findViewById(R.id.iv_img);
    }

    public void initData(int imgResId, String text) {
        iv_img.setImageResource(imgResId);
        tv_txt.setText(text);
    }
}
