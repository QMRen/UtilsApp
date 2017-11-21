package com.example.admin.utilsapp.bean;

/**
 * Created by Woodslake on 2017/2/27.
 */

public class BannerBean {


    /**
     * id : 1
     * name : 畅享时贷banner
     * title : 呵呵呵
     * bannerUrl : https://testjkweb.tourongjia.com/images/banner/banner_cfd.png
     * linkUrl : https://testjkwap.tourongjia.com/#!/bannarOne
     * sort : 1
     * modifyTime : 1493033462000
     * createTime : 1491473456000
     */

    private int id;
    private String name;
    private String title;
    private String bannerUrl;
    private String linkUrl;
    private String sort;
    private long modifyTime;
    private long createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public long getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(long modifyTime) {
        this.modifyTime = modifyTime;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }
}
