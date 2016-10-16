package com.javalong.lib.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.javalong.lib.R;
import com.javalong.lib.bean.Media;
import com.javalong.lib.ui.EmptyView;
import com.javalong.lib.ui.ImageMediaView;
import com.javalong.lib.ui.MediaView;
import com.javalong.lib.ui.TextMediaView;
import com.javalong.lib.utils.DisplayUtils;
import com.javalong.lib.utils.StringUtils;
import com.javalong.lib.utils.ToastUtils;
import com.javalong.lib.viewholder.ViewHolder;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;


/**
 * Created by javalong on 2016/4/18.
 */
public class MediaAdapter extends RecyclerView.Adapter<ViewHolder> implements MediaView.OnDeleteMediaListener {

    public final static int EMPTY = -1;
    public final static int TEXT = 0;
    public final static int IMAGE = 1;
    public final static int WHITE = 3;
    private List<Media> dataList;
    private List<String> imageList;
    private View rootView;

    private Context mContext;


    public MediaAdapter(Context context, List<Media> dataList, View view) {
        imageList = new ArrayList<>();
        this.rootView = view;
        this.dataList = dataList;
        mContext = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TEXT:
                return new ViewHolder(new TextMediaView(parent.getContext()));
            case IMAGE:
                return new ViewHolder(new ImageMediaView(parent.getContext()));
            case EMPTY:
                EmptyView emptyView = new EmptyView(parent.getContext());
                ViewGroup.LayoutParams ll_param = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                emptyView.setLayoutParams(ll_param);
                return new ViewHolder(emptyView);
            case WHITE:
                View whiteView = new View(parent.getContext());
                ViewGroup.LayoutParams ll_param2 = new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        DisplayUtils.dip2px(mContext, 100)
                );
                whiteView.setBackgroundResource(R.color.white);
                whiteView.setLayoutParams(ll_param2);
                whiteView.setTag(WHITE);
                ViewHolder viewHolder = new ViewHolder(whiteView);
                return viewHolder;
        }
        return new ViewHolder(null);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (dataList.size()>position) {
            Media media = dataList.get(position);
            ((MediaView) holder.itemView).initData(media);
            ((MediaView) holder.itemView).setMediaList(dataList);
            ((MediaView) holder.itemView).setOnDeleteMediaListener(this);
        } else {
            if (holder.itemView instanceof EmptyView) {
                ((EmptyView) holder.itemView).setAlert("图文并茂，辅以视频，\r\n让藏友看到更多亮点~");
                ((EmptyView) holder.itemView).setImage(R.drawable.ic_empty_default);
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (dataList == null || dataList.size() == 0) {
            return EMPTY;
        }
        if (position == dataList.size()) {
            return WHITE;
        }
        Media media = dataList.get(position);
        if (media == null) {
            return EMPTY;
        }
        return media.getType();
    }

    @Override
    public int getItemCount() {
        if (dataList == null || dataList.size() == 0) {
            //设置灰色背景
            rootView.setBackgroundResource(R.color.gray);
            return 1;
        }
        //设置白色背景
        rootView.setBackgroundResource(R.color.white);
        return dataList.size() + 1;
    }

    @Override
    public void onDelete(final MediaView view) {
        if(view==null)return;
        new AlertDialog.Builder(mContext)
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Media media = view.getMedia();
                int index = dataList.indexOf(media);
                dataList.remove(index);
                notifyItemRemoved(index);
            }
        }).setMessage("确认删除").create().show();
    }
}