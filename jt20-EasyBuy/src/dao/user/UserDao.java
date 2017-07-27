package dao.user;
import entity.User;
public interface UserDao {
    //根据用户名去查找用户对象
	public User getUserByLoginName(String sql,Object[] params);
	//添加用户信息
	public int addUser(String sql,Object[] params);
}
