package dao.product;

import java.util.List;

import entity.Category;

public interface ProductDao {
	
	//根据商品的级别加载商品类别
	public List<Category> getCategorieByType(String sql,Object[] params);
	
	//加载所有的商品分类信息
	public List<Category> getCategoriesByPage(String sql,Object[] params);

	//获取商品类别总记录数
	public int getCategoryCount(String sql,Object[] params);
	
	//获取指定级别的商品类别
	public List<Category> getCategorieByType2(String sql,Object[] params);
	
}
