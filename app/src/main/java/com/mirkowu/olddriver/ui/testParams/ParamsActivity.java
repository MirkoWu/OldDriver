package com.mirkowu.olddriver.ui.testParams;

import android.view.WindowManager;

import com.mirkowu.olddriver.R;
import com.mirkowu.olddriver.databinding.ActivityParamsBinding;
import com.softgarden.baselibrary.base.BaseActivity;
import com.softgarden.baselibrary.utils.ToastUtil;
import com.softgarden.baselibrary.widget.CommonToolbar;

public class ParamsActivity extends BaseActivity<ParamsPresenter, ActivityParamsBinding> implements ParamsContract.Display {


    @Override
    protected int getLayoutId() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
        return R.layout.activity_params;
    }

    @Override
    protected CommonToolbar setToolbar() {
        return null;
    }

    @Override
    protected void initialize() {
        mPresenter.orderAdd();
    }

    @Override
    public void orderAdd(String orderId) {
        ToastUtil.s("成功--" + orderId);
    }
}
