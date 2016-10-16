package com.javalong.lib.ui;

import android.content.Context;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.javalong.lib.R;
import com.javalong.lib.bean.Media;
import com.javalong.lib.utils.ToastUtils;
import com.javalong.lib.utils.ViewUtils;

/**
 * Created by javalong on 2016/4/15.
 * 图文编辑文本
 */
public class TextMediaView extends MediaView implements View.OnClickListener, View.OnFocusChangeListener {
    private final static String TEXT_LENGTH_ALERT = "最多只能输入500字哦";
    private EditText et_desc;
    private ImageView iv_delete;
    private ImageView iv_ok;
    private View mask;
    public TextMediaView(Context context) {
        super(context);
        init();
    }

    public TextMediaView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mInflater.inflate(R.layout.view_textmedia, this);
        et_desc = (EditText) findViewById(R.id.et_desc);
        iv_delete = (ImageView) findViewById(R.id.iv_delete);
        iv_ok = (ImageView) findViewById(R.id.iv_ok);
        mask = findViewById(R.id.mask);
        iv_delete.setOnClickListener(this);
        iv_ok.setOnClickListener(this);
        et_desc.setOnFocusChangeListener(this);
        et_desc.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 500) {
                    ToastUtils.showToast(getContext(), TEXT_LENGTH_ALERT);
                }
            }
        });
        iv_ok.setScaleY(0);
        iv_ok.setScaleX(0);

        mask.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mask.setClickable(false);
                et_desc.requestFocus();
                ViewUtils.showKeyboard(et_desc, getContext());
            }
        });
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus) {
            showOk();
            mask.setClickable(false);
        } else {
            //失去焦点时，保存下当前的内容
            media.setDesc(et_desc.getText().toString());
            hideOk();
            mask.setClickable(true);
        }
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.iv_delete) {
            delete();

        } else if (i == R.id.iv_ok) {
            onOkClick();

        }
    }

    private void onOkClick() {
        if (et_desc.getText().length() > 500) {
            ToastUtils.showToast(getContext(),TEXT_LENGTH_ALERT);
        } else {
            ViewUtils.hideKeyboard(et_desc, getContext());
            et_desc.clearFocus();
            media.setDesc(et_desc.getText().toString());
            setFocusable(true);
            setFocusableInTouchMode(true);
        }
    }

    private void hideOk() {
        ViewCompat.animate(iv_ok).scaleX(0).scaleY(0).setDuration(500).start();
    }

    private void showOk() {
        ViewCompat.animate(iv_ok).scaleX(1).scaleY(1).setDuration(500).start();
    }

    @Override
    public void initData(Media media) {
        super.initData(media);
        if (media.isNew()) {
            //如果是刚刚添加的 就去获取焦点
            et_desc.requestFocus();
        }
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (media != null && media.getDesc() != null) {
            et_desc.setText(media.getDesc());
        } else {
            et_desc.setText("");
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        media.setDesc(et_desc.getText().toString());
    }
    
}
