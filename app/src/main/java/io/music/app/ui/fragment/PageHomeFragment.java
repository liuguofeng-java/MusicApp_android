package io.music.app.ui.fragment;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;

import org.greenrobot.eventbus.EventBus;

import java.util.Map;
import java.util.Objects;

import butterknife.ButterKnife;
import io.music.app.R;
import io.music.app.base.BaseFragment;
import io.music.app.common.enevt.EventEntity;
import io.music.app.common.enevt.ServiceEvent;
import io.music.app.databinding.FragmentPageHomeBinding;
import io.music.app.ui.model.PageHome;
import io.music.app.ui.viewmodel.PageHomeViewModel;
import io.music.app.view.BannerLayout;

/**
 * 主页
 */
public class PageHomeFragment extends BaseFragment {

    private FragmentPageHomeBinding binding;

    private PageHomeViewModel viewModel;


    public static PageHomeFragment newInstance() {
        return new PageHomeFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_page_home, container, false);
        View root = binding.getRoot();
        ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(PageHomeViewModel.class);
        //Model → View ,初始化
        PageHome model = new PageHome();

        viewModel.getPageHome().setValue(model);
        //获取观察对象
        MutableLiveData<PageHome> modelPageHome = viewModel.getPageHome();
        modelPageHome.observe(this.requireActivity(), pageHome -> {
            binding.setViewModel(viewModel);
        });
        viewModel.getBanner();
        initEvent();
    }


    /**
     * 初始化事件
     */
    public void initEvent() {
        //打开侧边菜单
        binding.homeLeftMenuBut.setOnClickListener((v) -> {
            EventEntity<Integer> eventEntity = new EventEntity<Integer>(){{
                setServiceId(ServiceEvent.SHOW_LEFT_NAV);
            }};
            EventBus.getDefault().post(eventEntity);
        });
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (viewModel == null) return;
        if (isVisibleToUser) {
            BannerLayout.startTimer(binding.homeBanner);
        } else {
            BannerLayout.stopTimer(binding.homeBanner);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        BannerLayout.startTimer(binding.homeBanner);
    }

    @Override
    public void onStop() {
        super.onStop();
        // 关闭轮播图自动轮播
        BannerLayout.stopTimer(binding.homeBanner);
    }
}