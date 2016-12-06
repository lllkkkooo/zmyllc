package com.example.administrator.lapin.utils;

/**
 * Created by 鲁春 on 2016/12/5.
 */
public class Url {
    //获取辣品-全部-头部的viewpager
    public static String getLaPinHeader(int type){
        String header=null;
        if(type==0) {
             header = "http://api.lapin365.com/";
        }else if(type==1){
             header="api/lapinapp/focus";
        }
        return  header;
    }
    //今日爆品：
    public static String getTodayBaoPin(){
        String baoPin="http://api.lapin365.com/api/lapinapp/todaybest";
        return baoPin;
    }
    //往期之星：
    public static String getWangQi(){
        String WangQi="http://api.lapin365.com/api/lapinapp/tag?tag=%E7%88%86%E5%93%81&count=10";
        return WangQi;
    }
    //精选：
    public static String getJingQuan(){
        String JingQuan=" http://api.lapin365.com/api/lapinapp/indexlistsegbyid?count=20";
        return JingQuan;
    }
    //辣榜：
    public static String getLaBang(){
        String getLaBang="http://api.lapin365.com/api/lapinapp/tag?tag=%E7%88%86%E5%93%81&count=20";
        return getLaBang;
    }
    //1元包邮：
    public static String getOneYuan(){
        String OneYuan="http://api.lapin365.com/api/lapinapp/tag?tag=1%E5%85%83&count=20";
        return OneYuan;
    }
    //白菜价：
    public static String getBaiCai(){
        String BaiCai="http://api.lapin365.com/api/lapinapp/tag?tag=%E7%99%BD%E8%8F%9C%E4%BB%B7&count=20";
        return BaiCai;
    }
    //福包：
    public static String getFuBao(){
        String fuBao="http://api.lapin365.com/api/lapinapp/tag?tag=%E7%A6%8F%E5%88%A9&count=20";
        return fuBao;
    }
    //分类页面

    //商品分类
    public static String allcategory(){
        String allcategory="http://api.lapin365.com/api/lapinapp/allcategory";
        return allcategory;
    }
    //    二级页面：catid是一级页面获得的id加进去的
    //    http://api.lapin365.com/api/lapinapp/search?count=20&catid=?&ip=10.0.3.15&platform=android&userid=
    public static String getCategoryTwoPage(String id){
        String twoPage="http://api.lapin365.com/api/lapinapp/search?count=20&catid="+id+"&ip=10.0.3.15&platform=android&userid=";
        return  twoPage;
    }
    //    热门商城：
//    http://api.lapin365.com/api/lapinapp/malllist
    public static String malllist(){
        String malllist="http://api.lapin365.com/api/lapinapp/malllist";
        return malllist;
    }
    //    二级页面：malltoken是一级页面获得的Token加进去的
//    http://api.lapin365.com/api/lapinapp/malldetail?malltoken=？&count=20
    public static String getMalltokenTwoPage(String token){
        String malllistTwoPage="http://api.lapin365.com/api/lapinapp/malldetail?malltoken="+token+"&count=20";
        return  malllistTwoPage;
    }
    //    如果两者一起检索，那么接口是：	mallid是热门商城获得的id，catid是商品分类获得的id加进去的
    //    http://api.lapin365.com/api/lapinapp/search?count=20&mallid=7&catid=52&ip=10.0.3.15&platform=android&userid=
    public static String allSearch(String mallid,String catid){
        String path=" http://api.lapin365.com/api/lapinapp/search?count=20&mallid="
                +mallid+"&catid="+catid+"&ip=10.0.3.15&platform=android&userid=";
        return path;
    }
    //    三级页面：productid是具体商品的productid
    //    http://api.lapin365.com/api/lapinapp/detail?productid=6009&platform=android
    public static String threePage(String productid){
        String threePage="http://api.lapin365.com/api/lapinapp/detail?productid="+productid+"&platform=android";
        return threePage;
    }
    //    三级页面下的猜你喜欢：remove是具体商品的productid
    //    http://api.lapin365.com/api/lapinapp/douzaimai?count=5&remove=6009
    public static String threePageGuess(String remove){
        String guess="http://api.lapin365.com/api/lapinapp/douzaimai?count=5&remove="+remove;
        return guess;
    }
    public static  String getImg(){
        String imgHeader="http://img.lapin365.com/productpictures/";
        return imgHeader;
    }
}
