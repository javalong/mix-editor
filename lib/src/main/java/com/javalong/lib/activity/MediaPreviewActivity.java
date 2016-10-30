package com.javalong.lib.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.javalong.lib.R;
import com.javalong.lib.bean.Media;
import com.javalong.lib.recyclerview.PreviewMediaRecyclerView;

import java.io.Serializable;
import java.util.List;

/**
 * Created by javalong on 2016/4/21.
 */
public class MediaPreviewActivity extends AppCompatActivity {

    private PreviewMediaRecyclerView rv_media;

    public static void toThisActivity(Context context,List<Media> mediaList) {
        Intent intent = new Intent();
        intent.setClass(context, MediaPreviewActivity.class);
        intent.putExtra("MediaList", (Serializable) mediaList);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mediapreview);
        initUI();
        initData();
    }

    protected void initUI() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.tb_tool);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        rv_media = (PreviewMediaRecyclerView) findViewById(R.id.rv_media);
    }

    protected void initData() {
        List<Media> mediaList = (List<Media>) getIntent().getSerializableExtra("MediaList");
        rv_media.initData(mediaList);
    }
}
