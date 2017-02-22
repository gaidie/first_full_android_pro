package com.gaigai.firstcode.video_client.module.recommand;

import com.gaigai.firstcode.video_client.module.BaseModel;

/**
 * Created by ga on 2017/2/16.
 */

public class RecommandFooterValue extends BaseModel {

    /**
     * {
     "destationUrl": "http://www.imooc.com/learn/677",
     "from": "来自上海的讲师",
     "imageOne": "http://i7.hexunimg.cn/2015-07-07/177346079.jpg",
     "imageTwo": "http://imgsrc.baidu.com/forum/w%3D580/sign=2ca8123a261f95caa6f592bef9167fc5/bc1cae51f81986188dd8f8c049ed2e738ad4e6da.jpg",
     "info": "jack大拿发布",
     "title": "5个新ios课程"
     }
     */
    public String title;
    public String info;
    public String from;
    public String imageOne;
    public String imageTwo;
    public String destationUrl;
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getImageOne() {
        return imageOne;
    }

    public void setImageOne(String imageOne) {
        this.imageOne = imageOne;
    }

    public String getImageTwo() {
        return imageTwo;
    }

    public void setImageTwo(String imageTwo) {
        this.imageTwo = imageTwo;
    }

    public String getDestationUrl() {
        return destationUrl;
    }

    public void setDestationUrl(String destationUrl) {
        this.destationUrl = destationUrl;
    }
}
