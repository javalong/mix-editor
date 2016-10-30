package com.javalong.lib.recyclerview;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.javalong.lib.R;
import com.javalong.lib.adapter.MediaPreviewAdapter;
import com.javalong.lib.bean.Media;

import java.util.List;


/**
 * Created by javalong on 2016/4/15.
 * 图文预览
 */
public class PreviewMediaRecyclerView extends RecyclerView {

    private List<Media> mediaList;
    private MediaPreviewAdapter mAdapter;
    public PreviewMediaRecyclerView(Context context) {
        this(context, null);
    }

    public PreviewMediaRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        setLayoutManager(linearLayoutManager);
    }

    public void initData(List<Media> mediaList) {
        if (mediaList == null) return;
        this.mediaList = mediaList;
        this.mAdapter = new MediaPreviewAdapter(getContext(), this.mediaList);
        setAdapter(this.mAdapter);
    }
}
