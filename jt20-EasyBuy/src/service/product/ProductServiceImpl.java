package service.product;

import java.util.List;

import org.junit.Test;

import dao.product.ProductDao;
import dao.product.ProductDaoImpl;
import entity.Category;
import entity.Product;
import util.Page;
import util.ResultData;

public class ProductServiceImpl implements ProductService {
	private ProductDao pd;
	public ProductServiceImpl(){
		pd = new ProductDaoImpl();
	}
	@Override
	public ResultData getCategoryByType(Integer type) {
		String sql = "select * from easybuy_product_category where type=?";
		Object[] params = {type};
		List<Category> cs = pd.getCategorieByType(sql, params);
		ResultData rd = new ResultData();
		rd.setFlag(0);
		rd.setData(cs);
		return rd;
	}
	
	@Override
	public ResultData getCategorysByPage(Page page) {
		String sql = "SELECT e.*,e2.`name` AS parentName FROM easybuy_product_category e LEFT JOIN easybuy_product_category e2 ON(e.`parentId`=e2.`id`) ORDER BY TYPE LIMIT ?,?";
		Object[] params = {(page.getN()-1)*page.getSize(),page.getSize()};
		ResultData rd = new ResultData();
		List<Category> cs = pd.getCategoriesByPage(sql, params);
		rd.setFlag(0);
		rd.setData(cs);
		return rd;
	}
	@Override
	public int getCategoryCount() {
		String sql = "select count(*) as count from easybuy_product_category";
		return pd.getCategoryCount(sql, null);
	}
	
	@Test
	public void test1(){
		ResultData rd = getCategoryByType(1);
		List<Category> cs =(List<Category>)rd.getData();
		for(Category c:cs){
			System.out.println(c.getName());
			for(Category c1:c.getCs()){
				System.out.println("\t"+c1.getName());
				for(Category c2:c1.getCs()){
					System.out.println("\t\t"+c2.getName());
				}
			}
			for(Product p:c.getPs()){
				System.out.println("------------>"+p.getName());
			}
		}
	}
	@Override
	public ResultData getCategoryByType2(Integer type) {
		String sql="select*from easybuy_product_category where type=?";
		Object[] params={type};
		List<Category> cs=pd.getCategorieByType2(sql, params);
		ResultData rd=new ResultData();
		rd.setFlag(0);
		rd.setData(cs);
		return rd;
	}
	@Override
	public ResultData getCategoryByParentId(Integer parentId) {
		    String sql="select*from easybuy_product_category where parentId=?";
		    Object[] params={parentId};
		    List<Category> cs=pd.getCategorieByType2(sql, params);
		    ResultData rd=new ResultData();
		    rd.setFlag(0);
		    rd.setData(cs);
		    return rd;		
	}
	
}
