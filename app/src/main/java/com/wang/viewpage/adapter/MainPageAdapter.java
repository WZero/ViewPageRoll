package com.wang.viewpage.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * 作者： Wang
 * 时间： 2016/6/20
 */
public class MainPageAdapter extends PagerAdapter {
    List<View> list;
    Context context;

    public MainPageAdapter(List<View> list, Context context) {
        this.list = list;
        this.context = context;
    }

    // 获取要滑动的控件的数量
    @Override
    public int getCount() {
        return list.size();
    }

    // 来判断显示的是否是同一View，这里我们将两个参数相比较
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    // 将要显示的View加入到ViewGroup中，然后作为返回值
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(list.get(position));
        return list.get(position);
    }

    // 销毁缓存中的View
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(list.get(position));
    }
}
