package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.UtilClass;

public class BaseDao {
	public Connection conn;
	public PreparedStatement ps;
	//通用的查询方法
	public ResultSet queryData(String sql,Object[] params) throws SQLException{
		conn = UtilClass.getConnection();
		ps = conn.prepareStatement(sql);
		if(params != null){
			for(int i = 0;i<params.length;i++){
				ps.setObject((i+1),params[i]);
			}
		}
		return ps.executeQuery();
	}
	
	//通用的增删改方法
	public int updateData(String sql,Object[] params) throws SQLException{
		conn = UtilClass.getConnection();
		ps = conn.prepareStatement(sql);
		if(params != null){
			for(int i = 0;i<params.length;i++){
				ps.setObject((i+1),params[i]);
			}
		}
		return ps.executeUpdate();
	}
	
	
}
