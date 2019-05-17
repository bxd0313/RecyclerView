package com.bawei.zhoukao2moni1.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.zhoukao2moni1.R;
import com.bawei.zhoukao2moni1.bean.JsonBean;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * @Author：边旭东
 * @E-mail： bxd313@vip.qq.com
 * @Date： 2019/5/17 19:53
 * @Description：描述信息
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {
    private List<JsonBean.ItemsBean> list;
    private Context context;

    public MyAdapter(List<JsonBean.ItemsBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=View.inflate(context,R.layout.item,null);
        Holder holder=new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final Holder holder, final int i) {
            Glide.with(context).load(list.get(i).image).into(((Holder) holder).image);
            ((Holder) holder).text.setText(list.get(i).title);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClick.setItemClick(holder.itemView,i);
                }
            });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
    class Holder extends RecyclerView.ViewHolder{
         private ImageView image;
         private TextView text;
        public Holder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.image);
            text=itemView.findViewById(R.id.text);
        }
    }

  public interface ItemClick{
        void setItemClick(View view,int position);
    }
    private ItemClick itemClick;

    public void setItemClick(ItemClick itemClick) {
        this.itemClick = itemClick;
    }
}
