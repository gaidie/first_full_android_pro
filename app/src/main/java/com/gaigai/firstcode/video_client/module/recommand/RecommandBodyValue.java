package com.gaigai.firstcode.video_client.module.recommand;

import com.gaigai.firstcode.video_client.module.BaseModel;

import java.util.ArrayList;

/**
 * Created by ga on 2017/2/16.
 */

public class RecommandBodyValue extends BaseModel {

   /* "from": " 来自北京|德外大街",
            "info": "2",
            "logo": "http://img3.duitang.com/uploads/item/201407/01/20140701222607_AnKfj.thumb.224_0.jpeg",
            "price": "$2400",
            "text": "来慕课网,你可以学到任何你想学的知识.看视频还不够？别担心，我们还有大神手把手教你。",
            "title": "qndroid",
            "type": 1,
            "url": [
            "http://img.mukewang.com/549bda090001c53e06000338-590-330.jpg",
            "http://img.mukewang.com/5707604300018d0406000338-590-330.jpg",
            "http://articles.csdn.net/uploads/allimg/150617/6_150617172820_1.png",
            "http://f1.diyitui.com/b3/e1/db/5f/24/ea/d8/59/1e/ea/28/04/b3/57/d6/6f.jpg",
            "http://upload1.techweb.com.cn/s/320/2015/0527/1432714922459.jpg"
            ],
            "zan": "5"*/

    public String from;//来自
    public String info;
    public String price;
    public String logo;//图标
    public String text;//介绍
    public String title;
    public int type;//类型
    public String zan;
    public ArrayList<String> url;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getZan() {
        return zan;
    }

    public void setZan(String zan) {
        this.zan = zan;
    }

    public ArrayList<String> getUrl() {
        return url;
    }

    public void setUrl(ArrayList<String> url) {
        this.url = url;
    }
}
