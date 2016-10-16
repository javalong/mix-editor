package com.javalong.lib.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;


import com.javalong.lib.bean.Media;

import java.util.List;


/**
 * Created by javalong on 2016/4/15.
 * 图文上传控件基类
 */
public abstract class MediaView extends FrameLayout {

    protected LayoutInflater mInflater;

    private List<Media> mediaList;

    protected Media media;

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public MediaView(Context context) {
        super(context);
        init();
    }

    public MediaView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mInflater = LayoutInflater.from(getContext());
    }

    public List<Media> getMediaList() {
        return mediaList;
    }

    public void setMediaList(List<Media> mediaList) {
        this.mediaList = mediaList;
    }

    public void initData(Media media) {
        this.media = media;
    }

    /**
     * 返回该media在所有media
     * 中的位置
     *
     * @return
     */
    protected int getMediaIndex() {
        if (media == null || mediaList == null) return -1;
        return mediaList.indexOf(media);
    }

    protected void delete() {
        if (onDeleteMediaListener != null) {
            onDeleteMediaListener.onDelete(MediaView.this);
        }
    }

    protected void deleteOk() {
    }

    public interface OnDeleteMediaListener {
        void onDelete(MediaView view);
    }

    private OnDeleteMediaListener onDeleteMediaListener;

    public void setOnDeleteMediaListener(OnDeleteMediaListener onDeleteMediaListener) {
        this.onDeleteMediaListener = onDeleteMediaListener;
    }
}
