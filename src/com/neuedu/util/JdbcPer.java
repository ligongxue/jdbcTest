package com.neuedu.util;

import com.mysql.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcPer {
    public  static final String url="jdbc:mysql://127.0.0.1:3306/jdbc?useUnicode=true&characterEncoding=utf8";
    public static final String ROOT="root";
    public static final String PDW="root";
    static{
        try {
            new Driver();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//封装数据库链接
    public static Connection getConnection(){
        Connection conn=null;
        try {
            conn= DriverManager.getConnection(url,ROOT,PDW);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }


    public static <T> List<T> executeQuery(String sql, RowMap<T> rowMap, Object...objs){
        List<T> lists=new ArrayList<>();
        Connection conn=null;
        PreparedStatement pstm=null;
        ResultSet rs=null;
        conn=getConnection();
        try {
            pstm=conn.prepareStatement(sql);
            for(int i=0; i<objs.length; i++){
                pstm.setObject(i+1,objs[i]);
            }
            rs=pstm.executeQuery();
            while(rs.next()){
                //拿到rs 返回出 当前类型的对象T
                T t=rowMap.rowMapping(rs);
                lists.add(t);

            }
        } catch (SQLException e) {
        }

        return lists;
    }
    //插入的方法
    //对增删改封装的一个方法，不用写别的方法了 对任意数据库进行增删改的操作-------对数据库操作的工具类
    public static  int executUpate(String sql,Object...objs){
        Connection conn= null;
        PreparedStatement pstm=null;
        int result=0;
        conn=getConnection();
        try {
//            conn=DriverManager.getConnection(url,ROOT,PDW);
            pstm=  conn.prepareStatement(sql);//创建窗口
            if ( objs!=null ){
                for (int i=0;i<objs.length;i++){
                    pstm.setObject(i+1,objs[i]);
                }
            }
            result=  pstm.executeUpdate();//增删改的语句
            System.out.println(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(null,pstm,conn);
        }
        return  result;
    }
    public static void close(ResultSet rs,PreparedStatement pstm,Connection conn){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(pstm!=null){
            try {
                pstm .close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
