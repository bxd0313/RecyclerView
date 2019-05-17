package com.bawei.zhoukao2moni1.mvp;

import android.content.Context;

import java.lang.ref.SoftReference;

/**
 * @Author：边旭东
 * @E-mail： bxd313@vip.qq.com
 * @Date： 2019/5/17 19:42
 * @Description：描述信息
 */
public class Presenter implements IContract.IPresenter {
     private Model model;
     private IContract.IView view;
     private SoftReference<IContract.IView> soft;
    @Override
    public void attach(IContract.IView view) {
        this.view=view;
        model=new Model();
      soft=new SoftReference<>(view);
    }

    @Override
    public void StartRequest(String json, Context context) {
     model.getData(json, context, new IContract.CallBack() {
         @Override
         public void setResponse(String response) {
             view.getData(response);
         }
     });
    }

    @Override
    public void detach() {
        if(soft!=null){
            soft.clear();
        }
        if(model!=null){
            model=null;
        }
    }
}
