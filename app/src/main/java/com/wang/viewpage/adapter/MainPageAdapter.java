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

    // 来判断显示的是否是同一View，这里我们将两个参数相比较返回即可
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    // 当要显示的图片可以进行缓存的时候，会调用这个方法进行显示图片的初始化，我们将要显示的ImageView加入到ViewGroup中，然后作为返回值返回即可
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(list.get(position));
        return list.get(position);
    }

    // PagerAdapter只缓存三张要显示的图片，如果滑动的图片超出了缓存的范围，就会调用这个方法，将图片销毁
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(list.get(position));
    }
}
