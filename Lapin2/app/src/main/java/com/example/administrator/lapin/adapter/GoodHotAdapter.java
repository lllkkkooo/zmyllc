package com.example.administrator.lapin.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.lapin.R;
import com.example.administrator.lapin.bean.GoodHotBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2016/12/5.
 */
public class GoodHotAdapter extends BaseAdapter {

    private List<GoodHotBean.ContentBean> datas;
    private Context context;

    public GoodHotAdapter(List<GoodHotBean.ContentBean> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }

    @Override
    public int getCount() {
        return datas==null?0:datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if (convertView==null){
            viewHolder=new ViewHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.category_good_item,parent,false);
            viewHolder.txt= (TextView) convertView.findViewById(R.id.category_good_item_txt);
            viewHolder.iv= (ImageView) convertView.findViewById(R.id.category_good_item_iv);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.txt.setText(datas.get(position).getName());
        Picasso.with(context).load("http://img.lapin365.com/productpictures"+datas.get(position).getApplogo()).into(viewHolder.iv);
        return convertView;
    }
    class ViewHolder{
        TextView txt;
        ImageView iv;

    }
}
