package com.itdr.utils;

public class PathUTil {
    public static  String getPath(String path){
        // 把/list.do里的.换成/
        String s1=path.replace(".","/");
        String[] sar=s1.split("/");
        return sar[1];

//       遍历拿到所有值
//      for(int i=0;i<sar.length;i++){
//            System.out.println(sar[i]);
//        }

    }
}
