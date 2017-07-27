package service.user;

import dao.user.UserDao;
import dao.user.UserDaoImpl;
import entity.User;
import util.ResultData;
import util.UtilClass;

public class UserServiceImpl implements UserService {
	//准备数据库对象
	private UserDao userDao;
	public UserServiceImpl(){
		userDao = new UserDaoImpl();
	}
	/**
	 * 验证用户名是否存在
	 * @param loginName 用户名
	 */
	public ResultData isLoginNameExist(String loginName) {
		ResultData rd = new ResultData();
		if("".equals(loginName)){ //空字符串判断
			rd.setFlag(1);
			return rd;
		}
		String sql = "select * from easybuy_user where loginName = ?";
		Object[] params = {loginName};
		User user = userDao.getUserByLoginName(sql, params);
		if(user != null){
			rd.setFlag(1);
		}else{
			rd.setFlag(0);
		}
		return rd;
	}
	//注册用户
	public ResultData addUser(User user) {
		ResultData rd = new ResultData();
		String sql = "insert into easybuy_user values(null,?,?,?,?,?,?,?,?)";
		Object[] params = {user.getLoginName(),user.getUserName(),UtilClass.getMD5String(user.getPassword()),user.getSex()
				,user.getIdentityCode(),user.getEmail(),user.getMobile(),user.getType()};
		int len = userDao.addUser(sql, params);
		if(len > 0){
			rd.setFlag(0);
		}else{
			rd.setFlag(1);
		}
		return rd;
	}
	//用户登录
		public ResultData login(String loginName, String password) {
			ResultData rd = new ResultData();
			String sql = "select * from easybuy_user where loginName = ?";
			Object[] params = {loginName};
			User user = userDao.getUserByLoginName(sql, params);
			if(user == null){
				rd.setFlag(1);
			}else{
				password = UtilClass.getMD5String(password);
				if(password.equals(user.getPassword())){
					rd.setFlag(0);
					rd.setData(user);
				}else{
					rd.setFlag(2);
				}
			}
			return rd;
		}
		
	
	
}
