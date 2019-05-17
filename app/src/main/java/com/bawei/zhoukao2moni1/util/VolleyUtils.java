package com.bawei.zhoukao2moni1.util;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Map;

/**
 * @Author：边旭东
 * @E-mail： bxd313@vip.qq.com
 * @Date： 2019/5/17 19:29
 * @Description：描述信息
 */
public class VolleyUtils {
    private static final VolleyUtils ourInstance = new VolleyUtils();

    public static VolleyUtils getInstance() {
        return ourInstance;
    }

    private VolleyUtils() {
    }

    public void get(String url, Context context, final VolleyCallBack callBack){
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callBack.response(response);
            }
        },null);
        requestQueue.add(stringRequest);
    }
    public void Post(String url, Context context, final Map<String,String> map, final VolleyCallBack callBack){
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callBack.response(response);
            }
        },null){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return map;
            }
        };
        requestQueue.add(stringRequest);
    }


    public interface VolleyCallBack {
        void response(String jsonStr);
    }
}
