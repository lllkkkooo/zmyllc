package com.example.administrator.lapin.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.lapin.R;
import com.example.administrator.lapin.bean.GoodDetailsBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2016/12/6.
 */
public class GoodDetailsAdapter extends BaseAdapter {
private List<GoodDetailsBean.ContentBean>datas;
    private Context context;

    public GoodDetailsAdapter(List<GoodDetailsBean.ContentBean> datas, Context context) {
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
        Viewholder viewholder=null;
        if (convertView==null){
            viewholder=new Viewholder();
            convertView= LayoutInflater.from(context).inflate(R.layout.good_category2_item,parent,false);
            viewholder.infoTxt= (TextView) convertView.findViewById(R.id.good_category2_item_info);
            viewholder.nameTxt= (TextView) convertView.findViewById(R.id.good_category2_item_productname);
            viewholder.storeTxt= (TextView) convertView.findViewById(R.id.good_category2_item_storeName);
            viewholder.timeTxt= (TextView) convertView.findViewById(R.id.good_category2_item_time);
         viewholder.pictureIv= (ImageView) convertView.findViewById(R.id.good_category2_item_picture);
            convertView.setTag(viewholder);

        }else {
            viewholder= (Viewholder) convertView.getTag();
        }
        viewholder.nameTxt.setText(datas.get(position).getProductName());
        String str=datas.get(position).getCreateTime();
        viewholder.timeTxt.setText(str.substring(str.indexOf("T")+1,str.lastIndexOf(":")));
        viewholder.storeTxt.setText(datas.get(position).getOriginStoreName()+"/");
        viewholder.infoTxt.setText(datas.get(position).getPromotionInfo());
        Picasso.with(context).load("http://img.lapin365.com/productpictures"+datas.get(position).getPicture()).placeholder(R.mipmap.ic_launcher).into(viewholder.pictureIv);
        return convertView;
    }
    class  Viewholder{
        TextView nameTxt,infoTxt,timeTxt,storeTxt;
        ImageView pictureIv;
    }
}
