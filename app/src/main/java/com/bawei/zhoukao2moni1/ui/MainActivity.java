package com.bawei.zhoukao2moni1.ui;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.bawei.zhoukao2moni1.R;
import com.bawei.zhoukao2moni1.adapter.MyAdapter;
import com.bawei.zhoukao2moni1.base.BaseActivity;
import com.bawei.zhoukao2moni1.bean.JsonBean;
import com.bawei.zhoukao2moni1.mvp.IContract;
import com.bawei.zhoukao2moni1.mvp.Presenter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements IContract.IView {
     private RecyclerView recyclerView;
     private Presenter presenter;
     private String path="https://code.aliyun.com/598254259/FristProject/raw/master/bw_list.txt";
     private List<JsonBean.ItemsBean> mList=new ArrayList<>();
     private MyAdapter myAdapter;
    @Override
    public int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initControl() {
      recyclerView=findViewById(R.id.recycle);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
    }

    @Override
    public void initData() {
        myAdapter=new MyAdapter(mList,this);
        recyclerView.setAdapter(myAdapter);
        presenter=new Presenter();
        presenter.attach(this);
        presenter.StartRequest(path,MainActivity.this);

    }

    @Override
    public void initListener() {
      myAdapter.setItemClick(new MyAdapter.ItemClick() {
          @Override
          public void setItemClick(View view, int position) {
              Toast.makeText(MainActivity.this,mList.get(position).title,Toast.LENGTH_SHORT).show();
          }
      });
    }

    @Override
    public void getData(String json) {
        Gson gson=new Gson();
        JsonBean jsonBean = gson.fromJson(json, JsonBean.class);
        mList.addAll(jsonBean.items);
        myAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }
}
