package com.example.administrator.lapin.bean.laPingBean;

import java.util.List;

/**
 * Created by 鲁春 on 2016/12/6.
 */
public class LaPingHeaderViewBean {

    /**
     * success : true
     * message : null
     * content : [{"Title":"CONNER苹果磨砂手机壳8.8元白菜价","Url":"http://www.lapin365.com/item/005/909.htm","Picture":"/2016/12/05/20161205_120621_839.jpg","productid":5909,"newsid":0,"LastModifyTime":"2016-12-05T12:06:32"},{"Title":"南极人男士内裤4条礼盒装19.8元","Url":"http://www.lapin365.com/item/002/819.htm","Picture":"/2016/12/05/20161205_094051_366.jpg","productid":2819,"newsid":0,"LastModifyTime":"2016-12-05T09:41:00"},{"Title":"淘宝双12亲亲节红包购物券开抢","Url":"http://www.lapin365.com/item/004/902.htm","Picture":"/2016/12/02/20161202_053449_294.jpg","productid":4902,"newsid":0,"LastModifyTime":"2016-12-02T17:34:51"},{"Title":"三月松人体工学座椅（电脑椅/办公椅）169元起","Url":"http://www.lapin365.com/item/004/931.htm","Picture":"/2016/12/01/20161201_091407_384.png","productid":4931,"newsid":0,"LastModifyTime":"2016-12-01T21:14:18"},{"Title":"小清新学院风，尔旺纯色双肩包39元","Url":"http://www.lapin365.com/item/004/032.htm","Picture":"/2016/11/28/20161128_024247_759.png","productid":4032,"newsid":0,"LastModifyTime":"2016-11-28T14:42:54"}]
     */

    private boolean success;
    private Object message;
    /**
     * Title : CONNER苹果磨砂手机壳8.8元白菜价
     * Url : http://www.lapin365.com/item/005/909.htm
     * Picture : /2016/12/05/20161205_120621_839.jpg
     * productid : 5909
     * newsid : 0
     * LastModifyTime : 2016-12-05T12:06:32
     */

    private List<ContentBean> content;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public List<ContentBean> getContent() {
        return content;
    }

    public void setContent(List<ContentBean> content) {
        this.content = content;
    }

    public static class ContentBean {
        private String Title;
        private String Url;
        private String Picture;
        private int productid;
        private int newsid;
        private String LastModifyTime;

        public String getTitle() {
            return Title;
        }

        public void setTitle(String Title) {
            this.Title = Title;
        }

        public String getUrl() {
            return Url;
        }

        public void setUrl(String Url) {
            this.Url = Url;
        }

        public String getPicture() {
            return Picture;
        }

        public void setPicture(String Picture) {
            this.Picture = Picture;
        }

        public int getProductid() {
            return productid;
        }

        public void setProductid(int productid) {
            this.productid = productid;
        }

        public int getNewsid() {
            return newsid;
        }

        public void setNewsid(int newsid) {
            this.newsid = newsid;
        }

        public String getLastModifyTime() {
            return LastModifyTime;
        }

        public void setLastModifyTime(String LastModifyTime) {
            this.LastModifyTime = LastModifyTime;
        }
    }
}
