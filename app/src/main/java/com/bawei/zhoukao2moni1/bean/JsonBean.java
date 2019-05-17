package com.bawei.zhoukao2moni1.bean;

import java.util.List;

/**
 * @Author：边旭东
 * @E-mail： bxd313@vip.qq.com
 * @Date： 2019/5/17 14:07
 * @Description：描述信息
 */
public class JsonBean {

    public List<ItemsBean> items;

    public static class ItemsBean {

        public int type;
        public String title;
        public String image;
        public List<Images> images;

       public class Images{
          public String pic;
       }

    }
}
