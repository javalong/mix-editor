package com.javalong.lib.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.javalong.lib.R;
import com.javalong.lib.bean.Media;
import com.javalong.lib.recyclerview.EditMediaRecyclerView;
import com.javalong.lib.ui.MediaBottomLayout;
import com.javalong.lib.utils.ViewUtils;

import java.util.ArrayList;

/**
 * Created by javalong on 2016/4/18.
 */
public class EditMediaActivity extends AppCompatActivity implements MediaBottomLayout.OnMediaButtonClickListener{

    private EditMediaRecyclerView rv_media;
    private MediaBottomLayout layout_bottom;

    public static void toThisActivity(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, EditMediaActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mediaedit);
        initUI();
        initData();
    }

    protected void initUI() {
        rv_media = (EditMediaRecyclerView) findViewById(R.id.rv_media);
        layout_bottom = (MediaBottomLayout) findViewById(R.id.layout_bottom);
    }

    protected void initData() {
        layout_bottom.setOnMediaButtonClickListener(this);
    }

    @Override
    public void onMediaButtonClick(Media.Type type) {
        switch (type) {
            case TEXT:
                Media textMedia = new Media(Media.Type.TEXT.ordinal());
                textMedia.setNew(true);
                rv_media.addMedia(textMedia);
                break;
            case IMAGE:
                ViewUtils.openGallery(this,100);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            if(requestCode == 100){
                Media imageMedia = new Media(Media.Type.IMAGE.ordinal());
                imageMedia.setImagePath(data.getData().toString());
                rv_media.addMedia(imageMedia);
            }
        }
    }
}
