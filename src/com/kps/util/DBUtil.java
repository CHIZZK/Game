package com.kps.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	static PreparedStatement   pre=null;
	static Connection  conn=null;
    static int num=-1;
    static ResultSet   rs=null;
    static String   username="root";
    static String   password="";
    static String   url="jdbc:mysql://localhost:3306/game?useUnicode=true&characterEncoding=utf-8";
    //连接驱动
public static   Connection    getConnection() {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection(url, username, password);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return conn;
	
}
//关闭连接
public static   void  closeAll(Connection  conn,PreparedStatement   pre,ResultSet  rs) {
	if (rs!=null) {
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	if (pre!=null) {
		try {
			pre.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	if (conn!=null) {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
//增删改通用方法
public static  boolean  executeUpdate(String sql,Object[] param) {
	conn=getConnection();
	try {
		pre=conn.prepareStatement(sql);
		//给占位符赋值
		if (param!=null) {
			for(int i=0;i<param.length;i++) {
				pre.setObject(i+1, param[i]);
			}
		}
		num=pre.executeUpdate();
		if (num>0) {
			return true;	
		}else {
			return false;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
	

	
}


	

}

