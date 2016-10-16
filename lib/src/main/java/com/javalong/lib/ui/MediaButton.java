package com.javalong.lib.ui;

import android.content.Context;
import android.util.AttributeSet;

import com.javalong.lib.R;
import com.javalong.lib.bean.Media;

/**
 * Created by javalong on 2016/4/18.
 */
public class MediaButton extends ImageTextButton {
    private Media.Type mediaType;

    public Media.Type getMediaType() {
        return mediaType;
    }

    public void setMediaType(Media.Type mediaType) {
        this.mediaType = mediaType;
    }

    public MediaButton(Context context) {
        super(context);
        init();
    }

    public MediaButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
    }

    public void initData(Media.Type mediaType) {
        this.mediaType = mediaType;
        switch (mediaType) {
            case IMAGE:
                super.initData(R.drawable.media_image, "图片");
                break;
            case TEXT:
                super.initData(R.drawable.media_text, "文字");
                break;
        }
    }
}
