package dao.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import util.UtilClass;

import dao.BaseDao;
import entity.User;

public class UserDaoImpl extends BaseDao implements UserDao {
	
	public User getUserByResultSet(ResultSet rs) throws SQLException{
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setEmail(rs.getString("email"));
		user.setLoginName(rs.getString("loginName"));
		user.setMobile(rs.getString("mobile"));
		user.setPassword(rs.getString("password"));
		user.setType(rs.getInt("type"));
		user.setSex(rs.getInt("sex"));
		user.setIdentityCode(rs.getString("identityCode"));
		user.setUserName(rs.getString("username"));
		return user;
	}
	
	//根据用户名查找用户对象
	public User getUserByLoginName(String sql,Object[] params) {
		ResultSet rs = null;
		try {
			rs = queryData(sql, params);
			if(rs != null){
				if(rs.next()){
					return getUserByResultSet(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			UtilClass.close(conn, ps, rs);
		}
		return null;
	}

	@Override
	public int addUser(String sql,Object[] params) {
		try {
			return updateData(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			UtilClass.close(conn, ps);
		}
		return 0;
	}

}
