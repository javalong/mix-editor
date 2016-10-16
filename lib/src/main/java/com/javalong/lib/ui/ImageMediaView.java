package com.javalong.lib.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import com.javalong.lib.R;
import com.javalong.lib.bean.Media;
import com.javalong.lib.utils.DisplayUtils;

import java.io.IOException;


/**
 * Created by javalong on 2016/4/15.
 */
public class ImageMediaView extends MediaView implements View.OnClickListener {
    private ImageView iv_delete;
    protected ImageView iv_crop;
    private ImageView iv_image;

    public ImageMediaView(Context context) {
        super(context);
        init();
    }

    public ImageMediaView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mInflater.inflate(R.layout.view_imagemedia, this);
        iv_delete = (ImageView) findViewById(R.id.iv_delete);
        iv_crop = (ImageView) findViewById(R.id.iv_crop);
        iv_image = (ImageView) findViewById(R.id.iv_image);
        iv_delete.setOnClickListener(this);
        iv_crop.setOnClickListener(this);
        iv_image.setOnClickListener(this);
        initImageHeight();
    }

    /**
     * 设置图片比例 1242 * 524
     */
    private void initImageHeight() {
        int screenWidth = DisplayUtils.getOutMetrics(getContext()).widthPixels;
        int widthPixels = screenWidth - DisplayUtils.dip2px(getContext(), 10);
        int height = (int) (widthPixels * 524 / 1242.0);
        iv_image.getLayoutParams().height = height;
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.iv_delete) {
            delete();
        } else if (i == R.id.iv_image) {//首先判断有没图片有没裁剪，有裁剪，就显示裁剪内容
        }
    }

    public void initData(Media media) {
        super.initData(media);
        //TODO 隐藏裁剪按钮
        iv_crop.setVisibility(View.GONE);
        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), Uri.parse(media.getImagePath()));
            iv_image.setImageBitmap(bitmap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void deleteOk() {
        super.deleteOk();
    }
}
