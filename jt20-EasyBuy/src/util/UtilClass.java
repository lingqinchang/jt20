package util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class UtilClass {
	/*public static void main(String[] args) {
		System.out.println(getConnection());
	}*/
	//获取数据库连接对象
	public static Connection getConnection(){
		try {
			Class.forName(getProValue("driverClass"));
			String url = getProValue("url");
			String user = getProValue("user");
			String password = getProValue("password");
			Connection conn = DriverManager.getConnection(url,user,password);
			return conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//通过连接池的方式获取连接对象
	public static Connection getJNDIConnection(){
		//获取Context上下文环境对象
		try {
			Context ctx = new InitialContext();
			DataSource ds  = (DataSource)ctx.lookup("java:comp/env/jdbc/easybuy");
			return ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//获取properties文件属性
	public static String getProValue(String key){
		//创建一个properties对象
		Properties properties = new Properties();
		try {
			//把对应文件加载内存
			properties.load(UtilClass.class.getClassLoader().getResourceAsStream("db.properties"));
			//根据key获取对应的value值
			String value = properties.getProperty(key);
			return value;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//释放资源
	public static void close(Connection conn,PreparedStatement ps,ResultSet rs){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(ps != null){
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Connection conn,PreparedStatement ps){
		if(ps != null){
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//md5加密
	public static String getMD5String(String str){
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("md5");
			md.update(str.getBytes());
			return new BigInteger(1,md.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public static void main(String[] args) throws NoSuchAlgorithmException {
		System.out.println(getMD5String("123456"));
	}
	
}
