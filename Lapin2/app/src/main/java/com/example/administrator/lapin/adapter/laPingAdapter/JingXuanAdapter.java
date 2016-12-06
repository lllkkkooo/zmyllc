package com.example.administrator.lapin.adapter.laPingAdapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.lapin.R;
import com.example.administrator.lapin.bean.laPingBean.JingXuanBean;
import com.example.administrator.lapin.utils.Url;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by 鲁春 on 2016/12/6.
 */
public class JingXuanAdapter extends BaseAdapter{
    private List<JingXuanBean.ContentBean> jingxuanList;
    private Context context;
    private LayoutInflater mLayoutInflater;
    public JingXuanAdapter(List<JingXuanBean.ContentBean> jingxuanList,Context context){
        this.jingxuanList=jingxuanList;
        this.context=context;
        mLayoutInflater=LayoutInflater.from(context);
    }
    public void addData(List<JingXuanBean.ContentBean> list){
        jingxuanList.addAll(list);
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return jingxuanList!=null?jingxuanList.size():0;
    }

    @Override
    public JingXuanBean.ContentBean getItem(int position) {
        return jingxuanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolderJingXuan holderJingXuan=null;
        if(convertView==null){
            convertView=mLayoutInflater.inflate(R.layout.jingxuan_item,parent,false);
            holderJingXuan=new ViewHolderJingXuan(convertView);
            convertView.setTag(holderJingXuan);
        }else{
           holderJingXuan= (ViewHolderJingXuan) convertView.getTag();
        }
        JingXuanBean.ContentBean contentBean=jingxuanList.get(position);
        String img= Url.getImg()+contentBean.getPicture();
        String name=contentBean.getProductName();
        String price=contentBean.getPromotionInfo();
        String originStoreName=contentBean.getOriginStoreName();
        String createTime=contentBean.getCreateTime();
        if(!TextUtils.isEmpty(img)){
            Picasso.with(context).load(img).placeholder(R.mipmap.thumbnail).into(holderJingXuan.img);
        }
        if(!TextUtils.isEmpty(name)){
            holderJingXuan.name.setText(name);
        }
        if(!TextUtils.isEmpty(price)){
            holderJingXuan.price.setText(price);
        }
        if(!TextUtils.isEmpty(originStoreName)){
            holderJingXuan.originStoreName.setText(originStoreName);
        }
        if(!TextUtils.isEmpty(createTime)){
            int pos=createTime.indexOf("T");
            String timePos=createTime.substring(pos+1,pos+6);
            holderJingXuan.createTime.setText(timePos);
        }
        return convertView;
    }
    class ViewHolderJingXuan{
        ImageView img;
        TextView name;
        TextView price;
        TextView originStoreName;
        TextView createTime;
        public ViewHolderJingXuan(View view){
            img= (ImageView) view.findViewById(R.id.jingxuan_item_img);
            name= (TextView) view.findViewById(R.id.jingxuan_item_name);
            price= (TextView) view.findViewById(R.id.jingxuan_item_price);
            originStoreName= (TextView) view.findViewById(R.id.jingxuan_item_OriginStoreName);
            createTime= (TextView) view.findViewById(R.id.jingxuan_item_CreateTime);
        }
    }
}
