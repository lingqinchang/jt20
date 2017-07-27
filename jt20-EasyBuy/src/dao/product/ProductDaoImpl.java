package dao.product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import util.UtilClass;
import dao.BaseDao;
import entity.Category;
import entity.Product;

public class ProductDaoImpl extends BaseDao implements ProductDao {
	
	public Category getCategoryByResultSet(ResultSet rs) throws SQLException{
		Category c = new Category();
		c.setIconClass(rs.getString("iconClass"));
		c.setId(rs.getInt("id"));
		c.setName(rs.getString("name"));
		c.setParentId(rs.getInt("parentId"));
		c.setType(rs.getInt("type"));
		return c;
	}
	
	public Product getProductByResultSet(ResultSet rs)throws SQLException{
		Product p = new Product();
		p.setId(rs.getInt("id"));
		p.setCategoryLevel1Id(rs.getInt("categoryLevel1Id"));
		p.setCategoryLevel2Id(rs.getInt("categoryLevel2Id"));
		p.setCategoryLevel3Id(rs.getInt("categoryLevel3Id"));
		p.setDescription(rs.getString("description"));
		p.setFileName(rs.getString("fileName"));
		p.setIsDelete(rs.getInt("isDelete"));
		p.setName(rs.getString("name"));
		p.setStock(rs.getInt("stock"));
		p.setPrice(rs.getFloat("price"));
		return p;
	}
	
	@Override
	public List<Category> getCategorieByType(String sql,Object[] params) {
		ResultSet rs = null;
		List<Category> cs = new ArrayList<Category>();
		try {
			rs = queryData(sql, params);
			if(rs != null){
				while(rs.next()){
					Category c = new Category();
					//获取了级别为1的商品类别
					c = getCategoryByResultSet(rs);
					/**********************************************/
					String psql = "select * from easybuy_product where categoryLevel1Id = ?";
					Object[] pparams = {c.getId()};
					ResultSet prs = queryData(psql, pparams);
					if(prs != null){
						Set<Product> ps = new HashSet<Product>();
						while(prs.next()){
							Product p = new Product();
							p = getProductByResultSet(prs);
							ps.add(p);
						}
						c.setPs(ps);
					}
					/**********************************************/
					//根据1级类别商品的ID查找对应2级的商品类别
					String sql2 = "select * from easybuy_product_category where parentId=?";
					//拿到1级类型ID
					Object[] params2 = {c.getId()};
					ResultSet rs2 = queryData(sql2, params2);
					if(rs2 != null){
						//创建set集合用来保存2级类别集合
						Set<Category> cs2 = new HashSet<Category>();
						while(rs2.next()){
							//创建类别对象保存二级类别对象
							Category c2 = new Category();
							//获取二级类别的信息
							c2 = getCategoryByResultSet(rs2);
							//获取二级类别id
							Object[] params3 = {c2.getId()};
							ResultSet rs3 = queryData(sql2, params3);
							if(rs3 != null){
								//创建set集合用来保存3级类别集合
								Set<Category> cs3 = new HashSet<Category>();
								while(rs3.next()){
									//创建类别对象保存三级类别对象
									Category c3 = new Category();
									//获取三级类别信息
									c3 = getCategoryByResultSet(rs3);
									//把三级类别对象保存到set集合
									cs3.add(c3);
								}
								//把 三级类别集合设置到二级类别的set集合属性中
								c2.setCs(cs3);
							}
							//把二级类别对象保存到set集合
							cs2.add(c2);
						}
						//把 二级类别集合设置到一级类别的set集合属性中
						c.setCs(cs2);
					}
					cs.add(c);
				}
			}
			return cs;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			UtilClass.close(conn, ps, rs);
		}
		return null;
	}

	
	
	public List<Category> getCategoriesByPage(String sql, Object[] params) {
		ResultSet rs = null;
		List<Category> cs = new ArrayList<Category>();
		try {
			rs = queryData(sql, params);
			if(rs != null){
				while(rs.next()){
					Category c = new Category();
					c = getCategoryByResultSet(rs);
					c.setParentName(rs.getString("parentName"));	
					cs.add(c);
				}
			}
			return cs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	@Override
	public int getCategoryCount(String sql,Object[] params) {
		ResultSet rs = null;
		try {
			rs = queryData(sql, params);
			if(rs != null){
				if(rs.next()){
					return rs.getInt("count");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Category> getCategorieByType2(String sql, Object[] params) {
		ResultSet rs = null;
		List<Category> cs = new ArrayList<Category>();
		try {
			rs = queryData(sql, params);
			if(rs != null){
				while(rs.next()){
					Category c = new Category();
					c = getCategoryByResultSet(rs);	
					cs.add(c);
				}
			}
			return cs;
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return null;
	}

}

