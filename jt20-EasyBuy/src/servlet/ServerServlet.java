package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import service.product.ProductService;
import service.product.ProductServiceImpl;
import util.Page;
import util.ResultData;

@WebServlet("/server")
public class ServerServlet extends HttpServlet {
	private final Integer SIZE = 5; //每页显示记录数
	private ProductService ps;
	public ServerServlet(){
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
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String method = req.getParameter("method");
		if("getCategorys".equals(method)){
			getCategorys(req, resp);
		}
		if("loadCate".equals(method)){
			loadCate(req, resp);
		}
		if("loadParentType".equals(method)){
			loadParentType(req, resp);
		}
	}
	public void loadParentType(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ResultData rd = new ResultData();
		Integer parentId = Integer.valueOf(req.getParameter("parentId"));
		rd = ps.getCategoryByParentId(parentId);
		System.out.println(JSON.toJSONString(rd));
		resp.getWriter().write(JSON.toJSONString(rd));
	}
	//加载所有的一级商品类别
	public void loadCate(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ResultData rd = new ResultData();
		Integer type = Integer.valueOf(req.getParameter("type"));
		rd = ps.getCategoryByType2(type);
		System.out.println(JSON.toJSONString(rd));
		resp.getWriter().write(JSON.toJSONString(rd));
		
	}
	//加载所有的商品类别
	public void getCategorys(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//创建分页对象
		Page page = new Page();
		//准备分页属性
		Integer n = Integer.valueOf(req.getParameter("n"));//页码
		Integer totalSize = ps.getCategoryCount();//总记录数
		Integer totalPage = totalSize%SIZE==0?totalSize/SIZE:totalSize/SIZE+1;
		
		//如果页码为1,设置一个循环的起始值
		if(n == 1){
			req.setAttribute("startNum",0);
		}else if(n==totalPage){
			req.setAttribute("startNum",totalPage%3==0?totalPage-3:totalPage-(totalPage%3));
		}else{
			Integer startNum = Integer.valueOf(req.getParameter("startNum"));
			req.setAttribute("startNum", startNum);
		}
		
		//判断是否是单击更多
		String flag = req.getParameter("flag");
		if(flag != null){
			Integer startNum = Integer.valueOf(req.getParameter("startNum"));
			if(startNum+3<totalPage)
			req.setAttribute("startNum", startNum+3);
		}
		page.setN(n);
		page.setSize(SIZE);
		page.setTotalPage(totalPage);
		page.setTotalSize(totalSize);
		ResultData rd = new ResultData();
		rd = ps.getCategorysByPage(page);
		req.setAttribute("p",page);
		req.setAttribute("rd",rd);
		
		req.getRequestDispatcher("/ser/productCategory.jsp").forward(req, resp);
	}
	
}
