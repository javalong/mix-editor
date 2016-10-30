package com.javalong.lib.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.javalong.lib.R;
import com.javalong.lib.bean.Media;
import com.javalong.lib.utils.DisplayUtils;

/**
 * Created by javalong on 2016/4/18.
 */
public class MediaBottomLayout extends LinearLayout implements View.OnClickListener {

    public MediaBottomLayout(Context context) {
        super(context);
        init();
    }

    public MediaBottomLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        createMediaButton(Media.Type.IMAGE);
        int topAndBottomMargin = DisplayUtils.dip2px(getContext(), 10);
        addVerticle(this, 1, topAndBottomMargin);
        createMediaButton(Media.Type.TEXT);
        addVerticle(this, 1, topAndBottomMargin);
        createMediaButton(Media.Type.PREVIEW);
    }

    private void createMediaButton(Media.Type image) {
        LayoutParams ll_param = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT, 1);
        MediaButton mediaButton = new MediaButton(getContext());
        mediaButton.initData(image);
        addView(mediaButton, ll_param);
        mediaButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (onMediaButtonClickListener != null) {
            onMediaButtonClickListener.onMediaButtonClick(((MediaButton) v).getMediaType());
        }
    }

    public interface OnMediaButtonClickListener {
        void onMediaButtonClick(Media.Type type);
    }

    private OnMediaButtonClickListener onMediaButtonClickListener;

    public void setOnMediaButtonClickListener(OnMediaButtonClickListener onMediaButtonClickListener) {
        this.onMediaButtonClickListener = onMediaButtonClickListener;
    }


    public static View addVerticle(ViewGroup viewGroup, int dp, int topAndBottomMargin) {
        if (viewGroup == null) {
            return null;
        }
        int dpSize = DisplayUtils.dip2px(viewGroup.getContext(), dp);
        ViewGroup.MarginLayoutParams ll_param = new ViewGroup.MarginLayoutParams(dpSize, ViewGroup.LayoutParams.MATCH_PARENT);
        ll_param.topMargin = topAndBottomMargin;
        ll_param.bottomMargin = topAndBottomMargin;
        View view = new View(viewGroup.getContext());
        view.setBackgroundResource(R.color.bg_gray_line);
        viewGroup.addView(view, ll_param);
        return view;
    }
}
