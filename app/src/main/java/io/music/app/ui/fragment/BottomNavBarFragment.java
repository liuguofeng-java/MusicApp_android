package io.music.app.ui.fragment;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;
import io.music.app.R;
import io.music.app.base.BaseFragment;
import io.music.app.common.enevt.ServiceEvent;
import io.music.app.databinding.FragmentBottomNavBarBinding;
import io.music.app.common.enevt.EventEntity;
import io.music.app.ui.model.BottomNavBar;
import io.music.app.ui.viewmodel.BottomNavBarViewModel;
import io.music.app.view.BottomNavBarItemLayout;

/**
 * 底部导航逻辑
 */
public class BottomNavBarFragment extends BaseFragment {

    private FragmentBottomNavBarBinding binding;

    private BottomNavBarViewModel viewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_bottom_nav_bar, container, false);
        View root = binding.getRoot();
        ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(BottomNavBarViewModel.class);
        //Model → View ,初始化
        BottomNavBar model = new BottomNavBar();
        List<BottomNavBar.BottomNavBarItem> items = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            BottomNavBar.BottomNavBarItem item = new BottomNavBar.BottomNavBarItem();
            if(i == 0){
                item.setSelect(true);
            }
            if(i == 3){
                item.setMsg(true);
            }
            items.add(item);
        }
        model.setBottomNavBarItems(items);
        viewModel.getBar().setValue(model);
        //获取观察对象
        MutableLiveData<BottomNavBar> modelBar = viewModel.getBar();
        modelBar.observe(this.requireActivity(), bar -> {
            binding.setViewModel(viewModel);
        });
    }


    @OnClick({R.id.bar_home, R.id.bar_podcast, R.id.bar_account,
            R.id.bar_concern, R.id.bar_community})
    public void OnClick(View view) {
        EventEntity<Integer> eventEntity = new EventEntity<Integer>();
        switch (view.getId()) {
            case R.id.bar_home:
                eventEntity.setData(0);
                break;
            case R.id.bar_podcast:
                eventEntity.setData(1);
                break;
            case R.id.bar_account:
                eventEntity.setData(2);
                break;
            case R.id.bar_concern:
                eventEntity.setData(3);
                break;
            case R.id.bar_community:
                eventEntity.setData(4);
                break;
        }
        eventEntity.setServiceId(ServiceEvent.BOTTOM_TAB_BAR.getCode());
        EventBus.getDefault().post(eventEntity);
        clearBar(eventEntity.getData());
    }


//    public static void setBarIsSelect(BottomNavBarItemLayout view, boolean isSelect){
//        view.setBarIsSelect(isSelect);
//    }
//
//
//    public static void setBarMsg(BottomNavBarItemLayout view, boolean isMsg){
//        view.setBarMsg(isMsg);
//    }

    /**
     * 清除状态
     * @param index 点击下标
     */
    public void clearBar(int index) {
        //当前菜单选择
        BottomNavBar bottomNavBar = binding.getViewModel().getBar().getValue();
        assert bottomNavBar != null;
        List<BottomNavBar.BottomNavBarItem> items = bottomNavBar.getBottomNavBarItems();
        for (BottomNavBar.BottomNavBarItem bottomNavBarItem : items) {
            if(bottomNavBarItem.isSelect())
                bottomNavBarItem.setSelect(false);
        }
        items.get(index).setSelect(true);

    }


}