package com.javalong.lib.recyclerview;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.AttributeSet;

import com.javalong.lib.R;
import com.javalong.lib.adapter.MediaAdapter;
import com.javalong.lib.bean.Media;
import com.javalong.lib.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by javalong on 2016/4/15.
 * 图文编辑
 */
public class EditMediaRecyclerView extends RecyclerView {
    private static final String TAG = "EditMediaRecyclerView";
    private List<Media> mediaList;
    private MediaAdapter mAdapter;
    private ItemTouchHelper mItemTouchHelper;

    public List<Media> getMediaList() {
        return mediaList;
    }

    public EditMediaRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public EditMediaRecyclerView(Context context) {
        super(context);
        init();
    }

    private void init() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        setLayoutManager(linearLayoutManager);
        setBackgroundResource(R.color.white);
        this.mediaList = new ArrayList<>();
        this.mAdapter = new MediaAdapter(getContext(), this.mediaList, this);
        setAdapter(this.mAdapter);
        initDrag();
    }


    public void initDrag() {
        ItemTouchHelper.Callback callback = new SimpleItemTouchCallback(mediaList);
        mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(this);
    }

    public void addMedia(Media media) {
        if (mediaList == null) {
            return;
        }
        mediaList.add(media);
        mAdapter.notifyItemInserted(mediaList.size() - 1);
    }
}
