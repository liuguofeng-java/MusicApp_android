package io.music.app.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

/**
 * 页面滑动
 * @author liuguofeng
 * @date 2022/12/06 20:56
 **/
public class ContentPagerAdapter extends FragmentPagerAdapter {
    private final List<Fragment> data;

    public ContentPagerAdapter(@NonNull FragmentManager fragmentActivity, List<Fragment> data) {
        super(fragmentActivity);
        this.data = data;
    }



    @NonNull
    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data.size();
    }
}
