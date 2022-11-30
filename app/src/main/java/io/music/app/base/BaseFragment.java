package io.music.app.base;

import androidx.fragment.app.Fragment;

import io.music.app.common.util.ToastUtil;

/**
 * @author liuguofeng
 * @date 2022/11/15 17:29
 **/
public class BaseFragment extends Fragment {


    /**
     * 在顶部弹窗Toast
     * @param message Toast 内容
     */
    protected void showToastTop(String message){
        ToastUtil.showToastTop(this.getActivity(), message);
    }

    /**
     * 在中心弹窗Toast
     * @param message Toast 内容
     */
    protected void showToastCenter(String message){
        ToastUtil.showToastCenter(this.getActivity(), message);
    }

    /**
     * 在底部弹窗Toast
     * @param message Toast 内容
     */
    protected void showToastBottom(String message){
        ToastUtil.showToastBottom(this.getActivity(), message);
    }

}
