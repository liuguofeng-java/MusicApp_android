package io.music.app.ui.fragment;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;

import java.util.Map;

import butterknife.ButterKnife;
import io.music.app.R;
import io.music.app.base.BaseFragment;
import io.music.app.databinding.FragmentPageHomeBinding;
import io.music.app.ui.model.PageHome;
import io.music.app.ui.viewmodel.PageHomeViewModel;

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
    }

}