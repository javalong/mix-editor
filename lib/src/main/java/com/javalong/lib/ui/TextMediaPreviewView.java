package com.javalong.lib.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.javalong.lib.R;
import com.javalong.lib.bean.Media;

/**
 * Created by javalong on 2016/4/21.
 * 文本预览
 */
public class TextMediaPreviewView extends MediaPreviewView {

    private TextView tv_desc;

    public TextMediaPreviewView(Context context) {
        super(context);
        init();
    }

    public TextMediaPreviewView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mInflater.inflate(R.layout.view_textmedia_preview, this);
        tv_desc = (TextView) findViewById(R.id.tv_desc);
    }

    @Override
    public void initData(Media media) {
        super.initData(media);
        tv_desc.setText(media.getDesc());
    }
}
