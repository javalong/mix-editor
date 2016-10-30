package com.javalong.lib.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.javalong.lib.R;
import com.javalong.lib.bean.Media;
import com.javalong.lib.utils.DisplayUtils;
import com.javalong.lib.utils.StringUtils;

import java.io.IOException;

/**
 * Created by javalong on 2016/4/21.
 * 图片预览
 */
public class ImageMediaPreviewView extends MediaPreviewView {
    private ImageView iv_image;
    private Media media;

    public ImageMediaPreviewView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ImageMediaPreviewView(Context context) {
        super(context);
        init();
    }

    private void init() {
        mInflater.inflate(R.layout.view_imagemedia_preview, this);
        iv_image = (ImageView) findViewById(R.id.iv_image);
        int widthPixels = DisplayUtils.getOutMetrics(getContext()).widthPixels;
    }

    @Override
    public void initData(Media media) {
        super.initData(media);
        this.media = media;
        //如果有远程下载地址，就加载远程图片
        if (!StringUtils.isEmpty(media.getImagePath())) {
            //TODO  如果预览效果卡顿，就在这把图片压缩下再显
            try{
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(),Uri.parse(media.getImagePath()));
                iv_image.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            //TODO 如果有远程的地址，就加载远程图片
        }
    }



}
