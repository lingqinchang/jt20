package servlet;
import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import entity.User;

import service.user.UserService;
import service.user.UserServiceImpl;
import util.ResultData;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
	//业务对象
	private UserService us;
	public UserServlet(){
		us = new UserServiceImpl();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String method = req.getParameter("method");
		if("isLoginName".equals(method)){
			//验证用户名是否存在
			isLoginName(req, resp);
		}
		if("reg".equals(method)){
			//注册
			reg(req, resp);
		}
		if("login".equals(method)){
			//登录
			login(req, resp);
		}
		if("logout".equals(method)){
			logout(req, resp);
		}
	}
	//注销操作
	public void logout(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getSession().invalidate();
		resp.sendRedirect(req.getContextPath()+"/pro/Login.jsp");
	}
	
	//登录操作
	public void login(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String loginName = req.getParameter("loginName");
		String password = req.getParameter("password");
		ResultData rd = us.login(loginName, password);
		if(rd.getFlag() == 0){
			req.getSession(true).setAttribute("user",rd.getData());
			System.out.println((User)req.getSession().getAttribute("user"));
		}
		resp.getWriter().write(JSON.toJSONString(rd));
	}
	
	//验证用户名
	public void isLoginName(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//获取用户名
		String loginName = req.getParameter("loginName");
		ResultData rd = us.isLoginNameExist(loginName);
		//通过fastJsno把对象转成json字符串
		String json = JSON.toJSONString(rd);
		System.out.println(json);
		//通过响应对象的输出流把数据传到客户端
		resp.getWriter().write(json);
	}
	
	//用户注册
	public void reg(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		User user = new User();
		user.setEmail(req.getParameter("email"));
		user.setIdentityCode(req.getParameter("identityCode"));
		user.setLoginName(req.getParameter("loginName"));
		user.setMobile(req.getParameter("mobile"));
		user.setPassword(req.getParameter("password"));
		user.setType(0);
		user.setUserName(req.getParameter("userName"));
		user.setSex(Integer.parseInt(req.getParameter("sex")));
		System.out.println(user);
		ResultData rd = us.addUser(user);
		resp.getWriter().write(JSON.toJSONString(rd));
	}
	
}
