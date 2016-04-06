package com.yanyuanquan.android.jyh.entity;

import java.util.List;

/**
 * Created by apple on 16/3/21.
 */
public class TrankList extends BaseData {

    /**
     * status : ok
     * rankhour : 21
     * rankdate : 2016-03-21
     * displaydate : 今日
     * rankduring : 20:00-21:00
     * hasnexthour : 0
     * nexthourhour :
     * nexthourdate :
     * lasthourhour : 20
     * lasthourdate : 20160321
     * data : [{"id":2363503,"rank":1,"title":"清仓！阿迪达斯 neo 男子 休闲鞋 GAE63 天猫商城207元包邮","pubtime":"2016-03-21 19:55:14","image":"http://7bv7rb.com1.z0.glb.clouddn.com/2920961ce731f1cc9ab50f67d60f90da.jpg","imgw":170,"imgh":170,"fromsite":"识货","mall":"天猫","iftobuy":1,"buyurl":"https://detail.tmall.com/item.htm?id=522562044725","dealfeature":0},{"id":2363581,"rank":2,"title":"Coggles Asics专场大促！精选球鞋 额外8折！","pubtime":"2016-03-21 20:20:12","image":"http://7bv7rb.com1.z0.glb.clouddn.com/79304867b959dd93c00c48dbbbf9acb9.jpg","imgw":375,"imgh":375,"fromsite":"惠惠网","mall":"","iftobuy":1,"buyurl":"http://guangdiu.com/go.php?id=2363581","dealfeature":0},{"id":2363431,"rank":3,"title":"加大码好价！阿迪达斯 neo 男子 外套 黑 M31988 天猫商城250元包邮","pubtime":"2016-03-21 19:33:22","image":"http://7bv7rb.com1.z0.glb.clouddn.com/af89e11d0d78b700d0813fb3493bc4fc.jpg","imgw":170,"imgh":170,"fromsite":"识货","mall":"天猫","iftobuy":1,"buyurl":"https://detail.tmall.com/item.htm?id=42432384470","dealfeature":0},{"id":2363459,"rank":4,"title":"戴利普 USB排插线板 19.9元包邮","pubtime":"2016-03-21 19:42:08","image":"http://7bv7rb.com1.z0.glb.clouddn.com/66aa6e617171442b02a9c9c09eb6c31e.jpg","imgw":430,"imgh":430,"fromsite":"超值分享汇","mall":"天猫","iftobuy":1,"buyurl":"https://detail.tmall.com/item.htm?id=528111744773","dealfeature":0},{"id":2363382,"rank":5,"title":"NETGEAR 美国网件 R2000 N300M 无线路由器 159元包邮","pubtime":"2016-03-21 19:16:13","image":"http://7bv7rb.com1.z0.glb.clouddn.com/38bf9b8549c30b718e4c1ff07ea49321.jpg","imgw":480,"imgh":480,"fromsite":"今日值得买","mall":"亚马逊中国","iftobuy":1,"buyurl":"http://www.amazon.cn/dp/B015ZAPZ36?t=ygk-23&tag=ygk-23","dealfeature":0},{"id":2363435,"rank":6,"title":"479.00元 NIKE 耐克 新款男子AIRMAXTAILWIND8跑步鞋805941-400","pubtime":"2016-03-21 19:35:17","image":"http://7bv7rb.com1.z0.glb.clouddn.com/77fbf62316a700c90eff2aadf7392457.jpg","imgw":250,"imgh":250,"fromsite":"没得比","mall":"优购网","iftobuy":1,"buyurl":"http://guangdiu.com/go.php?id=2363435","dealfeature":0},{"id":2363383,"rank":7,"title":"NEW BALANCE 574 中性复古鞋 ￥359","pubtime":"2016-03-21 19:18:05","image":"http://7bv7rb.com1.z0.glb.clouddn.com/73e269fed678393452153778af0bbf3d.jpg","imgw":350,"imgh":350,"fromsite":"买个便宜货","mall":"尚品网","iftobuy":1,"buyurl":"http://guangdiu.com/go.php?id=2363383","dealfeature":0},{"id":2363504,"rank":8,"title":"加绒设计！阿迪达斯 NEO 女子 休闲鞋 GAH08 天猫商城157元包邮","pubtime":"2016-03-21 19:55:14","image":"http://7bv7rb.com1.z0.glb.clouddn.com/895830bf93459b2841c44d4786995b6c.jpg","imgw":170,"imgh":170,"fromsite":"识货","mall":"天猫","iftobuy":1,"buyurl":"https://detail.tmall.com/item.htm?id=522077762657","dealfeature":0},{"id":2363406,"rank":9,"title":"KOLLIE 可奈尔 高密度海绵床垫 180*200CM 299元包邮（双重优惠）","pubtime":"2016-03-21 19:24:11","image":"http://7bv7rb.com1.z0.glb.clouddn.com/6195bbbc79c78bc99a0e2965217e1de2.jpg","imgw":381,"imgh":384,"fromsite":"今日值得买","mall":"京东商城","iftobuy":1,"buyurl":"http://guangdiu.com/go.php?id=2363406","dealfeature":0},{"id":2363394,"rank":10,"title":"彭友家私 茶几 柚木色 PY-B18*2张 198元包邮（双重优惠）","pubtime":"2016-03-21 19:20:14","image":"http://7bv7rb.com1.z0.glb.clouddn.com/e50c7341bbfe997023215711cbe065f4.jpg","imgw":350,"imgh":350,"fromsite":"今日值得买","mall":"京东商城","iftobuy":1,"buyurl":"http://guangdiu.com/go.php?id=2363394","dealfeature":0}]
     */

