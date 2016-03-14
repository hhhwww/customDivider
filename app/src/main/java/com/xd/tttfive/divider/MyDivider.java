package com.xd.tttfive.divider;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by hhhhwei on 16/3/14.
 */
public class MyDivider extends RecyclerView.ItemDecoration {

    private static final int[] ATTRS = {android.R.attr.listDivider};
    private Drawable mDivider;

    //构造方法中初始化分割线图片
    public MyDivider(Context context) {
        //获取系统提供的分割线图片
        TypedArray typedArray = context.obtainStyledAttributes(ATTRS);
        Drawable drawable = typedArray.getDrawable(0);

        mDivider = drawable;
        typedArray.recycle();
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent) {
        //获取列表项距离左边缘的距离
        int left = parent.getPaddingLeft();

        //获取列表项距离右边缘的距离
        int right = parent.getWidth() - parent.getPaddingRight();

        //获取列表项的总数
        int count = parent.getChildCount();

        for (int i = 0; i < count; i++) {
            View child = parent.getChildAt(i);

            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) child.getLayoutParams();

            int top = child.getBottom() + layoutParams.bottomMargin;

            int bottom = top + mDivider.getIntrinsicHeight();

            mDivider.setBounds(left, top, right, bottom);

            mDivider.draw(c);
        }
    }
}
