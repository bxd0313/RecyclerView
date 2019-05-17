package com.bawei.zhoukao2moni1.mvp;

import android.content.Context;

/**
 * @Author：边旭东
 * @E-mail： bxd313@vip.qq.com
 * @Date： 2019/5/17 19:34
 * @Description：描述信息
 */
public interface IContract {
    interface IView{
        void getData(String json);
    }
    interface IModel{
        void getData(String json, Context context,CallBack callBack);
    }
    interface IPresenter{
        void attach(IView view);
        void StartRequest(String json,Context context);
        void detach();
    }
    interface CallBack{
        void setResponse(String response);
    }
}