    private String status;
    private String rankhour;
    private String rankdate;
    private String displaydate;
    private String rankduring;
    private String hasnexthour;
    private String nexthourhour;
    private String nexthourdate;

    @Override
    public String toString() {
        return "TrankList{" +
                "status='" + status + '\'' +
                ", rankhour='" + rankhour + '\'' +
                ", rankdate='" + rankdate + '\'' +
                ", displaydate='" + displaydate + '\'' +
                ", rankduring='" + rankduring + '\'' +
                ", hasnexthour='" + hasnexthour + '\'' +
                ", nexthourhour='" + nexthourhour + '\'' +
                ", nexthourdate='" + nexthourdate + '\'' +
                ", lasthourhour='" + lasthourhour + '\'' +
                ", lasthourdate='" + lasthourdate + '\'' +
                ", data=" + data +
                '}';
    }

    private String lasthourhour;
    private String lasthourdate;
    /**
     * id : 2363503
     * rank : 1
     * title : 清仓！阿迪达斯 neo 男子 休闲鞋 GAE63 天猫商城207元包邮
     * pubtime : 2016-03-21 19:55:14
     * image : http://7bv7rb.com1.z0.glb.clouddn.com/2920961ce731f1cc9ab50f67d60f90da.jpg
     * imgw : 170
     * imgh : 170
     * fromsite : 识货
     * mall : 天猫
     * iftobuy : 1
     * buyurl : https://detail.tmall.com/item.htm?id=522562044725
     * dealfeature : 0
     */

    private List<DataEntity> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRankhour() {
        return rankhour;
    }

    public void setRankhour(String rankhour) {
        this.rankhour = rankhour;
    }

    public String getRankdate() {
        return rankdate;
    }

    public void setRankdate(String rankdate) {
        this.rankdate = rankdate;
    }

    public String getDisplaydate() {
        return displaydate;
    }

    public void setDisplaydate(String displaydate) {
        this.displaydate = displaydate;
    }

    public String getRankduring() {
        return rankduring;
    }

    public void setRankduring(String rankduring) {
        this.rankduring = rankduring;
    }

    public String getHasnexthour() {
        return hasnexthour;
    }

    public void setHasnexthour(String hasnexthour) {
        this.hasnexthour = hasnexthour;
    }

    public String getNexthourhour() {
        return nexthourhour;
    }

    public void setNexthourhour(String nexthourhour) {
        this.nexthourhour = nexthourhour;
    }

    public String getNexthourdate() {
        return nexthourdate;
    }

    public void setNexthourdate(String nexthourdate) {
        this.nexthourdate = nexthourdate;
    }

    public String getLasthourhour() {
        return lasthourhour;
    }

    public void setLasthourhour(String lasthourhour) {
        this.lasthourhour = lasthourhour;
    }

    public String getLasthourdate() {
        return lasthourdate;
    }

    public void setLasthourdate(String lasthourdate) {
        this.lasthourdate = lasthourdate;
    }

    public List<DataEntity> getData() {
        return data;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public static class DataEntity {
        private int id;
        private int rank;
        private String title;
        private String pubtime;
        private String image;
        private int imgw;

        @Override
        public String toString() {
            return "DataEntity{" +
                    "id=" + id +
                    ", rank=" + rank +
                    ", title='" + title + '\'' +
                    ", pubtime='" + pubtime + '\'' +
                    ", image='" + image + '\'' +
                    ", imgw=" + imgw +
                    ", imgh=" + imgh +
                    ", fromsite='" + fromsite + '\'' +
                    ", mall='" + mall + '\'' +
                    ", iftobuy=" + iftobuy +
                    ", buyurl='" + buyurl + '\'' +
                    ", dealfeature=" + dealfeature +
                    '}';
        }

        private int imgh;
        private String fromsite;
        private String mall;
        private int iftobuy;
        private String buyurl;
        private int dealfeature;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPubtime() {
            return pubtime;
        }

        public void setPubtime(String pubtime) {
            this.pubtime = pubtime;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getImgw() {
            return imgw;
        }

        public void setImgw(int imgw) {
            this.imgw = imgw;
        }

        public int getImgh() {
            return imgh;
        }

        public void setImgh(int imgh) {
            this.imgh = imgh;
        }

        public String getFromsite() {
            return fromsite;
        }

        public void setFromsite(String fromsite) {
            this.fromsite = fromsite;
        }

        public String getMall() {
            return mall;
        }

        public void setMall(String mall) {
            this.mall = mall;
        }

        public int getIftobuy() {
            return iftobuy;
        }

        public void setIftobuy(int iftobuy) {
            this.iftobuy = iftobuy;
        }

        public String getBuyurl() {
            return buyurl;
        }

        public void setBuyurl(String buyurl) {
            this.buyurl = buyurl;
        }

        public int getDealfeature() {
            return dealfeature;
        }

        public void setDealfeature(int dealfeature) {
            this.dealfeature = dealfeature;
        }
    }
}
