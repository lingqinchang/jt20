package service.user;

import entity.User;
import util.ResultData;

public interface UserService {
	  //验证用户名是否可用
	  public ResultData isLoginNameExist(String loginName);
	  //添加用户信息
	  public ResultData addUser(User user);
	  //登录验证
	  public ResultData login(String longName,String password);
}
