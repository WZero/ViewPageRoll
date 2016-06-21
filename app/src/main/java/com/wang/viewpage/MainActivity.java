package com.wang.viewpage;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.wang.viewpage.adapter.MainPageAdapter;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager pager;
    private MainPageAdapter adapter;
    private List<View> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager = (ViewPager) findViewById(R.id.main_page);
        if (pager == null) return;
        // pageCount设置红缓存的页面数
        pager.setOffscreenPageLimit(3);
        // 设置2张图之前的间距。
        pager.setPageMargin(20);
        list = new ArrayList<>();
        String[] strings = {"123", "456", "789", "147", "258", "369"};
        addView(strings);
        adapter = new MainPageAdapter(list, getApplicationContext());
        pager.setAdapter(adapter);
        pager.setCurrentItem(0);
        pager.setPageMargin(100);
    }

    private void addView(String[] strings) {
        for (String str : strings) {
            View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.main_item, null);
            TextView textView = (TextView) view.findViewById(R.id.item_text);
            textView.setText(str);
            list.add(view);
        }
    }
}
