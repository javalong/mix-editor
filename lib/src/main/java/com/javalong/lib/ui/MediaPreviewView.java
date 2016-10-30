package com.javalong.lib.ui;

import android.content.Context;
import android.util.AttributeSet;

import com.javalong.lib.bean.Media;

/**
 * Created by javalong on 2016/4/21.
 * 图片预览基类
 */
public abstract class MediaPreviewView extends MediaView {

    public MediaPreviewView(Context context) {
        super(context);
        init();
    }

    public MediaPreviewView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
    }

    @Override
    public void initData(Media media) {
        super.initData(media);
    }

}
