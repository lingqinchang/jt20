package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Category;

import service.product.ProductService;
import service.product.ProductServiceImpl;
import util.ResultData;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
	private ProductService ps;
	public ProductServlet(){
		ps = new ProductServiceImpl();
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
		if("home".equals(method)){
			//进入首页
			goHome(req, resp);												
		}
	}
	
	public void goHome(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//获取商品分类的第一级别
		ResultData rd1 = ps.getCategoryByType(1);
		req.setAttribute("rd1",rd1);
		System.out.println(rd1);
		req.getRequestDispatcher("/pro/Index.jsp").forward(req,resp);
	}
}
