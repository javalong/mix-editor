package com.javalong.lib.viewholder;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

/**
 * Created by javalong on 2015/12/16 0016.
 * 通用的viewholder
 */
public class ViewHolder extends RecyclerView.ViewHolder {

    private SparseArray<View> mViews;
    public ViewHolder(View itemView) {
        super(itemView);
        mViews = new SparseArray<>();
    }
    public <T extends View> T getView(int resId) {
        View view = mViews.get(resId);
        if (view == null) {
            view = itemView.findViewById(resId);
            mViews.put(resId, view);
        }
        return (T) view;
    }
}
