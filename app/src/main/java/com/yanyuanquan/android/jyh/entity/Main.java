package com.yanyuanquan.android.jyh.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;

/**
 * Created by apple on 16/3/14.
 */
public class Main extends BaseData {

    private String status;
    private int newincluded;

    private List<DataEntity> data;

    @Override
    public String toString() {
        return "Main{" +
                "status='" + status + '\'' +
                ", newincluded=" + newincluded +
                ", data=" + data +
                '}';
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setNewincluded(int newincluded) {
        this.newincluded = newincluded;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public int getNewincluded() {
        return newincluded;
    }

    public List<DataEntity> getData() {
        return data;
    }

    public static class DataEntity implements Serializable {
        private int id;
        private String title;
        private String pubtime;

        private String image;
        private int imgw;
        private int imgh;
        private int iftobuy;
        private String fromsite;
        private String country;
        private String mall;
        private String buyurl;

        @Override
        public String toString() {
            return "DataEntity{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", pubtime='" + pubtime + '\'' +
                    ", image='" + image + '\'' +
                    ", imgw=" + imgw +
                    ", imgh=" + imgh +
                    ", iftobuy=" + iftobuy +
                    ", fromsite='" + fromsite + '\'' +
                    ", country='" + country + '\'' +
                    ", mall='" + mall + '\'' +
                    ", buyurl='" + buyurl + '\'' +
                    ", dealfeature='" + dealfeature + '\'' +
                    ", cates=" + cates +
                    '}';
        }

        private String dealfeature;
        private Object cates;

        public void setId(int id) {
            this.id = id;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setPubtime(String pubtime) {
            this.pubtime = pubtime;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public void setImgw(int imgw) {
            this.imgw = imgw;
        }

        public void setImgh(int imgh) {
            this.imgh = imgh;
        }

        public void setIftobuy(int iftobuy) {
            this.iftobuy = iftobuy;
        }

        public void setFromsite(String fromsite) {
            this.fromsite = fromsite;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public void setMall(String mall) {
            this.mall = mall;
        }

        public void setBuyurl(String buyurl) {
            this.buyurl = buyurl;
        }

        public void setDealfeature(String dealfeature) {
            this.dealfeature = dealfeature;
        }

        public void setCates(List<String> cates) {
            this.cates = cates;
        }

        public int getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getPubtime() {
            return pubtime;
        }

        public String getImage() {
            return image;
        }

        public int getImgw() {
            return imgw;
        }

        public int getImgh() {
            return imgh;
        }

        public int getIftobuy() {
            return iftobuy;
        }

        public String getFromsite() {
            return fromsite;
        }

        public String getCountry() {
            return country;
        }

        public String getMall() {
            return mall;
        }

        public String getBuyurl() {
            return buyurl;
        }

        public String getDealfeature() {
            return dealfeature;
        }

        public Object getCates() {
            return cates;
        }


    }
}
