package com.javalong.lib.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.javalong.lib.bean.Media;
import com.javalong.lib.ui.EmptyView;
import com.javalong.lib.ui.ImageMediaPreviewView;
import com.javalong.lib.ui.MediaView;
import com.javalong.lib.ui.TextMediaPreviewView;
import com.javalong.lib.viewholder.ViewHolder;

import java.util.List;


/**
 * Created by javalong on 2016/4/18.
 */
public class MediaPreviewAdapter extends RecyclerView.Adapter<ViewHolder> {

    public final static int EMPTY = -1;
    public final static int TEXT = 0;
    public final static int IMAGE = 1;

    private Context mContext;
    private List<Media> dataList;
    public MediaPreviewAdapter(Context context, List<Media> dataList) {
        mContext = context;
        this.dataList = dataList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TEXT:
                return new ViewHolder(new TextMediaPreviewView(parent.getContext()));
            case IMAGE:
                return new ViewHolder(
                        new ImageMediaPreviewView(parent.getContext()));
            case EMPTY:
                EmptyView emptyView = new EmptyView(parent.getContext());
                return new ViewHolder(emptyView);
        }
        return new ViewHolder(new View(parent.getContext()));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Media media = dataList.get(position);
        if (media != null) {
            ((MediaView) holder.itemView).initData(media);
            ((MediaView) holder.itemView).setMediaList(dataList);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (dataList == null || dataList.size() == 0) {
            return EMPTY;
        }
        Media media = dataList.get(position);
        if (media == null) {
            return EMPTY;
        }
        return media.getType();
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}