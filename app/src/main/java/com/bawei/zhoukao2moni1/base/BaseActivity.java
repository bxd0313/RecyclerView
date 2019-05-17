package com.bawei.zhoukao2moni1.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @Author：边旭东
 * @E-mail： bxd313@vip.qq.com
 * @Date： 2019/5/16 21:25
 * @Description：描述信息
 */
public abstract class BaseActivity extends AppCompatActivity {
    //初始化布局
    public abstract int initLayout();
    //初始化控件
    public abstract void initControl();
    //初始化数据
    public abstract void initData();
    //初始化监听
    public abstract void initListener();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        initControl();
        initData();
        initListener();
    }
}
