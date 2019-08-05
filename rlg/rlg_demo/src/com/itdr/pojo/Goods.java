package com.itdr.pojo;

public class Goods {
    private Integer id;
    private String gname;
    private String subtitle;
    private String mainImage;
    private double price;

    public Integer getGid() {
        return id;
    }

    public void setGid(Integer gid) {
        this.id = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", gname='" + gname + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", mainImage='" + mainImage + '\'' +
                ", price=" + price +
                '}';
    }
}
