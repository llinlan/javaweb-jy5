package com.itdr.common;

public class ResponseCode<T> {
        private Integer status;
        private  T data;
        private String mag;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMag() {
        return mag;
    }

    public void setMag(String mag) {
        this.mag = mag;
    }

    @Override
    public String toString() {
        return "ResponseCode{" +
                "status=" + status +
                ", data=" + data +
                ", mag='" + mag + '\'' +
                '}';
    }


    //成功的时候只要返回状态码和成功获取的数据就可以了
    // 泛型类写在类名后面，泛型接口接口后面，泛型方法写在返回类型前面
    public static <T> ResponseCode successRs(Integer status , T data){
        ResponseCode rs=new ResponseCode();
        rs.setStatus(status);
        rs.setData(data);
        return rs;
    }
    //重写成功
    public static <T> ResponseCode successRs( T data){
        ResponseCode rs=new ResponseCode();
        rs.setStatus(0);
        rs.setData(data);
        return rs;
    }
    //失败的时候只要返回状态码和失败的信息就可以了
    public static <T> ResponseCode defateRs(Integer status ,String mag){
        ResponseCode rs=new ResponseCode();
        rs.setStatus(status);
        rs.setMag(mag);
        return rs;
    }
}
