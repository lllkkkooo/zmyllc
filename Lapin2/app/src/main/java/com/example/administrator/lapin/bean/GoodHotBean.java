package com.example.administrator.lapin.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/12/5.
 */
public class GoodHotBean {

    /**
     * success : true
     * message : null
     * content : [{"Name":"淘宝","Token":"taobao","OnlineUrl":"","SiteUrl":"www.taobao.com","Abstract":null,"Logo":"","Applogo":"/2016/11/26/20161126_052803_480.png","Enabled":true,"SeqTime":"2016-11-26T16:42:36","Id":17,"IsDel":false,"CreateTime":"2016-11-26T17:28:05.263","CreateMan":null,"DelTime":"1753-01-01T00:00:00","DelMan":null},{"Name":"QQ","Token":"QQ","OnlineUrl":"","SiteUrl":"http://pay.qq.com/","Abstract":null,"Logo":"","Applogo":"/2016/11/24/20161124_071542_980.png","Enabled":true,"SeqTime":"2016-11-24T16:58:03","Id":16,"IsDel":false,"CreateTime":"2016-11-27T10:36:22.297","CreateMan":null,"DelTime":"1753-01-01T00:00:00","DelMan":null},{"Name":"微店","Token":"weidian","OnlineUrl":"","SiteUrl":"https://www.weidian.com/","Abstract":"微店官网 - 手机开店用微店","Logo":"","Applogo":"/2016/09/28/20160928_052121_222.png","Enabled":true,"SeqTime":"2016-09-27T17:49:57","Id":14,"IsDel":false,"CreateTime":"2016-09-28T17:21:24.417","CreateMan":null,"DelTime":"1753-01-01T00:00:00","DelMan":null},{"Name":"微软商城","Token":"microsoft","OnlineUrl":"","SiteUrl":"http://www.microsoft.com/","Abstract":"微软官网 | 微软中国官方商城","Logo":"","Applogo":"/2016/09/28/20160928_052509_273.png","Enabled":true,"SeqTime":"2016-03-11T11:35:16","Id":2,"IsDel":false,"CreateTime":"2016-11-27T10:35:51.93","CreateMan":null,"DelTime":"1753-01-01T00:00:00","DelMan":null},{"Name":"天猫","Token":"tmall","OnlineUrl":"","SiteUrl":"http://www.tmall.com/","Abstract":"天猫tmall.com - 上天猫，就够了。","Logo":"","Applogo":"/2016/09/28/20160928_052554_970.png","Enabled":true,"SeqTime":"2016-03-10T11:41:18","Id":7,"IsDel":false,"CreateTime":"2016-09-28T17:25:56.877","CreateMan":null,"DelTime":"1753-01-01T00:00:00","DelMan":null},{"Name":"京东","Token":"jd","OnlineUrl":"","SiteUrl":"http://www.jd.com/","Abstract":"综合网购首选","Logo":"","Applogo":"/2016/09/28/20160928_052444_572.png","Enabled":true,"SeqTime":"2016-03-09T11:31:32","Id":1,"IsDel":false,"CreateTime":"2016-09-28T17:24:46.717","CreateMan":null,"DelTime":"1753-01-01T00:00:00","DelMan":null},{"Name":"苹果中国","Token":"apple","OnlineUrl":"","SiteUrl":"http://www.apple.com/cn/","Abstract":"Apple","Logo":"","Applogo":"/2016/09/28/20160928_052412_049.png","Enabled":true,"SeqTime":"2016-03-08T00:00:00","Id":11,"IsDel":false,"CreateTime":"2016-11-27T10:36:01.183","CreateMan":null,"DelTime":"1753-01-01T00:00:00","DelMan":null},{"Name":"其他","Token":"qita","OnlineUrl":"","SiteUrl":"http://www.lapin365.com/","Abstract":"其他分类。","Logo":"","Applogo":"/2016/11/25/20161125_120415_423.png","Enabled":true,"SeqTime":"2016-02-21T16:28:00","Id":15,"IsDel":false,"CreateTime":"2016-11-26T17:29:08.7","CreateMan":null,"DelTime":"1753-01-01T00:00:00","DelMan":null}]
     */

    private boolean success;
    private Object message;
    /**
     * Name : 淘宝
     * Token : taobao
     * OnlineUrl :
     * SiteUrl : www.taobao.com
     * Abstract : null
     * Logo :
     * Applogo : /2016/11/26/20161126_052803_480.png
     * Enabled : true
     * SeqTime : 2016-11-26T16:42:36
     * Id : 17
     * IsDel : false
     * CreateTime : 2016-11-26T17:28:05.263
     * CreateMan : null
     * DelTime : 1753-01-01T00:00:00
     * DelMan : null
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
        private String Name;
        private String Token;
        private String OnlineUrl;
        private String SiteUrl;
        private Object Abstract;
        private String Logo;
        private String Applogo;
        private boolean Enabled;
        private String SeqTime;
        private int Id;
        private boolean IsDel;
        private String CreateTime;
        private Object CreateMan;
        private String DelTime;
        private Object DelMan;

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public String getToken() {
            return Token;
        }

        public void setToken(String Token) {
            this.Token = Token;
        }

        public String getOnlineUrl() {
            return OnlineUrl;
        }

        public void setOnlineUrl(String OnlineUrl) {
            this.OnlineUrl = OnlineUrl;
        }

        public String getSiteUrl() {
            return SiteUrl;
        }

        public void setSiteUrl(String SiteUrl) {
            this.SiteUrl = SiteUrl;
        }

        public Object getAbstract() {
            return Abstract;
        }

        public void setAbstract(Object Abstract) {
            this.Abstract = Abstract;
        }

        public String getLogo() {
            return Logo;
        }

        public void setLogo(String Logo) {
            this.Logo = Logo;
        }

        public String getApplogo() {
            return Applogo;
        }

        public void setApplogo(String Applogo) {
            this.Applogo = Applogo;
        }

        public boolean isEnabled() {
            return Enabled;
        }

        public void setEnabled(boolean Enabled) {
            this.Enabled = Enabled;
        }

        public String getSeqTime() {
            return SeqTime;
        }

        public void setSeqTime(String SeqTime) {
            this.SeqTime = SeqTime;
        }

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

        public boolean isIsDel() {
            return IsDel;
        }

        public void setIsDel(boolean IsDel) {
            this.IsDel = IsDel;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }

        public Object getCreateMan() {
            return CreateMan;
        }

        public void setCreateMan(Object CreateMan) {
            this.CreateMan = CreateMan;
        }

        public String getDelTime() {
            return DelTime;
        }

        public void setDelTime(String DelTime) {
            this.DelTime = DelTime;
        }

        public Object getDelMan() {
            return DelMan;
        }

        public void setDelMan(Object DelMan) {
            this.DelMan = DelMan;
        }
    }
}
