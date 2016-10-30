package com.javalong.lib.bean;

import android.graphics.Bitmap;

import java.io.Serializable;

/**
 * Created by javalong on 2016/4/15.
 */
public class Media implements Serializable {

    public enum Type {
        TEXT(0), IMAGE(1),PREVIEW(2);

        private int type;

        Type(int type) {
            this.type = type;
        }
        public int getType() {
            return type;
        }
    }
    private int type; //0文本 1图片 2视频 11贴子标签
    private String desc;
    private String imagePath; //图片本地uri地址
    private String imgUrl;//图片远程路径，上传后，重新编辑使用
    private Double cropx;
    private Double cropy;
    private Double cropWidth;
    private Double cropHeight;
    private transient boolean isNew;//是否刚刚，添加的，用来获取焦点
    // 剪切后的bitmap
    private transient Bitmap cropBitmap;

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public Bitmap getCropBitmap() {
        return cropBitmap;
    }

    public void setCropBitmap(Bitmap cropBitmap) {
        this.cropBitmap = cropBitmap;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Double getCropx() {
        if (cropx == null) {
            return 0.0;
        }
        return cropx;
    }

    public void setCropx(Double cropx) {
        this.cropx = cropx;
    }

    public Double getCropy() {
        if (cropy == null) {
            return 0.0;
        }
        return cropy;
    }

    public void setCropy(Double cropy) {
        this.cropy = cropy;
    }

    public Double getCropWidth() {
        if (cropWidth == null) {
            return 0.0;
        }
        return cropWidth;
    }

    public void setCropWidth(Double cropWidth) {
        this.cropWidth = cropWidth;
    }

    public Double getCropHeight() {
        if (cropHeight == null) {
            return 0.0;
        }
        return cropHeight;
    }

    public void setCropHeight(Double cropHeight) {
        this.cropHeight = cropHeight;
    }

    public Media(int type) {
        this.type = type;
    }

}
