package com.example.administrator.lapin.adapter.laPingAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.lapin.R;
import com.example.administrator.lapin.bean.laPingBean.TodayBaoPing;
import com.example.administrator.lapin.utils.Url;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by 鲁春 on 2016/12/6.
 */
public class TodayBaoPingRecyclerviewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<TodayBaoPing.ContentBean> todayList;
    private Context context;
    private RecyclerView mRecyclerview;
    public TodayBaoPingRecyclerviewAdapter(List<TodayBaoPing.ContentBean> todayList,Context context){
        this.todayList=todayList;
        this.context=context;
    }
    public void addData(List<TodayBaoPing.ContentBean> list){
        todayList.addAll(list);
        notifyDataSetChanged();
    }
    private recyclerviewCallBack recyclerviewCallBack;
    public void setOnClick(recyclerviewCallBack recyclerviewCallBack){
        this.recyclerviewCallBack=recyclerviewCallBack;
    }
    public  interface recyclerviewCallBack{
        void setOnClick(View view,int position);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.mRecyclerview=recyclerView;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view= LayoutInflater.from(context).inflate(R.layout.baoping_wangqi_item,parent,false);
        int pos=mRecyclerview.getChildAdapterPosition(view);
       if(pos==0){
           view.setPadding(0,0,3,0);
       }else if(pos==todayList.size()-1){
           view.setPadding(3,0,0,0);
       }else{
           view.setPadding(3,0,3,0);
       }
        final ViewHolderBaoPing holderBaoPing=new ViewHolderBaoPing(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerviewCallBack.setOnClick(v,holderBaoPing.getAdapterPosition());
            }
        });
        return holderBaoPing;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        TodayBaoPing.ContentBean contentBean=todayList.get(position);
        String productName=contentBean.getProductName();
        String promotionInfo=contentBean.getPromotionInfo();
        String img= Url.getImg()+contentBean.getPicture();
        if(!TextUtils.isEmpty(productName)){
            ((ViewHolderBaoPing)holder).title.setText(productName);
        }
        if(!TextUtils.isEmpty(promotionInfo)){
            ((ViewHolderBaoPing)holder).price.setText(promotionInfo);
        }
        if(!TextUtils.isEmpty(img)){
            Picasso.with(context).load(img).placeholder(R.mipmap.thumbnail)
                    .into(((ViewHolderBaoPing)holder).img);
        }

    }

    @Override
    public int getItemCount() {
        return todayList!=null?todayList.size():0;
    }

    public static class ViewHolderBaoPing extends RecyclerView.ViewHolder{
        ImageView img;
        TextView title;
        TextView price;
        public ViewHolderBaoPing(View itemView) {
            super(itemView);
            img= (ImageView) itemView.findViewById(R.id.baoping_wangqi_item_img);
            title= (TextView) itemView.findViewById(R.id.baoping_wangqi_item_title);
            price= (TextView) itemView.findViewById(R.id.baoping_wangqi_item_price);
        }
    }
}
