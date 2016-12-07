package com.example.administrator.lapin.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/12/5.
 */
public class GoodCategoryBean implements Serializable{

    /**
     * success : true
     * message : 认证成功
     * content : [{"Id":73,"Name":"男装","Token":"nanzhuang","Logo":"/2016/10/27/20161027_042007_674.png"},{"Id":52,"Name":"居家生活","Token":"jujia","Logo":"/2016/10/27/20161027_042021_701.png"},{"Id":49,"Name":"家用电器","Token":"jiadian","Logo":"/2016/10/27/20161027_042029_830.png"},{"Id":36,"Name":"手机配件","Token":"shoujipeijian","Logo":"/2016/10/27/20161027_042037_543.png"},{"Id":98,"Name":"影音娱乐","Token":"yingyin","Logo":"/2016/10/27/20161027_042105_179.png"},{"Id":2,"Name":"手机","Token":"shouji","Logo":"/2016/10/27/20161027_041807_565.png"},{"Id":183,"Name":"家具建材","Token":"jiajujiancai","Logo":"/2016/11/29/20161129_050646_851.png"},{"Id":165,"Name":"母婴玩具","Token":"muyingwanju","Logo":"/2016/11/18/20161118_050529_201.png"},{"Id":154,"Name":"食品饮品","Token":"shipinyinpin","Logo":"/2016/11/18/20161118_103645_762.png"},{"Id":138,"Name":"医药保健","Token":"yiliaobaojian","Logo":"/2016/10/27/20161027_042136_627.png"},{"Id":110,"Name":"个护化妆","Token":"gehuhuazhuang","Logo":"/2016/10/27/20161027_042147_695.png"},{"Id":108,"Name":"办公文教","Token":"bangongwenjiao","Logo":"/2016/10/27/20161027_042210_863.png"},{"Id":106,"Name":"智能设备","Token":"zhinengshebei","Logo":"/2016/10/27/20161027_042320_898.png"},{"Id":104,"Name":"游戏设备","Token":"youxishebei","Logo":"/2016/10/27/20161027_043107_094.png"},{"Id":88,"Name":"箱包饰品","Token":"xiangbaoshipin","Logo":"/2016/10/27/20161027_043122_912.png"},{"Id":81,"Name":"女装","Token":"nvzhuang","Logo":"/2016/10/27/20161027_043131_753.png"},{"Id":50,"Name":"图书","Token":"tushu","Logo":"/2016/11/18/20161118_104912_993.png"},{"Id":6,"Name":"电脑硬件","Token":"diannao","Logo":"/2016/10/27/20161027_043155_680.png"}]
     */

    private boolean success;
    private String message;
    /**
     * Id : 73
     * Name : 男装
     * Token : nanzhuang
     * Logo : /2016/10/27/20161027_042007_674.png
     */

    private List<ContentBean> content;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ContentBean> getContent() {
        return content;
    }

    public void setContent(List<ContentBean> content) {
        this.content = content;
    }

    public static class ContentBean implements Serializable{
        private int Id;
        private String Name;
        private String Token;
        private String Logo;

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

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

        public String getLogo() {
            return Logo;
        }

        public void setLogo(String Logo) {
            this.Logo = Logo;
        }
    }
}
