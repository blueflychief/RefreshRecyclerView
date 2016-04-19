package com.infinite.refreshrecyclerview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public class LoadingMoreFooter extends LinearLayout {

    private SimpleViewSwithcer progressCon;
    private Context mContext;
    public final static int STATE_LOADING = 0;
    public final static int STATE_COMPLETE = 1;
    public final static int STATE_NOMORE = 2;
    private TextView mText;

    public LoadingMoreFooter(Context context) {
        super(context);
        initView(context);
    }

    /**
     * @param context
     * @param attrs
     */
    public LoadingMoreFooter(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public void initView(Context context) {
        mContext = context;
        setGravity(Gravity.CENTER);
        setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        progressCon = new SimpleViewSwithcer(context);
        progressCon.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        progressCon.setView(new ProgressBar(mContext, null, android.R.attr.progressBarStyle));

        addView(progressCon);
        mText = new TextView(context);
        mText.setText("正在加载...");

        LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(10, 0, 0, 0);

        mText.setLayoutParams(layoutParams);
        addView(mText);
    }


    public void setState(int state) {
        switch (state) {
            case STATE_LOADING:
                progressCon.setVisibility(View.VISIBLE);
                mText.setText("正在刷新");
                this.setVisibility(View.VISIBLE);
                break;
            case STATE_COMPLETE:
                mText.setText("正在刷新");
                this.setVisibility(View.GONE);
                break;
            case STATE_NOMORE:
                mText.setText("没有更多");
                progressCon.setVisibility(View.GONE);
                this.setVisibility(View.VISIBLE);
                break;
        }

    }
}
