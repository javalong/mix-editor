package com.javalong.lib.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.javalong.lib.R;

/**
 * Created by javalong on 2016/1/24 0024.
 * 缺省背景
 */
public class  EmptyView extends FrameLayout {

    private ImageView iv_blank;
    private TextView tv_alert;

    public EmptyView(Context context) {
        super(context);
        init();
    }

    public EmptyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.EmptyView);
        int N = typedArray.getIndexCount();
        for (int i = 0; i < N; i++) {
            int attr = typedArray.getIndex(i);
            int resourceId = 0;
            if (attr == R.styleable.EmptyView_ep_bg) {
                resourceId = typedArray.getResourceId(
                        R.styleable.EmptyView_ep_bg, 0);
                iv_blank.setImageResource(resourceId > 0 ? resourceId
                        : R.drawable.ic_empty_default);
            } else if (attr == R.styleable.EmptyView_ep_alert) {
                resourceId = typedArray.getResourceId(
                        R.styleable.EmptyView_ep_bg, 0);
                if (resourceId == 0) {
                    tv_alert.setText(getResources().getText(resourceId));
                } else {
                    tv_alert.setText(typedArray.getString(R.styleable.EmptyView_ep_alert));
                }

            }
        }
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.default_blank, this);
        iv_blank = (ImageView) findViewById(R.id.iv_blank);
        tv_alert = (TextView) findViewById(R.id.tv_alert);
    }

    public void setImage(int resId) {
        iv_blank.setImageResource(resId);
    }

    public void setAlert(String alert) {
        tv_alert.setText(alert);
    }
}
