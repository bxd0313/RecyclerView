package com.bawei.zhoukao2moni1.mvp;

import android.content.Context;

import com.bawei.zhoukao2moni1.util.VolleyUtil;

/**
 * @Author：边旭东
 * @E-mail： bxd313@vip.qq.com
 * @Date： 2019/5/17 19:41
 * @Description：描述信息
 */
public class Model implements IContract.IModel {

    @Override
    public void getData( String json, Context context, final IContract.CallBack callBack) {
        VolleyUtil.getInstance().getUrl(json, context, new VolleyUtil.VolleyCallBack() {
            @Override
            public void response(String jsonStr) {
                callBack.setResponse(jsonStr);
            }
        });
    }
}
